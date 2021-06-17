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
		
		setPecaLista(pEsq, 0);
		setPecaLista(pGob, 1);
		setPecaLista(pGos, 2);
		setPecaLista(pVamp, 3);
		setPecaLista(pZumbi, 4);
	}

}
