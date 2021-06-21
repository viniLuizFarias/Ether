package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mc322.lab07.controller.Controle;

public class JLabelCelula extends JLabelInterativa{
	int linha,coluna;
	private Controle controle;

	public JLabelCelula(String nome,int linha,int coluna, int tamanho,String nomeArquivo,Controle controle) {
		super(nome, tamanho,nomeArquivo);
		this.linha = linha;
		this.coluna = coluna;
		this.controle = controle;
		tornarInterativa();

	}

	@Override
	public void tornarInterativa() {
		
		
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				System.out.println("Nome: "+nome +" Linha: "+ linha +" Coluna: "+coluna);
				int[] coords = {linha,coluna};
				controle.celulaSelecionada(coords);
			}

			public void mouseClicked(MouseEvent arg0) {

				
			}


			public void mouseEntered(MouseEvent arg0) {

				
			}


			public void mouseExited(MouseEvent arg0) {

				
			}


			public void mousePressed(MouseEvent arg0) {
				
			}
			
			
			
			
			
		});
		
	}
	
	

}
