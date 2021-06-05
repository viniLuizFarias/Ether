package mc322.lab07.model.peca;
import mc322.lab07.model.Tabuleiro;


public abstract class Peca {
	protected int vida;
	protected int ataque;
	protected int mobilidade;
	protected int player;
	protected Tabuleiro tabuleiro;
	
	public static Peca construirPeca(){
		// DEVE SER SOBREESCRITO
        Guerreiro guerreiro = new Guerreiro();
        return guerreiro;
    }
	
	public abstract  int validarMovimento();
	public abstract  int atacar();
	public abstract boolean efeito();
	

	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return this.ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMobilidade() {
		return this.mobilidade;
	}

	public void setMobilidade(int mobilidade) {
		this.mobilidade = mobilidade;
	}

	public int getPlayer() {
		return this.player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
	

}
