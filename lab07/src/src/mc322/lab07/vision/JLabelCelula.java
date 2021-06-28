package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mc322.lab07.controller.Controle;
import mc322.lab07.model.Casa;
import mc322.lab07.model.Peca;

public class JLabelCelula extends JLabelInterativa{
//RESPONSÁVEL PELAS CELULAS DO TABULEIRO
	
	private static final long serialVersionUID = 3119551299196060209L;
	int linha,coluna;
	private Controle controle;
	private ScreenInGame janelaMae;
	
	public JLabelCelula(String nome,int linha,int coluna, int tamanho,String nomeArquivo,Controle controle,ScreenInGame janelaMae) {
		super(nome, tamanho,nomeArquivo);
		this.linha = linha;
		this.coluna = coluna;
		this.controle = controle;
		this.janelaMae = janelaMae;
		tornarInterativa();

	}


	public void tornarInterativa() {
		//TORNA O COMPONENTE RESPONSIVO AO MOUSE
		
		
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				int[] coords = {linha,coluna};
				controle.celulaSelecionada(coords);
			}

			public void mouseClicked(MouseEvent arg0) {
				
				
			}


			public void mouseEntered(MouseEvent arg0) {

				Peca peca=controle.getTabuleiro().getCasas()[linha][coluna].getPeca();
				janelaMae.alterarSelecionada(peca);

			}


			public void mouseExited(MouseEvent arg0) {

				
			}


			public void mousePressed(MouseEvent arg0) {
				
			}
			
			
			
			
			
		});
		
	}
	
	

}
