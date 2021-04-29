package mc322.lab05;

public class Peca {
	
	protected int linha;
	protected int coluna;
	protected int player;

	
	public Peca(int linha, int coluna, int player) {
		this.linha = linha;
		this.coluna = coluna;
		this.player = player;
	}

	int ehMovimentoValido(int[] caminho) {
		//Vai ser sobreescrita
		return 99;
		
	}
	String String(){
		return ("Classe_Peca");
	}
	
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
}
