package mc322.lab07.model.Decks.Deck2.Pecas;

import mc322.lab07.model.Peca;

public class PecaVampiro extends Peca{

	public PecaVampiro(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaVampiro() {
		super(25, 8, 1, "Vampiro", "Vampire",2);
		
	}
	@Override
	public void atacar(Peca pecaInimiga){
		vida += 4;
		pecaInimiga.levarDano(this.ataque);
	}

	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaVampiro();
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "É a peça especial dos Monstros. Pode ser colocado apenas 2 vezes durante a partida toda. Regenera vida ao dar dano.";
	}
}
