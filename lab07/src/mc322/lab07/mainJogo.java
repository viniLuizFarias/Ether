package mc322.lab07;
import mc322.lab07.vision.*;
import mc322.lab07.model.*;
import mc322.lab07.controller.*;


public class MainJogo {

	public static Peca[][] escolherCartas(){
		return null;
	}
	public static void main(String[] args) {
		//ESCOLHER CARTAS
		//Peca[][] cartas = escolherCartas();
		Tabuleiro tabuleiro = new Tabuleiro(20,10);
		//Controle controle = new Controle(40,cartas,tabuleiro);
		
		Controle controle = new Controle();
		ScreenInGame janelaInGame = new ScreenInGame(1920,1080);
		ScreenSelecaoDeck janelaDeck = new ScreenSelecaoDeck(1920,1080);
		
		controle.setJanelaInGame(janelaInGame);
		controle.setJanelaSelecaoDeck(janelaDeck);
		
		controle.abrirJanela(janelaDeck);

	}

}
