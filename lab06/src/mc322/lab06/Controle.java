package mc322.lab06;

import mc322.lab06.componentes.*;

public class Controle {
  
	private int pontuacao=0;
	private Componente[] componentes;
	private Caverna caverna;
	private Heroi heroi;

	
	public Controle(Caverna caverna,String nomeHeroi) {
		this.caverna = caverna;		
		this.heroi = iniciarHeroi();
		heroi.setNome(nomeHeroi);
		
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
	
	
	
}
