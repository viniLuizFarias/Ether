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
		
		setCartaLista(pAguia, 0);
		setCartaLista(pCavalo, 1);
		setCartaLista(pDrag, 2);
		setCartaLista(pLobo, 3);
		setCartaLista(pTart, 4);

		setNCartaEspecial(2);
	}
}
