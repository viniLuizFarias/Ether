package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mc322.lab07.controller.Controle;

public class JLabelCarta extends JLabelInterativa{

	int jogador;
	boolean clicavel;
	int identificador;
	Controle controle;

	public JLabelCarta(String nome, int tamanho,int jogador,int identificador,boolean clicavel,String nomeArquivo,Controle controle) {
		super(nome, tamanho,nomeArquivo);
		this.jogador = jogador;
		this.clicavel=clicavel;
		this.identificador=identificador;
		this.controle = controle;
		
		tornarInterativa();

	}

	@Override
	
	
	public void tornarInterativa() {
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				if(clicavel) {
				System.out.println("Nome : "+nome +" Jogador: "+jogador+" Id: "+identificador);
				int[] coord = {jogador,identificador};
				controle.cartaSelecionada(coord);
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
