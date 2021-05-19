package mc322.lab06.componentes;
import java.util.Random;

import mc322.lab06.Caverna;

public class Wumpus extends Componente{

	public Wumpus(int linha, int coluna, char identificador,Caverna caverna) {
		super(linha, coluna, identificador,caverna);
	}
    
	public boolean foiDerrotado() {
		//Verifica se o wumpus foi derrotado, se sim, retorna true, senão, false
	    Random random = new Random();
	    if(random.nextInt(2)==1) {
	    	return true;
	    }
	    return false;
	}
}
