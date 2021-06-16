package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JLabelCelula extends JLabelInterativa{
	int linha,coluna;

	public JLabelCelula(String nome,int linha,int coluna, int tamanho,String nomeArquivo) {
		super(nome, tamanho,nomeArquivo);
		this.linha = linha;
		this.coluna = coluna;
		tornarInterativa();

	}

	@Override
	public void tornarInterativa() {
		
		
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				System.out.println("Nome: "+nome +" Linha: "+ linha +" Coluna: "+coluna);
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
