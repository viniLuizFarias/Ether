package mc322.lab06;
import mc322.lab06.componentes.*;

public class MontadorCaverna {
    
	public static Componente[][] gerarCaverna(String caminhoCsv){
		
		
		Componente[][] tabuleiroCaverna= new Componente[4][4];
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(caminhoCsv);
		String[] comandos = csv.requestCommands();
		
		for(int linha =0;linha <4;linha++) {
			for(int coluna=0;coluna<4;coluna ++) {
				tabuleiroCaverna[linha][coluna] = new Componente(linha,coluna,"Vazio");
			}
		}
		
		//Inicializa um heroi vazio
		tabuleiroCaverna[0][0]= new Heroi(0,0,"SemNome");
		
		//N sei como o csv ta funcionando depois que eu descobrir eu implemento
		
		
		return tabuleiroCaverna;
		
	}
	
}
