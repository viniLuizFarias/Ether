package mc322.lab07.model;

public interface IPeca {
	public void atacar(Peca Peca);
	public boolean validarMovimento(int[] coords);
	public Peca gerarPeca();
}
