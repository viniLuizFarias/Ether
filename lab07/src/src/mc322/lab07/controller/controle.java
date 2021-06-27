package mc322.lab07.controller;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mc322.lab07.MainJogo;
import mc322.lab07.model.*;
import mc322.lab07.vision.ScreenInGame;
import mc322.lab07.vision.ScreenSelecaoDeck;

public class Controle {
    private Tabuleiro tabuleiro;
    private int numeroPAtual;
    private Jogador[] jogadores;
    private int turno;
    
    private int qtdDecksEscolhidos;
    
	private ScreenInGame screenInGame;
	private JFrame screenSelecaoDeck;
    private int tipoAcaoAnterior; // -1 -> nenhuma acao jogada, 0-> carta clicada, 1 -> celula clicada
    private int[] coordAcaoAnterior; 

    public Controle(int vida,Tabuleiro tabuleiro){

    	this.numeroPAtual = 0;
        this.tabuleiro = tabuleiro;
        tabuleiro.setControle(this);
        this.jogadores = new Jogador[2];
        this.jogadores[0] = new Jogador(vida,0); 
        this.jogadores[1] = new Jogador(vida,1);
        this.tipoAcaoAnterior = -1;
        this.qtdDecksEscolhidos = 0;
        this.turno = 0;
    }
    public Controle(){}
    
    public void setJanelaInGame(ScreenInGame screenInGame) {
    	this.screenInGame = screenInGame;
    }
    public ScreenInGame getJanelaInGame() {
    return this.getJanelaInGame();
    }
    public void setJanelaSelecaoDeck(JFrame screenSelecaoDeck) {
    	this.screenSelecaoDeck=screenSelecaoDeck;
    }
    
    public void abrirJanela(JFrame janela) {
    	janela.setVisible(true);
    }
    
	public void jogarNovamente() {
		
	       int rejogar =  JOptionPane.showConfirmDialog(null,
	             "Jogar novamente?", "Fim de jogo!", JOptionPane.YES_NO_OPTION);

	       if (rejogar == JOptionPane.YES_OPTION) {
	           this.screenInGame.dispose();
	           MainJogo.main(null);
	       } else if (rejogar == JOptionPane.NO_OPTION) {
	           System.exit(0);
	       }
	    
	
}
    private void acabarJogo(){
        System.out.println("ALGUM PLAYER MORREU, FIM DE JOGO!");
        jogarNovamente();
    }


    private int getOtherPlayer(){
        if(numeroPAtual == 0)
            return 1;
        return 0;
    }

    private void trocarJogadorAtual(){
        if(!jogadores[0].vivo() || !jogadores[1].vivo()){
            acabarJogo();
        }
        this.numeroPAtual = getOtherPlayer();
        this.tipoAcaoAnterior = -1;
        incrementarTurno();
        atualizarScoreboardInGame();
        System.out.println("JOGADOR ATUAL:" +numeroPAtual);
        //tabuleiro.mostrarNoTerminal();
    }

    public boolean colocarPeca(int numeroCarta,int[] coordenadas){
        Jogador jogador = jogadores[numeroPAtual];
        if(!jogador.podePorPeca(numeroCarta)){
            System.out.println("JOGADOR TENTANDO COLOCAR PECAS ALEM DO LIMITE DA PECA");
            return false;
        }
        ICarta tipoDePeca = jogador.getCarta(numeroCarta);
        if(tabuleiro.colocarPeca(tipoDePeca,coordenadas,numeroPAtual)){
            jogador.atualizarNumeroPecas(numeroCarta);
            trocarJogadorAtual();
        }else{
            return false;
        }
        this.screenInGame.atualizarCasaTabuleiroVisual(coordenadas[0], coordenadas[1]);
        return true;


    }

    private void eliminarPeca(Peca peca){
        tabuleiro.removerPeca(peca);
        jogadores[peca.getPlayer()].pecaEliminada(peca);
    }

    private void sacrificarPeca(Peca peca,Jogador jogador){
        jogador.levarDano(2*peca.getVida());
        eliminarPeca(peca);
    }
 

    public void moverPeca(int[] coords1,int[] coords2){
        if(tabuleiro.moverPeca(coords1, coords2)){
            if(tabuleiro.deveSerSacrificada(coords2)){
                sacrificarPeca(tabuleiro.pecaAt(coords2),jogadores[getOtherPlayer()]);
            }
            this.screenInGame.atualizarCasaTabuleiroVisual(coords1[0], coords1[1]);
            this.screenInGame.atualizarCasaTabuleiroVisual(coords2[0], coords2[1]);
            trocarJogadorAtual();
        }
    }
    public void ataquePeca(int[] coords1,int[] coords2){
        Peca pecaAtacada = tabuleiro.casaAt(coords2).getPeca();
        if(pecaAtacada.getPlayer() == numeroPAtual){
            tipoAcaoAnterior = 1;
            coordAcaoAnterior = coords2;
            return;
        }
        if(tabuleiro.ataquePeca(coords1, coords2)){
            if (!pecaAtacada.viva()){
                jogadores[pecaAtacada.getPlayer()].levarDano(pecaAtacada.overkill());
                eliminarPeca(pecaAtacada);
            }
            this.screenInGame.atualizarCasaTabuleiroVisual(coords1[0], coords1[1]);
            this.screenInGame.atualizarCasaTabuleiroVisual(coords2[0], coords2[1]);
            trocarJogadorAtual();
        }
    }

    public void setDeckSelecionado(Deck deckSelecionado) {
        this.jogadores[numeroPAtual].setDeck(deckSelecionado);
        this.qtdDecksEscolhidos += 1;
        this.numeroPAtual = getOtherPlayer();
        if (this.qtdDecksEscolhidos == 2){
            ScreenInGame janelaInGame = new ScreenInGame(1920,1080,this);
            setJanelaInGame(janelaInGame);
            screenSelecaoDeck.dispose();
            abrirJanela(this.screenInGame);

            
        }
    }
    
    public void incrementarTurno() {
    	setTurno(this.turno+1);
    }
    public void setTurno(int n){
    	this.turno = n;	
    }
    public void atualizarScoreboardInGame() {
       	this.screenInGame.atualizarScoreboard(jogadores[0].getVida(), jogadores[1].getVida(), this.turno);
    }
    
    public int getTurno() {
    	return this.turno;
    }
    public void celulaSelecionada(int[] coord){
        if(tabuleiro.casaVazia(coord)){

            if(tipoAcaoAnterior == 0){
                colocarPeca(coordAcaoAnterior[1],coord);
                return;
            }
            else if(tipoAcaoAnterior == 1)
                moverPeca(coordAcaoAnterior,coord);
            
        }else{

            if(tipoAcaoAnterior == 1){
                ataquePeca(coordAcaoAnterior,coord);
                return;
            }
            else if(tipoAcaoAnterior == -1){
                if(tabuleiro.casaAt(coord).getPeca().getPlayer() == numeroPAtual){
                    tipoAcaoAnterior = 1;
                    coordAcaoAnterior = coord;
                }else{
                    System.out.println("JOGADOR TENTANDO SELECIONAR PECAS QUE NAO SAO SUAS");
                }

            }else{
                if(tabuleiro.casaAt(coord).getPeca().getPlayer() == numeroPAtual){
                    tipoAcaoAnterior = 1;
                    coordAcaoAnterior = coord;    
                }else{
                    System.out.println("JOGADOR TENTANDO COLOCAR UMA NOVA PEÇA POR CIMA DE UMA INIMIGA");
                }
            }
        }
    }

    public void cartaSelecionada(int[] coord){
        if(coord[0] != this.numeroPAtual){
            System.out.println("JOGADOR CLICANDO EM CARTAS QUE NAO SAO SUAS");
        }else{
            tipoAcaoAnterior = 0;
            coordAcaoAnterior = coord;
        }
    }


    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getNumeroPAtual() {
        return this.numeroPAtual;
    }

    public void setNumeroPAtual(int numeroPAtual) {
        this.numeroPAtual = numeroPAtual;
    }

    public Jogador[] getJogadores() {
        return this.jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getJogador(int numero) {
        return this.jogadores[numero];
    }
}
