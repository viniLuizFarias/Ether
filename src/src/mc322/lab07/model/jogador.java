package mc322.lab07.model;

public class Jogador {

	private int vida;
	private int identificador;
	private int[] quantasPecasDeCada;
	private Deck deck;

	public Jogador(int vida,int identificador){
		this.vida = vida;
		this.identificador = identificador;
	}
	
	public boolean podePorPeca(int numeroPeca){
		return quantasPecasDeCada[numeroPeca] < deck.getCartaLista(numeroPeca).getqtdMax();
	}

	public void pecaEliminada(Peca peca){
		int numeroPeca = deck.nomeToIdn(peca.getNome());
		if(deck.getNCartaEspecial() != numeroPeca){
			this.quantasPecasDeCada[numeroPeca] -= 1;
		}
	}

	public void levarDano(int dano){
		this.vida -= dano;
	}

	public boolean vivo(){
		return this.vida > 0;
	}


	public void atualizarNumeroPecas(int numeroCarta){
		quantasPecasDeCada[numeroCarta] += 1;
	}

	public ICarta getCarta(int numeroCarta){
		return deck.getCartaLista(numeroCarta);
	}


	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public Deck getDeck() {
		return this.deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
		this.quantasPecasDeCada = new int[deck.getTamanho()];
		for (int i = 0;i<deck.getTamanho();i++){
			quantasPecasDeCada[i] = 0;
		}
	}

	
	
}
