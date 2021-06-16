package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaGuerreiro extends Peca{
	public PecaGuerreiro(int vida,int ataque,int mobilidade,String nome,String nomeArquivo) {
		super(vida, ataque, mobilidade, nome, nomeArquivo);
		
	}

	
	public PecaGuerreiro() {
		super(1, 1, 1, "Guerreiro", "Guerreiro");
		
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
	public int gerarPeca() {
		// TODO Auto-generated method stub
		return 0;
	}
}
