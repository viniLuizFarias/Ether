package mc322.lab07.controller;


import javax.swing.JFrame;

import mc322.lab07.model.*;
import mc322.lab07.vision.ScreenInGame;
import mc322.lab07.vision.ScreenSelecaoDeck;

public class Controle {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    
	private JFrame screenInGame;
	private JFrame screenSelecaoDeck;

    public Controle(int vida,Peca[][] cartas,Tabuleiro tabuleiro){

    	
        this.tabuleiro = tabuleiro;
        this.jogador1 = new Jogador(vida,1,cartas[0]);
        this.jogador2 = new Jogador(vida,2,cartas[1]);
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
}
