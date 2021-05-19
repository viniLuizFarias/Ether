package mc322.lab06;
import mc322.lab06.componentes.*;

public class MontadorCaverna {
	public static Caverna criarCaverna(String arquivoEntrada){
		Caverna caverna = new Caverna();
		gerarSalas(arquivoEntrada,caverna);
		gerarDicionarioPrioridades();

		int[][] quantidadesAceitaveis = {{1,1},{1,1},{1,1},{2,3}}; // QUANTIDADES ADEQUADAS DE CADA COMPONENTE
		if(!quantidadesValidas(quantidadesAceitaveis,caverna)){
			System.out.println("Quantidades inadequadas de componentes");
			System.exit(3);
		}
		if(caverna.componenteMaiorPrioridade(0, 0) != null){
			if(caverna.componenteMaiorPrioridade(0, 0).getIdentificador() != 'P'){
				System.out.println("Heroi nao esta na sala 1,1");
				System.exit(4);
			}
		}else{
			System.out.println("Heroi nao esta na sala 1,1");
			System.exit(4);
		}
		return caverna;
	}

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

	public static int[] StrtoInt(String posicao){
		int posDoisPontos=0;
		while(true) {
			if(posicao.charAt(posDoisPontos)!=':') {
				posDoisPontos ++;
			}
			else {
				break;
			}
		}
		int[] retorno = new int[2];
		retorno[0] = Integer.valueOf(posicao.substring(0, posDoisPontos))-1;
		retorno[1] = Integer.valueOf(posicao.substring(posDoisPontos+1, posicao.length()))-1;
		if(retorno[0]<0||retorno[0]>3||retorno[1]<0||retorno[1]>3){
			System.out.println("Arquivo tentando iniciar salas que nao existem");
			System.exit(2);
		}
		return retorno;
	}

	public static boolean quantidadesValidas(int[][] quantidadesAceitaveis,Caverna caverna){
		//DEVE RECEBER UMA MATRIZ COM AS QUANTIDADES MINIMAS E MAXIMAS DE CADA COMPONENTE ABAIXO
		// 0->Ouro,1->Player,2->Whumpus,3->Buracos
		int[] quantidades = {0,0,0,0}; 
		Componente[] Componentes = caverna.getAllComponents();
		for(int i =0;i<Componentes.length;i ++){
			if (Componentes[i].getIdentificador() == 'O'){
				quantidades[0] += 1;
			}
			else if (Componentes[i].getIdentificador() == 'P'){
				quantidades[1] += 1;
			}
			else if (Componentes[i].getIdentificador() == 'W'){
				quantidades[2] += 1;
			}
			else if (Componentes[i].getIdentificador() == 'B'){
				quantidades[3] += 1;
			}
		}
		for(int i =0;i<quantidades.length;i ++){
			if(quantidades[i]<quantidadesAceitaveis[i][0]||quantidades[i]>quantidadesAceitaveis[i][1]){
				return false;
			}
		}
		return true;
	}

	public static void gerarDicionarioPrioridades(){
		Caverna.dicionarioPrioridades.put('B',4);
		Caverna.dicionarioPrioridades.put('W',4);
		Caverna.dicionarioPrioridades.put('O',4);
		Caverna.dicionarioPrioridades.put('P',3);
		Caverna.dicionarioPrioridades.put('f',2);
		Caverna.dicionarioPrioridades.put('b',1);
	}

	public static void gerarSalas(String caminhoCsv,Caverna caverna){
		
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(caminhoCsv);
		String[][] configInicial = csv.requestCommands();
		
		caverna.getTabuleiroCaverna()[0][0].setExplorada(true);
		for(int i =0;i <4;i++) {
			for(int j=0;j<4;j ++) {
				char letra = '_';
				if(configInicial[4*i+j]!=null){
					letra = configInicial[4*i+j][1].charAt(0);
				}
				if (letra!='_'){
					int coords[] = StrtoInt(configInicial[4*i+j][0]);
					int linha = coords[0];
					int coluna = coords[1];
					if(!caverna.salaPreenchida(linha, coluna)){
						addComponente(linha, coluna,letra, caverna,caverna.getTabuleiroCaverna());
					}else{
						System.out.println("CSV INICIANDO SALAS COM MAIS DE 1 COMPONENTE");
						System.exit(1);
					}
				}
			}
		}

	
	}
	
}
