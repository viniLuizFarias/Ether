package mc322.lab05a;

public class PecaRainha {
	int linha;
	int coluna;
	int player;
	Tabuleiro tabuleiro;//A pe�a sabe o tabuleiro em que est�
	
	PecaRainha(Tabuleiro tabuleiro,int linha,int coluna,int player){
		this.linha = linha;
		this.coluna = coluna;
		this.tabuleiro= tabuleiro;
		this.player = player;
		
	}
	String String(){
		if (player == 0) return ("B");
		return ("V");
	}


	boolean caminho_livre(int linha1,int coluna1,int linha2, int coluna2,boolean eh_captura){
		// VE SE O CAMINHO ATE O DESTINO ESTÁ VAZIO
		// SE FOR UMA CAPTURA IGNORA A PENULTIMA CASA
		for(int i = 1;i< tabuleiro.moduloDif(linha1,linha2)-1;i++){
			if(tabuleiro.casaPreenchida(linha1 + i*tabuleiro.direcao(linha2,linha1),coluna1 + i*tabuleiro.direcao(coluna2,coluna1))){
				System.out.println("B1");
				return false;
			}
		}
		if (!eh_captura && tabuleiro.moduloDif(linha1,linha2)>1){
			System.out.println("B2");
			return !tabuleiro.casaPreenchida(linha2 -tabuleiro.direcao(linha2,linha1),coluna2 -tabuleiro.direcao(coluna2,coluna1));
		}
		return true;
	}
	boolean movimentoValido(int linha1,int coluna1,int linha2, int coluna2,boolean eh_captura) {
		if(tabuleiro.moduloDif(coluna1,coluna2)!=tabuleiro.moduloDif(linha1,linha2)){
			System.out.println("A");
			return false;
		}
		if(!caminho_livre(linha1,coluna1, linha2, coluna2, eh_captura)){
			System.out.println("B");
			return false;
		}
		if (tabuleiro.casaPreenchida(linha2,coluna2)){
			System.out.println("C");
			return false;
		}
		return true;
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

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
