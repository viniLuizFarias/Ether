package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaGuerreiro extends Peca{
	public PecaGuerreiro(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}

	
	public PecaGuerreiro() {
		super(15, 12, 1, "Guerreiro", "Guerreiro",6);
		
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
		return new PecaGuerreiro();
	}

}
