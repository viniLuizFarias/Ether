package mc322.lab06.componentes;
import mc322.lab06.Caverna;

public class Componente {
	//As linhas e colunas são na matriz-> A linha 0 na matriz representa a linha 1 no tabuleiro, o mesmo vale pras colunas
	private int linha;
	private int coluna;
	char identificador;
	private Caverna caverna;
	//O identificador é o nome da classe, é útil para sabermos facilmente com que componente estamos lidando
	
	public Componente(int linha,int coluna,char identificador,Caverna caverna){
		
		this.linha = linha;
		this.coluna = coluna;
		this.identificador = identificador;
		this.caverna = caverna;
	}
	
	public String toString(){
		String str;
		str = "";
		str += identificador;
		return str;
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
	public char getIdentificador() {
		return identificador;
	}
	public void setIdentificador(char identificador) {
		this.identificador = identificador;
	}
}
