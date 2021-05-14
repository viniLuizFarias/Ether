package mc322.lab06;

import mc322.lab06.componentes.*;

public class Controle {
  
	private int pontuacao=0;
	private Componente[] componentes;
	private Caverna caverna;
	private Heroi heroi;

	
	public Controle(Caverna caverna) {
		this.caverna = caverna;		
		this.heroi = iniciarHeroi();
	}
	public void movimentarHeroi(char direcao) {
		
	}
	public void incrementarPontuacao(int incremento) {
		this.pontuacao+=incremento;
		
	}
	private Heroi iniciarHeroi() {
	//Permite que o controle enxergue o heroi
		Heroi heroi = (Heroi) caverna.componenteMaiorPrioridade(0,0);
		return heroi;
	}
	public Heroi getHeroi() {
		return heroi;
	}
	public Caverna getCaverna() {
		return caverna;
	}

	public char haEncontro() {
		//Retorna o identificador do componente que está na casa junto com o heroi
		//Se não houver nenhum, retorna -
		if(caverna.estaoNaMesmaSala('W',heroi.getIdentificador(), heroi.getLinha(), heroi.getColuna())) {
			return 'W';
		}
		if(caverna.estaoNaMesmaSala('B',heroi.getIdentificador(), heroi.getLinha(), heroi.getColuna())) {
			return 'B';
		}
		if(caverna.estaoNaMesmaSala('O',heroi.getIdentificador(), heroi.getLinha(), heroi.getColuna())) {
			return 'O';
		}
		
		
		return '-';
	}
	public void comando(char comando) {
		
		if("wasd".indexOf(comando)!=-1) {
			heroi.mover(comando);
			this.pontuacao-=15;
			char encontro = haEncontro();
			if(encontro =='-') {
				return;
			}
			if(encontro =='B') {
				this.pontuacao-=1000;
				//PERDEU
			}
			if(encontro =='W'){
				Wumpus wumpus = (Wumpus) heroi.getSala().obterComponente('W');
				if(heroi.combater(wumpus)==true) {
					this.pontuacao+=500;
					//MATOU O WUMPUS
				}
				else {
					this.pontuacao-=1000;
					//PERDEU
				}
			}
			
			heroi.setIsFlechaEquipada(false);
				
		}
		
		if(comando=='k') {
			if(heroi.getQtdFlechas()==1) {
				heroi.setQtdFlechas(0);
				this.pontuacao-=100;
				heroi.setIsFlechaEquipada(true);
			}
			else {
				System.out.println("Não há flechas");
			}
		}
		
		if(comando=='c') {
			if(haEncontro()=='O') {
				heroi.setPegouTesouro(true);
				heroi.getSala().removerComponente('O');
				//COLETOU O TESOURO
						}
			else {
				System.out.println("Não há tesouro nesta sala");
			}
		}
		if(comando=='q') {}
	}
	
	
}
