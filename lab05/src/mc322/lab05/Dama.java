package mc322.lab05;

public class Dama extends Peca{
	
	public Dama(int linha, int coluna, int player) {
		super(linha, coluna, player);
	}
	

	String String(){
		if (player == 0) return ("B");
		return ("V");
	}

	
	int ehMovimentoValido(int[] caminho) {
		//Retorna -1 se não é válido
		//Retorna 0 se o movimento é de deslocamento
		//Retorna 1 se o movimento é de captura
		
		
		//Pseudocódigo
		return -999;
	}
}
