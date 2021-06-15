package mc322.lab07.model;

public class Deck {
	
	protected int identificador;
	protected String nome;
	protected Peca [] listaPecas = new Peca[5];
	
	public Deck(int identificador,String nome) {
		this.identificador = identificador;
		this.nome = nome;
	}
	
	public void setPecaLista(Peca peca,int i) {
		
		this.listaPecas[i]=peca;
		
	}
	public Peca getPecaLista(int i) {
		return this.listaPecas[i];
		
	}
	public int getIdentificador() {
		return identificador;
	}
	public String getNome() {
		return this.nome;
	}
}
