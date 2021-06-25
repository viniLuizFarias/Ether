package mc322.lab07.model;

public interface ICarta {
	public String getDescricao();
	public int getAtaque();
	public int getMobilidade();
	public String getNome();
	public String getNomeArquivo();
	public int getqtdMax();
	public Peca gerarPeca();
}
