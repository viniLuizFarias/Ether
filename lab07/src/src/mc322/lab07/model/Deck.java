package mc322.lab07.model;

public class Deck {
	
	protected int identificador;
	protected String nome;
	protected ICarta [] listaCartas = new Peca[5];
	
	
	public Deck(int identificador,String nome) {
		this.identificador = identificador;
		this.nome = nome;
	}
	
	public void setCartaLista(ICarta Carta,int i) {
		
		this.listaCartas[i]=Carta;
		
	}
	public ICarta getCartaLista(int i) {
		return this.listaCartas[i];
		
	}
	public int getIdentificador() {
		return identificador;
	}
	public String getNome() {
		return this.nome;
	}
	public int getTamanho(){
		return this.listaCartas.length;
	}
}
