package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaPaladino extends Peca{
	public PecaPaladino(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}

	public PecaPaladino() {
		super(40, 9, 1, "Paladino", "Paladino",3);
		
	}


	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaPaladino();
	}

}

