package mc322.lab07.model;

public class Deck {
	
	protected int identificador;
	protected int nCartaEspecial;
	protected String nome;
	protected ICarta [] listaCartas = new Peca[5];
	
	
	public Deck(int identificador,String nome) {
		this.identificador = identificador;
		this.nome = nome;
	}
	
	public int nomeToIdn(String nome){
		for (int i =0;i<listaCartas.length;i++){
			if(listaCartas[i].getNome().equals(nome)){
				return i;
			}
		}
		return -1;
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

	public int getNCartaEspecial() {
		return this.nCartaEspecial;
	}

	public void setNCartaEspecial(int nCartaEspecial) {
		this.nCartaEspecial = nCartaEspecial;
	}
}
