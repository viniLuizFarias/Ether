package mc322.lab07.model.Decks.Deck0;

import mc322.lab07.model.Deck;
import mc322.lab07.model.Decks.Deck0.Pecas.*;

public class Deck0 extends Deck{

	public Deck0() {
		
		super(0, "Deck0");
		PecaArqueiro pArq = new PecaArqueiro(1, 1, 1, "Arqueiro","Carta");
		PecaCavaleiro pCav = new PecaCavaleiro(1, 1, 1, "Cavalo","Carta");
		PecaGuerreiro pGuerr= new PecaGuerreiro(1, 1, 1, "Guerreiro","Carta");
		PecaMago pMago= new PecaMago(1, 1, 1, "Mago","Carta");
		PecaPaladino pPalad = new PecaPaladino(1, 1, 1, "Paladino","Carta");
		
		setPecaLista(pArq, 0);
		setPecaLista(pCav, 1);
		setPecaLista(pGuerr, 2);
		setPecaLista(pMago, 3);
		setPecaLista(pPalad, 4);

	}

		
}
