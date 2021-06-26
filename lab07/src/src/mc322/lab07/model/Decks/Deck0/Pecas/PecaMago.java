package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaMago extends Peca{
	public PecaMago(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	
	public PecaMago() {
		super(7, 10, 1, "Mago", "Mago",2);
		
	}
	@Override
	public boolean validarAtaque(int[] coords) {
		return calcularDistancia(coords) < 4;
	}



	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaMago();
	}

}
