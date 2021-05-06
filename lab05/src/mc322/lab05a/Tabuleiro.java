package mc322.lab05;

public class Tabuleiro {

	PecaDama[][] tabuleiro_damas = new PecaDama[8][8];
	PecaRainha[][] tabuleiro_rainhas = new PecaRainha[8][8];

	static int direcao(int a,int b){
		if (a>b){
			return 1;
		}
		return -1;
	}
	static int moduloDif(int a,int b){
		if (a>b){
			return a-b;
		}
		return b-a;
	}
	
	Tabuleiro() {
		//Inicia o tabuleiro
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++){
				int player = noTabuleiro(i,j);
				tabuleiro_rainhas[i][j]=null;
				if(player != -1) {
					
					tabuleiro_damas[i][j]=new PecaDama(this,i,j,player);
				}
				else {
					tabuleiro_damas[i][j]= null;
				}
			}		
			
		}
		
	}

	void realizarMovimentoDama(int linha1, int coluna1,int linha2,int coluna2, boolean eh_captura) {
		//Movimenta a peÁa e come remove a da casa intermediaria

		PecaDama dama =tabuleiro_damas[linha1][coluna1];
		tabuleiro_damas[linha1][coluna1] = null;
		/*
		if(moduloDif(linha1,linha2)>1 && moduloDif(coluna1,coluna2)>1) {//Verifica se uma casa foi pulada, indicando captura
			tabuleiro_damas[(linha1+linha2)/2][(coluna1+coluna2)/2]= null;
			tabuleiro_rainhas[(linha1+linha2)/2][(coluna1+coluna2)/2]= null;
		}
		*/
		 if (eh_captura){
			 tabuleiro_damas[(linha1+linha2)/2][(coluna1+coluna2)/2]= null;
			 tabuleiro_rainhas[(linha1+linha2)/2][(coluna1+coluna2)/2]= null;
		 }
		 if(dama.getPlayer() == 0){
		 	if (linha2 == 7){
				tabuleiro_rainhas[linha2][coluna2]= new PecaRainha(this,linha2,coluna2,0);
			}else{
				tabuleiro_damas[linha2][coluna2]= dama;
			}
		 }else{
			 if (linha2 == 0){
				 tabuleiro_rainhas[linha2][coluna2]= new PecaRainha(this,linha2,coluna2,1);
			 }else{
				 tabuleiro_damas[linha2][coluna2]= dama;
			 }
		 }


	}
	void realizarMovimentoRainha(int linha1, int coluna1,int linha2,int coluna2, boolean eh_captura) {
		//Movimenta a peÁa e come remove a da casa "anterior" ‡ posiÁ„o final

		PecaRainha rainha =tabuleiro_rainhas[linha1][coluna1];
		tabuleiro_rainhas[linha1][coluna1] = null;


		if (eh_captura){
			int linha_captura,coluna_captura;
			if(linha2>linha1){
				linha_captura = linha2-1;
			}else{
				linha_captura = linha2+1;
			}
			if(coluna2>coluna1){
				coluna_captura = coluna2-1;
			}else{
				coluna_captura = coluna2+1;
			}
			tabuleiro_damas[linha_captura][coluna_captura]= null;
			tabuleiro_rainhas[linha_captura][coluna_captura]= null;
		}
		tabuleiro_rainhas[linha2][coluna2]= rainha;


	}
	
	
	int[] strParaCoords(String coords){
		//Converte as coordenadas do Tipo CharInt -> IntInt
		int[] ret = {coords.charAt(1)-1-'0',coords.charAt(0)-'a'};
		
		return(ret);
		
	}
	
	int noTabuleiro(int i,int j) {
		//Verifica se deve ser colocada uma pe√ßa em i,j
		// retorna -1 para casa vazia, 1 para player 1 e 0 para player 0
		if (i<3){
			if ((j-i)%2 == 0) return 0;
			else return -1;
		}else if(i>4){
			if ((j-i)%2 != 0) return -1;
			return 1;
		}
		return -1;
	}


	boolean casaPreenchida(int linha, int coluna){
		if (linha<0 || linha > 7 || coluna < 0 || coluna > 7){
			return false;
		}
		if (tabuleiro_damas[linha][coluna] != null || tabuleiro_rainhas[linha][coluna] != null){
			return true;
		}
		return false;
	}

	boolean ehCaptura(int[] coordsFonte, int[] coordsAlvo){
		int linha, coluna;

		linha = coordsAlvo[0] +direcao(coordsFonte[0],coordsAlvo[0]);
		coluna = coordsAlvo[1]+ direcao(coordsFonte[1],coordsAlvo[1]);

		return casaPreenchida(linha,coluna);
	}

	void jogada(String fonte,String alvo) {
		//Movimenta a peÔøΩa na casa fonte atÔøΩ a casa alvo
		boolean movimento_valido;
		int[] coordsFonte = strParaCoords(fonte);
		int[] coordsAlvo = strParaCoords(alvo);
		boolean eh_captura = ehCaptura(coordsFonte,coordsAlvo);

		if (tabuleiro_damas[coordsFonte[0]][coordsFonte[1]] != null) {

			movimento_valido = tabuleiro_damas[coordsFonte[0]][coordsFonte[1]].movimentoValido(coordsFonte[0],coordsFonte[1],coordsAlvo[0],coordsAlvo[1],eh_captura);
			if (movimento_valido){
				realizarMovimentoDama(coordsFonte[0],coordsFonte[1],coordsAlvo[0],coordsAlvo[1],eh_captura);
			}else{
				System.out.println("JOGADA INV¡LIDA!");
			}
		}else if(tabuleiro_rainhas[coordsFonte[0]][coordsFonte[1]] != null) {
			movimento_valido = tabuleiro_rainhas[coordsFonte[0]][coordsFonte[1]].movimentoValido(coordsFonte[0], coordsFonte[1], coordsAlvo[0], coordsAlvo[1],eh_captura);
			if (movimento_valido) {
				realizarMovimentoRainha(coordsFonte[0],coordsFonte[1],coordsAlvo[0],coordsAlvo[1],eh_captura);
			}else{
				System.out.println("JOGADA INV¡LIDA!");
			}
		}
	}
	
	String estadoEmString() {
		//Retorna o estado atual do tabuleiro em uma string
		String estadoAtual = "";
		for(int i=7;i>=0;i--) {
			for(int j=0;j<8;j++){

				if(tabuleiro_damas[i][j]!=null) {
					estadoAtual+=tabuleiro_damas[i][j].String();
				}
				else if(tabuleiro_rainhas[i][j]!=null) {

					estadoAtual+=tabuleiro_rainhas[i][j].String();
				}
				else {
					estadoAtual+=" ";
				}
				
			}
			estadoAtual+='\n';
		}

		return estadoAtual;

	}
	
	void imprimir() {
		//Imprime como o tabuleiro estÔøΩ no momento.
		for(int i=7;i>=0;i--) {
			System.out.print(i+1+" ");
			for(int j=0;j<8;j++){

				if(tabuleiro_damas[i][j]!=null) {
					System.out.print(tabuleiro_damas[i][j].String());
				}else if(tabuleiro_rainhas[i][j]!=null){
					System.out.print(tabuleiro_rainhas[i][j].String());
				}else {
					System.out.print(" ");
				}
				System.out.print(" ");
			
			
		}
			
			System.out.print("\n");
	}
	System.out.print("  a b c d e f g h \n");
	}

}
