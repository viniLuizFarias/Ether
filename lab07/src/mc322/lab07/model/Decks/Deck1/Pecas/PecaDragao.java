package mc322.lab07.model.Decks.Deck1.Pecas;

import mc322.lab07.model.Peca;

public class PecaDragao extends Peca{
	
	public PecaDragao(int vida,int ataque,int mobilidade,String nome,String nomeArquivo) {
		super(vida, ataque, mobilidade, nome, nomeArquivo);
		
	}
	public PecaDragao() {
		super(1, 1, 1, "Dragao", "Dragao");
		
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
