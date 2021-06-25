package mc322.lab07.controller;


import javax.swing.JFrame;

import mc322.lab07.model.*;
import mc322.lab07.vision.ScreenInGame;
import mc322.lab07.vision.ScreenSelecaoDeck;

public class Controle {
    private Tabuleiro tabuleiro;
    private int numeroPAtual;
    private Jogador[] jogadores;
    
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

    private void acabarJogo(){
        System.out.println("ALGUM PLAYER MORREU, FIM DE JOGO!");
        System.exit(0);
    }

    private void trocarJogadorAtual(){
        if(!jogadores[0].vivo() || !jogadores[1].vivo()){
            acabarJogo();
        }
        if(numeroPAtual == 0)
            numeroPAtual = 1;
        else
            numeroPAtual = 0;
        this.tipoAcaoAnterior = -1;
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
        this.jogadores[numeroPAtual].atualizarNumeroPecas(numeroCarta);
        return true;


    }

    private void sacrificarPeca(Peca peca,Jogador jogador){
        jogador.levarDano(2*peca.getVida());
        tabuleiro.casaAt(peca.getCoords()).esvaziar();
    }

    public void moverPeca(int[] coords1,int[] coords2){
        if(tabuleiro.moverPeca(coords1, coords2)){
            trocarJogadorAtual();
            if(tabuleiro.deveSerSacrificada(coords2)){
                sacrificarPeca(tabuleiro.pecaAt(coords2),jogadores[numeroPAtual]);
            }
            this.screenInGame.atualizarCasaTabuleiroVisual(coords1[0], coords1[1]);
            this.screenInGame.atualizarCasaTabuleiroVisual(coords2[0], coords2[1]);
        }
    }
    public void ataquePeca(int[] coords1,int[] coords2){
        Peca pecaAtacada = tabuleiro.casaAt(coords2).getPeca();
        if(pecaAtacada.getPlayer() == numeroPAtual){
            System.out.println("JOGADOR TENTANDO ATACAR SUAS PRÓPRIA PEÇAS!");
            return;
        }
        if(tabuleiro.ataquePeca(coords1, coords2)){
            trocarJogadorAtual();
            if (!pecaAtacada.viva()){
                jogadores[pecaAtacada.getPlayer()].levarDano(pecaAtacada.overkill());
                tabuleiro.casaAt(coords2).esvaziar();
            }
            this.screenInGame.atualizarCasaTabuleiroVisual(coords1[0], coords1[1]);
            this.screenInGame.atualizarCasaTabuleiroVisual(coords2[0], coords2[1]);
        }
    }

    public void setDeckSelecionado(Deck deckSelecionado) {
        this.jogadores[numeroPAtual].setDeck(deckSelecionado);
        this.qtdDecksEscolhidos += 1;
        trocarJogadorAtual();
        if (this.qtdDecksEscolhidos == 2){
            ScreenInGame janelaInGame = new ScreenInGame(1920,1080,this);
            setJanelaInGame(janelaInGame);
            screenSelecaoDeck.setVisible(false);
            abrirJanela(this.screenInGame);
            
        }
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
