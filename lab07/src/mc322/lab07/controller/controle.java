package mc322.lab07.controller;
import mc322.lab07.model.*;
import mc322.lab07.model.peca.*;

public class Controle {
    Tabuleiro tabuleiro;
    Jogador jogador1;
    Jogador jogador2;

    public Controle(int vida,Peca[][] cartas,Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        this.jogador1 = new Jogador(vida,1,cartas[0]);
        this.jogador2 = new Jogador(vida,2,cartas[1]);
    }
    
}
