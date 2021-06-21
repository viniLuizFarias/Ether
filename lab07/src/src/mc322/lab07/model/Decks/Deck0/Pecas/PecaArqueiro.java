package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaArqueiro extends Peca{
	
	
	public PecaArqueiro(int vida,int ataque,int mobilidade,String nome,String nomeArquivo) {
		super(vida, ataque, mobilidade, nome, nomeArquivo);
		
	}
	public PecaArqueiro() {
		super(1, 1, 1, "Arqueiro", "Arqueiro");
		
	}

	
	public int validarMovimento() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int atacar() {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaArqueiro();
	}
}
