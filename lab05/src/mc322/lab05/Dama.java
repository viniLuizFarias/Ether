package mc322.lab05;

public class Dama extends Peca{
	
	public Dama(int linha, int coluna, int player) {
		super(linha, coluna, player);
	}
	

	String String(){
		if (player == 0) return ("B");
		return ("V");
	}

	boolean caminho_livre(int linha2, int coluna2,int[] caminho){
		// VE SE O CAMINHO ATE O DESTINO EST� VAZIO
		// SE FOR UMA CAPTURA IGNORA A PENULTIMA CASA
		for(int i = 1;i< caminho.length-1;i++){
			if(caminho[i] != -1){
				//System.out.println("B1");
				return false;
			}
		}
		if (caminho.length>1){
			//System.out.println("B2");
			return !(caminho[caminho.length-1] == -2);
		}
		return true;
	}

	boolean movimentoValido(int[] caminho,int[] coordsAlvo) {
		if(!caminho_livre(coordsAlvo[0],coordsAlvo[1], caminho)){
			//System.out.println("B");
			return false;
		}
		if (caminho[caminho.length-1]!=0){
			//System.out.println("C");
			return false;
		}
		return true;
	}
}
