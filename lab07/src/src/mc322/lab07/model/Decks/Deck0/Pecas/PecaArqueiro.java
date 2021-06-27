package mc322.lab07.model.Decks.Deck0.Pecas;

import mc322.lab07.model.Peca;

public class PecaArqueiro extends Peca{
	
	
	public PecaArqueiro(int vida,int ataque,int mobilidade,String nome,String nomeArquivo,int qtdMax) {
		super(vida, ataque, mobilidade, nome, nomeArquivo,qtdMax);
		
	}
	public PecaArqueiro() {
		super(5, 5, 2, "Arqueiro", "Arqueiro",5);
		
	}



	public boolean validarAtaque(int[] coords){
		int distancia = (int)calcularDistancia(coords);
		if(distancia<=4){
			return true;
		}
		return false;
	}


	public boolean efeito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peca gerarPeca() {
		// TODO Auto-generated method stub
		return new PecaArqueiro();
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Pode atacar a 4 unidades de distância. Brabo";
	}
}
