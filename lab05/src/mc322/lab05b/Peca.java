package mc322.lab05b;

public class Peca {
	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	protected int linha;
	protected int coluna;
	protected int player;

	
	public Peca(int linha, int coluna, int player) {
		this.linha = linha;
		this.coluna = coluna;
		this.player = player;
	}
	int ehPecaInimiga(){
		
		if(player ==0) {
			return 1;
		}
		return 0;
	}

	boolean ehMovimentoValido(int[] caminho,int[] coordenadasAlvo) {
		//vai ser sobreescrita
		return true;
	}
	void atualizar_estado(int[] coordenadasAlvo){
		linha = coordenadasAlvo[0];
		coluna = coordenadasAlvo[1];
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
