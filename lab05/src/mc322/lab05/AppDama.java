package mc322.lab05;

public class AppDama {
	
	static CSVHandling csv = new CSVHandling();
	static String[] comandos;
	static Tabuleiro tab = new Tabuleiro();
	static String[] linhaTemporalTabuleiro;
	
	public static String[] executaJogo(String caminho_entrada,String caminho_saida) {
		//Permite acessar os comandos
		csv.setDataSource(caminho_entrada);
		comandos = csv.requestCommands();
		linhaTemporalTabuleiro = new String[comandos.length+1];
		
		//Mostra a condi��o inicial do tabuleiro
		System.out.println("Tabuleiro inicial: ");
		tab.imprimir();
		linhaTemporalTabuleiro[0]=tab.estadoEmString();
		tab.exportarArquivo(caminho_saida, false);

		PassarComandos(caminho_saida);


		
		return linhaTemporalTabuleiro;
	}
	public static void PassarComandos(String path) {
		//Passa por cada comando e executa
		boolean ocorreu_erro;
		for(int i=0;i<comandos.length;i++) {
			
			//Da o comando e mostra a sa�da conforme esperado
			System.out.println("\nSource: "+comandos[i].substring(0, 2));
			System.out.println("Target: "+comandos[i].substring(3, 5));
			ocorreu_erro = !tab.jogada(comandos[i].substring(0, 2),comandos[i].substring(3, 5));
			tab.imprimir();
			linhaTemporalTabuleiro[i+1]=tab.estadoEmString();
			
		}
	tab.exportarArquivo(path, ocorreu_erro);
		
	}
	public static void main(String[] args) {

		
		String[] retorno = AppDama.executaJogo(args[0],args[1]);

		
	}
}
