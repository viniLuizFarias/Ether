package mc322.lab07.vision;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import mc322.lab07.controller.Controle;
import mc322.lab07.model.Peca;

public class JLabelVisualizarCarta extends JLabelInterativa {


	int identificador;
	ScreenSelecaoDeck janelaMae;
	Peca peca;
	public JLabelVisualizarCarta(int tamanho,Peca peca,int identificador,ScreenSelecaoDeck janelaMae) {
		super(peca.getNome(), tamanho ,peca.getNomeArquivo());
		this.identificador = identificador;
		this.janelaMae = janelaMae;
		this.peca = peca;
		tornarInterativa();
		
		
	}

	public void tornarInterativa() {
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent arg0) {

				
			}


			public void mouseEntered(MouseEvent arg0) {
	

					janelaMae.alterarSelecionada(peca);
			}


			public void mouseExited(MouseEvent arg0) {

				
			}


			public void mousePressed(MouseEvent arg0) {
				
			}
			
			
			
			
			
		});
		
	}

}
