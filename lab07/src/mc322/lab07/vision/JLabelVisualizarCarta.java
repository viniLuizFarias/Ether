package mc322.lab07.vision;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JLabelVisualizarCarta extends JLabelInterativa {

	int deck;
	int identificador;
	public JLabelVisualizarCarta(String nome,String nomeArquivo, int tamanho,int deck,int identificador) {
		super(nome, tamanho,nomeArquivo);
		this.identificador = identificador;
		this.deck = deck;
		tornarInterativa();
		
		
	}

	public void tornarInterativa() {
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent arg0) {

				
			}


			public void mouseEntered(MouseEvent arg0) {
					System.out.println("Nome: "+nome+ " Identificador: "+identificador +" Deck: "+deck);
					
			}


			public void mouseExited(MouseEvent arg0) {

				
			}


			public void mousePressed(MouseEvent arg0) {
				
			}
			
			
			
			
			
		});
		
	}

}
