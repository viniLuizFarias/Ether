package mc322.lab05;

public class Tabuleiro {

	Peca[][] tabuleiroPecas = new Peca[8][8];


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
		//Retorna uma lista de números, inclui a posição inicial e a final.
		//Cada índice da lista possui o jogador a qual a peça pertence:
		//0->Player 0
		//1->Player 1
		//-1 -> Casa vazia
		int tamanho = moduloDif(posInicial[1], posFinal[1]);
		int[] caminho = new int[tamanho];
		for(int i=0;i<tamanho;i++) {
				
		}
		
		return null;
	}
	
	
	int[] strParaCoords(String coords){
		//Converte as coordenadas do Tipo CharInt -> LinhaColuna
		int[] ret = {coords.charAt(1)-1-'0',coords.charAt(0)-'a'};
		
		return(ret);
		
	}
	
	int posInicialTabuleiro(int i,int j) {
		//Serve como condição para gerar o tabuleiro
		//Verifica se deve ser colocada uma peÃ§a em i,j
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
		//Verifica se a casa está preenchida
		return tabuleiroPecas[linha][coluna]!=null;
	}
	boolean movimentoDiagonalValida(int[] fonte,int[] alvo) {
		//Verifica se o movimento ocorre em diagonal
		//Evita que a peça seja movida fora de uma diagonal
		
		return moduloDif(fonte[0],alvo[0])==moduloDif(fonte[1],alvo[1]);
	}
	void executarMovimento(int[] fonte,int[] alvo) {
		//Executa o 
		
	}
	void jogada(String fonte,String alvo) {
		//Movimenta a peï¿½a na casa fonte atï¿½ a casa alvo
		int[] coordenadasFonte = strParaCoords(fonte);
		int[] coordenadasAlvo = strParaCoords(alvo);
		
		//Verifica se há uma peça no local
		if(!casaPreenchida(coordenadasFonte[0],coordenadasFonte[1])) {
			System.out.println("Não há peça na casa");
			return;
		}
		
		
		if(!movimentoDiagonalValida(coordenadasFonte,coordenadasAlvo)) {
			System.out.println("O movimento não ocorre em diagonal");
			return;
		}
		
		int[] caminho = obterCaminho(coordenadasFonte,coordenadasAlvo);
		
		
		//Pergunta pra peça se o movimento é válido e identifica o tipo de movimento
		int ehMovimento= tabuleiroPecas[coordenadasFonte[0]][coordenadasFonte[1]].ehMovimentoValido(caminho);
		
		//Executa o movimento (O tabuleiro deve executar os movimentos,a peça apenas retorna o tipo)
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
		//Imprime como o tabuleiro estï¿½ no momento.
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
