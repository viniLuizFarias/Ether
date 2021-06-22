package mc322.lab07.model;

public abstract class Peca implements IPeca{
	protected int linha;
	protected int coluna;
	protected int vida;
	protected int ataque;
	protected int mobilidade;
	protected int player;
	protected int quantidade;
	protected String nome;
	protected Tabuleiro tabuleiro;
	protected String nomeArquivo;
	
	public Peca(int vida,int ataque,int mobilidade,String nome,String nomeArquivo) {
		this.vida=vida;
		this.ataque=ataque;
		this.mobilidade=mobilidade;
		this.nome = nome;
		this.nomeArquivo=nomeArquivo;
		
	}
	public abstract  int atacar();
	public abstract boolean efeito();
	public abstract Peca gerarPeca();
	
	public boolean validarMovimento(int[] coords){

	}

	public int getVida() {
	
		return this.vida;
	}

	public void setPosicao(int[] coord){
		this.linha = coord[0];
		this.coluna = coord[1];
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
	public String getNome() {

		return this.nome;
	}
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo=nomeArquivo;
	}
	

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	

}
