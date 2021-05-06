package mc322.lab05;

public class PecaDama {
	
	private int linha;
	private int coluna;
	private int player;
	Tabuleiro tabuleiro;//A pe�a sabe o tabuleiro em que est�
	
	PecaDama(Tabuleiro tabuleiro,int linha,int coluna,int player){
		this.linha = linha;
		this.coluna = coluna;
		this.tabuleiro= tabuleiro;
		this.player = player;
		
	}

	String String(){
		if (player == 0) return ("b");
		return ("v");
	}

	boolean movimentoValido(int linha1, int coluna1, int linha2, int coluna2, boolean eh_captura) {
		//System.out.println(linha1+" "+coluna1+"->"+linha2+" "+coluna2);
		if(this.player == 0){ // DAMAS BRANCAS
			
			if (tabuleiro.moduloDif(coluna2,coluna1) == 1){ // MOVIMENTO NORMAL
				if (linha2==linha1+1){
					return !tabuleiro.casaPreenchida(linha2,coluna2);
				}
			}else if(tabuleiro.moduloDif(linha2,linha1) == 2){ // BRANCA CAPTURA
				if(tabuleiro.moduloDif(coluna2,coluna1) == 2){
					return !tabuleiro.casaPreenchida(linha2,coluna2) && eh_captura;
				}
			}
		}else{ // DAMAS VERMELHAS
			if (tabuleiro.moduloDif(coluna2,coluna1) == 1){ // MOVIMENTO NORMAL

				if (linha2 == linha1 - 1){
					return !tabuleiro.casaPreenchida(linha2,coluna2);
				}
			}else if(tabuleiro.moduloDif(linha2,linha1) == 2){ // VERMELHA CAPTURA
				if(tabuleiro.moduloDif(coluna2,coluna1) == 2){
					return !tabuleiro.casaPreenchida(linha2,coluna2) && eh_captura;
				}
			}
		}
		return false;
	}


	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
}
