package mc322.lab07.controller;


import javax.swing.JFrame;

import mc322.lab07.model.*;
import mc322.lab07.vision.ScreenInGame;
import mc322.lab07.vision.ScreenSelecaoDeck;

public class Controle {
    private Tabuleiro tabuleiro;
    private int numeroPAtual;
    private Jogador[] jogadores;
    
	private JFrame screenInGame;
	private JFrame screenSelecaoDeck;
    private int tipoAcaoAnterior; // -1 -> nenhuma acao jogada, 0-> carta clicada, 1 -> celula clicada
    private int[] coordAcaoAnterior; 

    public Controle(int vida,Tabuleiro tabuleiro){

    	this.numeroPAtual = 0;
        this.tabuleiro = tabuleiro;
        this.jogadores = new Jogador[2];
        this.jogadores[0] = new Jogador(vida,0); 
        this.jogadores[1] = new Jogador(vida,1);
        this.tipoAcaoAnterior = -1;
    }
    public Controle(){}
    
    public void setJanelaInGame(JFrame screenInGame) {
    	this.screenInGame = screenInGame;
    }
    public void setJanelaSelecaoDeck(JFrame screenSelecaoDeck) {
    	this.screenSelecaoDeck=screenSelecaoDeck;
    }
    
    public void abrirJanela(JFrame janela) {
    	janela.setVisible(true);
    }

    private void trocarJogadorAtual(){
        if(numeroPAtual == 0)
            numeroPAtual = 1;
        else
            numeroPAtual = 0;
        this.tipoAcaoAnterior = -1;
    }

    public boolean colocarPeca(int numeroCarta,int[] coordenadas){
        Jogador jogador = jogadores[numeroPAtual];
        if(!jogador.podePorPeca(tabuleiro.getMaximoPecasPorPlayer())){
            System.out.println("JOGADOR TENTANDO COLOCAR PECAS ALEM DO LIMITE DA PECA");
            return false;
        }
        Peca tipoDePeca = jogador.getCarta(numeroCarta);
        if(tabuleiro.colocarPeca(tipoDePeca,coordenadas,numeroPAtual)){
            jogador.atualizarNumeroPecas(numeroCarta);
            trocarJogadorAtual();
        }else{
            return false;
        }
        return true;

    }
    public void utilizarPeca(int[] coords1,int[] coords2){

    }

    public void alterarSelecionada(Peca peca, JFrame janela) {
    	
    	
    }

    public void celulaSelecionada(int[] coord){
        if(tabuleiro.casaVazia(coord)){

            if(tipoAcaoAnterior == 0)
                colocarPeca(coordAcaoAnterior[1],coord);
            else if(tipoAcaoAnterior == 1)
                utilizarPeca(coordAcaoAnterior,coord);
            
        }else{

            if(tipoAcaoAnterior == 1)
                utilizarPeca(coordAcaoAnterior,coord);

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
}
