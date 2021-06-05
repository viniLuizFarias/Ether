package mc322.lab07.model;
import mc322.lab07.model.peca.*;

public class Jogador {

	private int vida;
	private int qtdTotalPecas;
	private int identificador;
	private Peca[] cartas;

	public Jogador(int vida,int identificador,Peca cartas[]){
		this.vida = vida;
		this.identificador = identificador;
		this.qtdTotalPecas = 0;
		this.cartas = cartas;
	}
	









	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getQtdTotalPecas() {
		return this.qtdTotalPecas;
	}

	public void setQtdTotalPecas(int qtdTotalPecas) {
		this.qtdTotalPecas = qtdTotalPecas;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public Peca[] getCartas() {
		return this.cartas;
	}

	public void setCartas(Peca[] cartas) {
		this.cartas = cartas;
	}

	
	
}
