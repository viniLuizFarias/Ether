package mc322.lab07.model.Decks.Deck2.Pecas;

import mc322.lab07.model.Peca;

public class PecaGosma extends Peca{


	public PecaGosma(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaGosma() {
		super(5, 12, 0, "Gosma", "Slime",4);
		
	}
	public boolean validarAtaque(int[] coords){
		int distancia = (int)calcularDistancia(coords);
		if(distancia<=2){
			return true;
		}
		return false;
	}

	@Override
	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaGosma();
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Não pode se mover, mas tem um forte ataque a uma distância de 2 unidades.";
	}

}
