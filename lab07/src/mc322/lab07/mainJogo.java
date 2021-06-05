package mc322.lab07;
import mc322.lab07.vision.*;
import mc322.lab07.model.*;
import mc322.lab07.model.peca.*;
import mc322.lab07.controller.*;


public class mainJogo {

	public static Peca[][] escolherCartas(){
		return null;
	}
	public static void main(String[] args) {
		//ESCOLHER CARTAS
		Peca[][] cartas = escolherCartas();
		Tabuleiro tabuleiro = new Tabuleiro(8,12);
		Controle controle = new Controle(40,cartas,tabuleiro);

	}

}
