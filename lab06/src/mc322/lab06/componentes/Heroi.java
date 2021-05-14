package mc322.lab06.componentes;
import mc322.lab06.Caverna;

public class Heroi extends Componente{
    

	private int qtdFlechas=1;
	private boolean isFlechaEquipada=false;
	private boolean pegouTesouro = false;
	private String nome;

	public Heroi(int linha, int coluna, char identificador,Caverna caverna) {
		super(linha, coluna, identificador,caverna);
	}
	private Boolean ehMovimentoValido(char direcao) {
		//Verifica se um movimento é válido
		int linhaProx = this.linha;
		int colunaProx = this.coluna;
		
		switch (direcao) {
		case 's':
			linhaProx+=1;
			break;
		case 'w':
			linhaProx-=1;

			break;
		case 'a':
			colunaProx-=1;
			break;
		case 'd':
			colunaProx+=1;
			break;
		default:
			break;
		}
		if(colunaProx<0 || colunaProx>3) {
			return false;
		}
		else if(linhaProx<0 || linhaProx>3) {
			return false;
		}
		return true;
		
	}
	public int getQtdFlechas() {
		return qtdFlechas;
	}
	public void mover(char direcao) {
		//Move o heroi, somente isso
		if(!ehMovimentoValido(direcao)) {
			System.out.println("Movimento Inválido");
			return;
			
		}
		switch (direcao) {
		case 's':
			this.caverna.getTabuleiroCaverna()[linha][coluna].removerComponente(this);
			this.linha+=1;
			this.caverna.getTabuleiroCaverna()[linha][coluna].adicionarComponente(this);
			break;
		case 'w':
			this.caverna.getTabuleiroCaverna()[linha][coluna].removerComponente(this);
			this.linha-=1;
			this.caverna.getTabuleiroCaverna()[linha][coluna].adicionarComponente(this);
			break;
		case 'a':
			this.caverna.getTabuleiroCaverna()[linha][coluna].removerComponente(this);
			this.coluna-=1;
			this.caverna.getTabuleiroCaverna()[linha][coluna].adicionarComponente(this);
			break;
		case 'd':
			this.caverna.getTabuleiroCaverna()[linha][coluna].removerComponente(this);
			this.coluna+=1;
			this.caverna.getTabuleiroCaverna()[linha][coluna].adicionarComponente(this);
			break;
			
		default:
			break;
		}
	}
	public void setQtdFlechas(int qtdFlechas) {
		this.qtdFlechas=qtdFlechas;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public boolean getIsFlechaEquipada() {
		return isFlechaEquipada;
	}
	public void setIsFlechaEquipada(boolean status) {
		this.isFlechaEquipada=status;
	}
	public boolean getPegouTesouro() {
		return pegouTesouro;
	}
	public void setPegouTesouro(boolean pegouTesouro) {
		this.pegouTesouro = pegouTesouro;
	}

	public boolean combater(Wumpus oponente) {
		//Se o heroi ganhar o combate, retorna true, senão, false.
		if(isFlechaEquipada==false) {
			return false;
		}
		return oponente.foiDerrotado();
	}
	
	
	
}
