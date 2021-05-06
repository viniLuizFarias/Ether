package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus {
    
	public static void main(String[] args) {

		String entradaCsv= args[0];
		
		//Gera a caverna
		Caverna caverna = new Caverna();
		caverna.tabuleiroCaverna  = MontadorCaverna.gerarCaverna(entradaCsv);
		
		//Obtém o nome do jogador
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite o nome do seu Herói! :");
		String nomeHeroi = keyboard.nextLine();
		
		
		//Inicializa o controle
		Controle controle = new Controle(caverna,nomeHeroi);
		
		
		
	}
}
