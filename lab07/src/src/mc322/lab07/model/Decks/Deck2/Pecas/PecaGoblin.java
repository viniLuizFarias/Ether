package mc322.lab07.model.Decks.Deck2.Pecas;

import mc322.lab07.model.Peca;

public class PecaGoblin extends Peca{

	public PecaGoblin(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaGoblin() {
		super(1, 1, 1, "Goblin", "Carta",6);
		
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
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaGoblin();
	}

}
