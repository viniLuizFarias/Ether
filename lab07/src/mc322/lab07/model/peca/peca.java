package mc322.lab07.model.peca;

public abstract class peca {
	
	protected int vida;
	protected int ataque;
	protected int mobilidade;
	
	
	public abstract  int validarMovimento();
	public abstract  int atacar();
	public abstract boolean efeito();
	
	

}
