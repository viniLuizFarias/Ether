package mc322.lab06;
import mc322.lab06.componentes.Componente;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;  


public class Caverna {
	// DICIONARIO QUE ARMAZENA A PRIORIDADE DE CADA TIPO DE COMPONENTE
	static Map<Character, Integer> dicionarioPrioridades = new HashMap<Character, Integer>();

	private Sala[][] tabuleiroCaverna;

	Caverna(){
		this.tabuleiroCaverna = new Sala[4][4];
		for(int linha =0;linha <4;linha++) {
			for(int coluna=0;coluna<4;coluna ++) {
				this.tabuleiroCaverna[linha][coluna] = new Sala();
			}
		}
	}

	Componente componenteMaiorPrioridade(int linha, int coluna){
		return getTabuleiroCaverna()[linha][coluna].componenteMaiorPrioridade();
	}
	boolean salaPreenchida(int linha,int coluna){
		Componente[] componentes = tabuleiroCaverna[linha][coluna].getComponentes();
		if (componentes == null){
			return false;
		}
		for (int i = 0;i<componentes.length;i++){
			if (componentes[i].getIdentificador() == 'O' ||componentes[i].getIdentificador() == 'P'||componentes[i].getIdentificador() == 'B'||componentes[i].getIdentificador() == 'W'){
				return true;
			}
		}
		return false;
	}

	Componente[] getAllComponents(){
		int len = 0;
		for(int linha = 0;linha<4;linha++){
			for(int coluna=0;coluna<4;coluna++){
				len += tabuleiroCaverna[linha][coluna].getComponentes().length;
			}
		}
		int posicao = 0;
		Componente[] retorno = new Componente[len];
		for(int linha = 0;linha<4;linha++){
			for(int coluna=0;coluna<4;coluna++){
				Componente[] atual = tabuleiroCaverna[linha][coluna].getComponentes();
				System.arraycopy(atual, 0, retorno, posicao,atual.length);
				posicao += atual.length;
			}
		}
		return retorno;
	}


	void Imprimir(){
		for (int linha = 0;linha<4;linha++){
			System.out.print(linha+1+" ");
			for(int coluna = 0;coluna<4;coluna++){
				System.out.print(getTabuleiroCaverna()[linha][coluna].String()+" ");
			}
			System.out.println("");
		}
		System.out.println("  1 2 3 4 ");
	}

	public String[] String(){
		String[] retorno = new String[16];
		for (int linha=0;linha<4;linha++){
			for(int coluna=0;coluna<4;coluna ++) {
				Componente comp = tabuleiroCaverna[linha][coluna].componenteMaiorPrioridade();
				char simbolo = '-';
				if (comp != null){
					if(comp.getIdentificador() != 'b' && comp.getIdentificador() != 'f'){
						simbolo = comp.getIdentificador();
					}
				}
				retorno[linha +4*coluna] = Integer.toString(coluna+1)+":"+Integer.toString(linha+1)+","+simbolo;
				
			}
		}
		return retorno;
	}

	public Sala[][] getTabuleiroCaverna() {
		return tabuleiroCaverna;
	}

	public void setTabuleiroCaverna(Sala[][] tabuleiroCaverna) {
		this.tabuleiroCaverna = tabuleiroCaverna;
	}

	public boolean estaoNaMesmaSala(char identificadorA,char identificadorB,int linha,int coluna) {
		//Verifica se tem 2 componentes na memsma sala (Útil para ver se o jogador está interagindo)
		List<Componente> lista = this.tabuleiroCaverna[linha][coluna].listaComponentes;
		int n=0;
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getIdentificador()==identificadorA){
				n++;
				break;
			}	
		}
		for(int j=0;j<lista.size();j++) {
			if(lista.get(j).getIdentificador()==identificadorB){
				n++;
				break;
			}	
		}
		if(n==2) {
			return true;
		}
		return false;
	}
	
}
