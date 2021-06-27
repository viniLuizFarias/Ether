package mc322.lab07.model.Decks.Deck1.Pecas;

import mc322.lab07.model.Peca;

public class PecaCavalo extends Peca{
	public PecaCavalo(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaCavalo() {
		super(10, 5, 3, "Cavalo", "Cavalo",5);
		
	}


	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaCavalo();
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "É a mesma coisa que o cavaleiro, só que sem ter uma pessoa em cima.";
	}

}
