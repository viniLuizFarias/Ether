package mc322.lab06;


import java.util.Scanner;

import mc322.lab06.componentes.*;

public class AppMundoWumpus {
    
	public static void main(String[] args) {


		
		String entradaCsv= args[0];

		//Gera a caverna
		Caverna caverna = MontadorCaverna.criarCaverna(entradaCsv);
		
		//Inicializa o controle
		Controle controle = new Controle(caverna);
		
		//Obtém o herói e o nome
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite o nome do seu Herói! :");
		String nomeHeroi = keyboard.nextLine();
		Heroi player = controle.getHeroi();
		player.setNome(nomeHeroi);

		
		
		controle.imprimir();
		//controle.escreverCSV(arquivoSaida);

		while(!controle.jaAcabou()){
			String input = keyboard.nextLine();
			if (input.length() != 0){
				
				char acao = input.charAt(0);
				String msg = controle.comando(acao);
				controle.imprimir();
				//controle.escreverCSV(arquivoSaida);
				if (msg != ""){
					System.out.println(msg);
				}
				
			}
		}
		System.exit(0);
		
	}
}
