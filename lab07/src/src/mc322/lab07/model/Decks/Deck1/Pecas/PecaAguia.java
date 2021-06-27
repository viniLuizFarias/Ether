package mc322.lab07.model.Decks.Deck1.Pecas;

import mc322.lab07.model.Peca;

public class PecaAguia extends Peca{

	
	
	public PecaAguia(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaAguia() {
		super(5, 4, 4, "Aguia", "Aguia",4);
		
	}


	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaAguia();
	}
	
}
