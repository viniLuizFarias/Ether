package mc322.lab07;
import mc322.lab07.vision.*;
import mc322.lab07.model.*;
import mc322.lab07.controller.*;


public class MainJogo {

	public static Peca[][] escolherCartas(){
		return null;
	}
	public static void main(String[] args) {
		
		
		
		Tabuleiro tabuleiro = new Tabuleiro(20,10,8);	
		Controle controle = new Controle(160,tabuleiro);
		ScreenSelecaoDeck janelaDeck = new ScreenSelecaoDeck(1920,1080,controle);
		controle.setJanelaSelecaoDeck(janelaDeck);
		controle.abrirJanela(janelaDeck);




		 
		
	}

}
