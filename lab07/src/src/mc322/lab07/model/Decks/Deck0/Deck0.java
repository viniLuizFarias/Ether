package mc322.lab07.model.Decks.Deck0;

import mc322.lab07.model.Deck;
import mc322.lab07.model.Decks.Deck0.Pecas.*;

public class Deck0 extends Deck{

	public Deck0() {
		
		super(0, "Deck0");
		/*
		PecaArqueiro pArq = new PecaArqueiro(1, 1, 1, "Arqueiro","Carta");
		PecaCavaleiro pCav = new PecaCavaleiro(1, 1, 1, "Cavaleiro","Carta");
		PecaGuerreiro pGuerr= new PecaGuerreiro(1, 1, 1, "Guerreiro","Guerreiro");
		PecaMago pMago= new PecaMago(1, 1, 1, "Mago","Carta");
		PecaPaladino pPalad = new PecaPaladino(1, 1, 1, "Paladino","Carta");
		*/
		PecaArqueiro pArq = new PecaArqueiro();
		PecaCavaleiro pCav = new PecaCavaleiro();
		PecaGuerreiro pGuerr= new PecaGuerreiro();
		PecaMago pMago= new PecaMago();
		PecaPaladino pPalad = new PecaPaladino();

		setCartaLista(pArq, 0);
		setCartaLista(pCav, 1);
		setCartaLista(pGuerr, 2);
		setCartaLista(pMago, 3);
		setCartaLista(pPalad, 4);
		
		setNCartaEspecial(4);

	}

		
}
