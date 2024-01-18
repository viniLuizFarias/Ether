package mc322.lab07.model.Decks.Deck2.Pecas;

import mc322.lab07.model.Peca;

public class PecaZumbi extends Peca{

	public PecaZumbi(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaZumbi() {
		super(8, 5, 1, "Zumbi", "Zumbi",4);
		
	}

	public void atacar(Peca pecaInimiga){
		pecaInimiga.levarDano(this.ataque);
		if(pecaInimiga.getAtaque() > 3)
			pecaInimiga.setAtaque(pecaInimiga.getAtaque()-3);
		else
			pecaInimiga.setAtaque(0);
	}

	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaZumbi();
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Seu ataque reduz o dano da peça inimiga.";
	}

}
