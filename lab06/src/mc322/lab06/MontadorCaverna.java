package mc322.lab06;
import mc322.lab06.componentes.*;

public class MontadorCaverna {
	public static Sala[] getSalasAdj(int linha, int coluna, Sala[][] tab){
		Sala[] salasAdj = new Sala[4];
		if (linha != 0){
			salasAdj[0] = tab[linha-1][coluna];
		}
		if (coluna != 0){
			salasAdj[1] = tab[linha][coluna-1];
		}
		if (linha != 3){
			salasAdj[2] = tab[linha+1][coluna];
		}
		if (coluna != 3){
			salasAdj[3] = tab[linha][coluna+1];
		}
		return salasAdj;
	}

	public static Componente addComponente(int linha,int coluna,char tipo,Caverna caverna,Sala[][] tab){
		Sala sala = tab[linha][coluna];
		if(tipo == 'P'){
			sala.adicionarComponente(new Heroi(linha, coluna,tipo,caverna));
		}else if(tipo == 'O'){
			sala.adicionarComponente(new Ouro(linha, coluna,tipo,caverna));
		}else if(tipo == 'B'){
			sala.adicionarComponente(new Buraco(linha, coluna,tipo,caverna));
			Sala[] salasAdjacentes = getSalasAdj(linha, coluna,tab);
			for (int i = 0;i<salasAdjacentes.length;i++){
				if (salasAdjacentes[i] != null)
					salasAdjacentes[i].adicionarComponente(new Componente(linha, coluna,'b',caverna));
			}
		}else if(tipo == 'W'){
			sala.adicionarComponente(new Wumpus(linha, coluna,tipo,caverna));
			Sala[] salasAdjacentes = getSalasAdj(linha, coluna,tab);
			for (int i = 0;i<salasAdjacentes.length;i++){
				if (salasAdjacentes[i] != null)
					salasAdjacentes[i].adicionarComponente(new Componente(linha, coluna,'f',caverna));
			}
		}
		return null;
	}

	public static void gerarDicionarioPrioridades(){
		Caverna.dicionarioPrioridades.put('B',4);
		Caverna.dicionarioPrioridades.put('W',4);
		Caverna.dicionarioPrioridades.put('O',4);
		Caverna.dicionarioPrioridades.put('P',3);
		Caverna.dicionarioPrioridades.put('f',2);
		Caverna.dicionarioPrioridades.put('b',1);
	}

	public static Sala[][] gerarCaverna(String caminhoCsv,Caverna caverna,String nomeHeroi){
		
		
		Sala[][] tabuleiroCaverna= new Sala[4][4];
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(caminhoCsv);
		String[][] configInicial = csv.requestCommands();
		gerarDicionarioPrioridades();
		
		for(int linha =0;linha <4;linha++) {
			for(int coluna=0;coluna<4;coluna ++) {
				
				tabuleiroCaverna[linha][coluna] = new Sala();
				tabuleiroCaverna[linha][coluna].setExplorada(true);
			}
		}
		for(int linha =0;linha <4;linha++) {
			for(int coluna=0;coluna<4;coluna ++) {
				char letra = configInicial[4*linha+coluna][1].charAt(0);
				if (letra!='_'){
					addComponente(linha, coluna,letra, caverna,tabuleiroCaverna);
				}
			}
		}

		
		
		return tabuleiroCaverna;
		
	}
	
}
