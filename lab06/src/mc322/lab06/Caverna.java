package mc322.lab06;
import mc322.lab06.componentes.Componente;
import java.util.Map;
import java.util.HashMap;

public class Caverna {
	// DICIONARIO QUE ARMAZENA A PRIORIDADE DE CADA TIPO DE COMPONENTE
	static Map<Character, Integer> dicionarioPrioridades = new HashMap<Character, Integer>();

	Sala[][] tabuleiroCaverna;

	Caverna(String caminhoCsv,String nomeHeroi){
		tabuleiroCaverna = MontadorCaverna.gerarCaverna(caminhoCsv, this, nomeHeroi);
	}

	Componente componenteMaiorPrioridade(int linha, int coluna){
		return tabuleiroCaverna[linha][coluna].componenteMaiorPrioridade();
	}


	void Imprimir(){
		for (int linha = 0;linha<4;linha++){
			System.out.print(linha+1+" ");
			for(int coluna = 0;coluna<4;coluna++){
				System.out.print(tabuleiroCaverna[linha][coluna].String()+" ");
			}
			System.out.println("");
		}
		System.out.println("  1 2 3 4 ");
	}
}
