package mc322.lab05;

public class Tabuleiro {

	Peca[][] tabuleiroPecas = new Peca[8][8];


	static int direcao(int a,int b){
		// "vai na dire��o" de B para A
		if (a>b){
			return 1;
		}
		if (b>a){
			return -1;
		}
		return 0;
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
				int player = posInicialTabuleiro(i,j);
				if(player != -1) {
					
					tabuleiroPecas[i][j]= new Peao(i,j,player);
				}
				else {
					tabuleiroPecas[i][j]= null;
				}
			}		
			
		}
 
		
	}

	int[] obterCaminho(int[] posInicial,int[] posFinal) {
		//Retorna uma lista de n�meros, inclui a posi��o inicial e a final.
		//Cada �ndice da lista possui o jogador a qual a pe�a pertence:
		//0->Player 0
		//1->Player 1
		//-1 -> Casa vazia
		//-2 -> casa inexistente (FORA DO TABULEIRO)
		int tamanho = moduloDif(posInicial[1], posFinal[1]);
		int direcaox = direcao(posFinal[0],posInicial[0]);
		int direcaoy = direcao(posFinal[1],posInicial[1]);
		int linha_atual=posInicial[0];
		int coluna_atual=posInicial[1];
		int[] caminho = new int[tamanho];
		for(int i=0;i<tamanho;i++) {
			linha_atual += direcaox;
			coluna_atual += direcaoy;
			if(linha_atual < 0 || linha_atual > 7 || coluna_atual< 0 || coluna_atual > 7){
				caminho[i] = -2;
			}
			else if (tabuleiroPecas[linha_atual][coluna_atual] != null){
				caminho[i] = tabuleiroPecas[linha_atual][coluna_atual].getPlayer();
			}else{
				caminho[i] = -1;
			}
			//System.out.println("caminho:"+ caminho[i]);
		}
		
		return caminho;
	}
	
	
	int[] strParaCoords(String coords){
		//Converte as coordenadas do Tipo CharInt -> LinhaColuna
		int[] ret = {coords.charAt(1)-1-'0',coords.charAt(0)-'a'};
		
		return(ret);
		
	}
	
	int posInicialTabuleiro(int i,int j) {
		//Serve como condi��o para gerar o tabuleiro
		//Verifica se deve ser colocada uma peça em i,j
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
		//Verifica se a casa est� preenchida
		return tabuleiroPecas[linha][coluna]!=null;
	}
	boolean movimentoDiagonalValida(int[] fonte,int[] alvo) {
		//Verifica se o movimento ocorre em diagonal
		//Evita que a pe�a seja movida fora de uma diagonal
		
		return moduloDif(fonte[0],alvo[0])==moduloDif(fonte[1],alvo[1]);
	}
	void executarMovimento(int[] fonte,int[] alvo) {
		if(alvo[0] == 0  && tabuleiroPecas[fonte[0]][fonte[1]].getPlayer() == 1){
			tabuleiroPecas[alvo[0]][alvo[1]] = new Dama(alvo[0], alvo[1], 1);
		}else if(alvo[0] == 7  && tabuleiroPecas[fonte[0]][fonte[1]].getPlayer() == 0){
			tabuleiroPecas[alvo[0]][alvo[1]] = new Dama(alvo[0], alvo[1], 0);
		}else{
			tabuleiroPecas[alvo[0]][alvo[1]] = tabuleiroPecas[fonte[0]][fonte[1]];
		}
		
		for(int i =1;i<=moduloDif(fonte[0], alvo[0]);i++) {
			//Remove todas as peças entre o a fonte e o alvo
			tabuleiroPecas[alvo[0]+i*direcao(fonte[0],alvo[0])][alvo[1]+i*direcao(fonte[1],alvo[1])] = null;
			
		}
		//tabuleiroPecas[alvo[0]+direcao(fonte[0],alvo[0])][alvo[1]+direcao(fonte[1],alvo[1])] = null;
		//tabuleiroPecas[fonte[0]][fonte[1]] = null; <-A função acima já inclui esta linha, mas a deixarei comentada
	}
	void jogada(String fonte,String alvo) {
		//Movimenta a pe�a na casa fonte at� a casa alvo
		int[] coordenadasFonte = strParaCoords(fonte);
		int[] coordenadasAlvo = strParaCoords(alvo);
		
		//Verifica se h� uma pe�a no local
		if(!casaPreenchida(coordenadasFonte[0],coordenadasFonte[1])) {
			System.out.println("Não há peça na casa");
			return;
		}
		
		
		if(!movimentoDiagonalValida(coordenadasFonte,coordenadasAlvo)) {
			System.out.println("O movimento n�o ocorre em diagonal");
			return;
		}
		
		int[] caminho = obterCaminho(coordenadasFonte,coordenadasAlvo);
		
		
		//Pergunta pra pe�a se o movimento � v�lido e identifica o tipo de movimento
		boolean ehValido= tabuleiroPecas[coordenadasFonte[0]][coordenadasFonte[1]].ehMovimentoValido(caminho,coordenadasAlvo);
		if(ehValido){
			executarMovimento(coordenadasFonte,coordenadasAlvo);
		}else{
			System.out.println("Movimento Inválido");
		}
		//Executa o movimento (O tabuleiro deve executar os movimentos,a pe�a apenas retorna o tipo)
	}

	
	String estadoEmString() {
		//Retorna o estado atual do tabuleiro em uma string
		String estadoAtual = "";
		for(int i=7;i>=0;i--) {
			for(int j=0;j<8;j++){

				if(tabuleiroPecas[i][j]!=null) {
					estadoAtual+=tabuleiroPecas[i][j].String();
				}
				else if(tabuleiroPecas[i][j]!=null) {

					estadoAtual+=tabuleiroPecas[i][j].String();
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
		//Imprime como o tabuleiro est� no momento.
		for(int i=7;i>=0;i--) {
			System.out.print(i+1+" ");
			for(int j=0;j<8;j++){

				if(tabuleiroPecas[i][j]!=null) {
					System.out.print(tabuleiroPecas[i][j].String());
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
