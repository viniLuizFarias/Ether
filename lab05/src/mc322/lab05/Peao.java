package mc322.lab05;

public class Peao extends Peca{
	
	public Peao(int linha, int coluna, int player) {
		super(linha, coluna, player);

	}

	String String(){
		if (player == 0) return ("b");
		return ("v");
	}
	
	
	boolean ehMovimentoValido(int[] caminho, int[] coordenadasAlvo) {
		boolean eh_valido = false;
		if(this.player == 0){ // DAMAS BRANCAS

			if (caminho.length == 1){ // MOVIMENTO NORMAL
				System.out.println(coordenadasAlvo[0]);
				System.out.println(linha);
				if (coordenadasAlvo[0]==linha+1){
					eh_valido = caminho[0] == -1;
				}
			}else if(caminho.length == 2){ // BRANCA CAPTURA
				eh_valido = caminho[0] == 1 && caminho[1] == -1;
			}
		}else{ // DAMAS VERMELHAS
			if (caminho.length == 1){ // MOVIMENTO NORMAL

				if (coordenadasAlvo[0] == linha - 1){
					eh_valido = caminho[0] == -1;
				}
			}else if(caminho.length == 2){ // VERMELHA CAPTURA
				eh_valido = caminho[0] == 0 && caminho[1] == -1;
			}
		}
		
		if(eh_valido){
			atualizar_estado(coordenadasAlvo);
		}
		return eh_valido;
	}

}
