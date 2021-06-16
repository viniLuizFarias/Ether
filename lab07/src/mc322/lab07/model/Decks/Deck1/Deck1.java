package mc322.lab07.model.Decks.Deck1;

import mc322.lab07.model.Deck;
import mc322.lab07.model.Decks.Deck1.Pecas.*;




public class Deck1 extends Deck{
	public Deck1() {
		
		super(1, "Deck1");
		PecaAguia pAguia = new PecaAguia();
		PecaCavalo pCavalo = new PecaCavalo();
		PecaDragao pDrag= new PecaDragao();
		PecaLobo pLobo= new PecaLobo();
		PecaTartaruga pTart = new PecaTartaruga();
		
		setPecaLista(pAguia, 0);
		setPecaLista(pCavalo, 1);
		setPecaLista(pDrag, 2);
		setPecaLista(pLobo, 3);
		setPecaLista(pTart, 4);

	}
}
