package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mc322.lab07.controller.Controle;
import mc322.lab07.model.ICarta;
import mc322.lab07.model.Peca;

public class JLabelCarta extends JLabelInterativa{
//CARTA NA MAO DO JOGADOR
	
	
	private static final long serialVersionUID = -2851445424921471765L;
	int jogador;
	boolean clicavel;
	int identificador;
	Controle controle;
	ScreenInGame janelaMae;

	public JLabelCarta(String nome, int tamanho,int jogador,int identificador,boolean clicavel,String nomeArquivo,Controle controle,ScreenInGame janelaMae) {
		super(nome, tamanho,nomeArquivo);
		this.jogador = jogador;
		this.clicavel=clicavel;
		this.identificador=identificador;
		this.controle = controle;
		this.janelaMae = janelaMae;
		
		tornarInterativa();

	}


	
	
	public void tornarInterativa() {
		// FAZ COM QUE ESTE COMPONENTE RESPONDA AO MOUSE
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				if(clicavel) {
				int[] coord = {jogador,identificador};
				controle.cartaSelecionada(coord);
				}
			}

			public void mouseClicked(MouseEvent arg0) {

				
			}


			public void mouseEntered(MouseEvent arg0) {
				
				ICarta peca = controle.getJogador(jogador).getDeck().getCartaLista(identificador);
				janelaMae.alterarSelecionada((Peca)peca);

			}


			public void mouseExited(MouseEvent arg0) {

				
			}


			public void mousePressed(MouseEvent arg0) {
				
			}
			
			
			
			
			
		});
		
	}

}
