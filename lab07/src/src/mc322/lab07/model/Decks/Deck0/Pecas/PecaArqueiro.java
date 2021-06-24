package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaArqueiro extends Peca{
	
	
	public PecaArqueiro(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaArqueiro() {
		super(1, 1, 1, "Arqueiro", "Arqueiro",5);
		
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
	@Override
	public int atacar(Peca peca) {
		// TODO Auto-generated method stub
		return 0;
	}
}
