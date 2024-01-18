package mc322.lab07.model.Decks.Deck1.Pecas;

import mc322.lab07.model.Peca;

public class PecaDragao extends Peca{
	
	public PecaDragao(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaDragao() {
		super(50, 15, 1, "Dragao", "Dragao",1);
		
	}


	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaDragao();
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Põe medo até no paladino. Pode ser colocado apenas 1 vez durante a partida toda.";
	}

}
