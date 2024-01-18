package mc322.lab07.model.Decks.Deck1.Pecas;

import mc322.lab07.model.Peca;

public class PecaLobo extends Peca{

	public PecaLobo(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaLobo() {
		super(8, 6, 2, "Lobo", "Lobo",5);
		
	}


	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaLobo();
	}

}
