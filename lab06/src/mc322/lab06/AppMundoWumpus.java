package mc322.lab06;


import java.util.Scanner;

import mc322.lab06.componentes.*;

public class AppMundoWumpus {
    
	public static void main(String[] args) {

		String entradaCsv= args[0];
		String nomeHeroi = args[1];
		
		//Obtém o nome do jogador
		//Scanner keyboard = new Scanner(System.in);
		//System.out.println("Digite o nome do seu Herói! :");
		//String nomeHeroi = keyboard.nextLine();
		
		//Gera a caverna
		Caverna caverna = new Caverna(entradaCsv);
		
		//Inicializa o controle
		Controle controle = new Controle(caverna);
		
		//Obtém o herói e o nome
		Heroi player = controle.getHeroi();
		player.setNome(nomeHeroi);

		
		
		caverna.Imprimir();
		System.out.println(controle.getHeroi().getNome());
		
		
	}
}
