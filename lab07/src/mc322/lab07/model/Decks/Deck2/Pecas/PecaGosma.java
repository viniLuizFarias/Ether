package mc322.lab07.model.Decks.Deck2.Pecas;

import mc322.lab07.model.Peca;

public class PecaGosma extends Peca{


	public PecaGosma(int vida,int ataque,int mobilidade,String nome,String nomeArquivo) {
		super(vida, ataque, mobilidade, nome, nomeArquivo);
		
	}
	public PecaGosma() {
		super(1, 1, 1, "Gosma", "Gosma");
		
	}

	@Override
	public int validarMovimento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int atacar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int gerarPeca() {
		// TODO Auto-generated method stub
		return 0;
	}

}
