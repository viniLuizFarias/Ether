package mc322.lab07.model.Decks.Deck2;

import mc322.lab07.model.Deck;
import mc322.lab07.model.Decks.Deck2.Pecas.*;




public class Deck2 extends Deck{
	public Deck2() {
		
		super(2, "Deck2");
		PecaEsqueleto pEsq = new PecaEsqueleto();
		PecaGoblin pGob = new PecaGoblin();
		PecaGosma pGos = new PecaGosma();
		PecaVampiro pVamp = new PecaVampiro();
		PecaZumbi pZumbi = new PecaZumbi();
		
		setCartaLista(pEsq, 0);
		setCartaLista(pGob, 1);
		setCartaLista(pGos, 2);
		setCartaLista(pVamp, 3);
		setCartaLista(pZumbi, 4);
	}

}
