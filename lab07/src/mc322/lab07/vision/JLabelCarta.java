package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JLabelCarta extends JLabelInterativa{

	int jogador;
	boolean clicavel;

	public JLabelCarta(String nome, int tamanho,int jogador,int identificador,boolean clicavel,String nomeArquivo) {
		super(nome, tamanho,nomeArquivo);
		this.jogador = jogador;
		this.clicavel=clicavel;
		
		addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				if(clicavel) {
				System.out.println("Nome : "+nome +" Jogador: "+jogador+" Id: "+identificador);
				}
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
