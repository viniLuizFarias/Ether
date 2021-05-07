package mc322.lab06.componentes;
import mc322.lab06.Caverna;

public class Heroi extends Componente{
    

	private int qtdFlechas=1;
	private boolean pegouTesouro = false;
	private String nome;

	public Heroi(int linha, int coluna, char identificador,Caverna caverna) {
		super(linha, coluna, identificador,caverna);
	}
	
	public int getQtdFlechas() {
		return qtdFlechas;
	}
	public void setQtdFlechas(int qtdFlechas) {
		this.qtdFlechas=qtdFlechas;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
