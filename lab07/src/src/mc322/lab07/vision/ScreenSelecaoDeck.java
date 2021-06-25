package mc322.lab07.vision;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mc322.lab07.controller.Controle;
import mc322.lab07.model.Deck;
import mc322.lab07.model.Peca;
import mc322.lab07.model.Decks.Deck0.Deck0;
import mc322.lab07.model.Decks.Deck1.Deck1;
import mc322.lab07.model.Decks.Deck2.Deck2;

public class ScreenSelecaoDeck extends JFrame implements IJanela{
		private Controle controle;
		private int altura,largura;
		
		//Componentes info carta
		JLabel picInfo = new JLabel();
		JLabel txtNome = new JLabel("Nome : ");
		JLabel txtAtq = new JLabel("Ataque : ");
		JLabel txtVida = new JLabel("Vida : ");
		JLabel txtRest = new JLabel("Quantidade : ");
		JLabel txtMob = new JLabel("Mobilidade : ");
		
		JLabel txtstrNome = new JLabel("Passe o");
		JLabel txtintAtq = new JLabel("mouse ");
		JLabel txtintVida = new JLabel("sobre");
		JLabel txtintRest = new JLabel("as");
		JLabel txtintMob = new JLabel("cartas");
		
		//Componentes visualmente interativos
		
		
		public ScreenSelecaoDeck(int altura, int largura,Controle controle) {
			
		
			super();

			this.largura = largura;
			this.altura = altura;
			setSize(altura,largura);
			this.setTitle("Seleção de Deck");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);

			this.setVisible(false);
			
			this.controle = controle;
			


			Deck0 deck0 = new Deck0(); 
			Deck1 deck1 = new Deck1(); 
			Deck2 deck2 = new Deck2(); 
			this.getContentPane().setBackground(Color.CYAN);
			gerarFundo();
			gerarInfos(-50,0);
			gerarCartas(450,150,deck0);
			gerarCartas(450,400,deck1);
			gerarCartas(450,650,deck2);
			
			gerarSelecionarDecks(100, 0);
			
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		private void gerarCartas(int xTrans,int yTrans,Deck deck) {

			int tamanhoCarta=192;
			for(int i=0;i<5;i++) {
				JLabelVisualizarCarta carta = new JLabelVisualizarCarta(tamanhoCarta, (Peca)deck.getCartaLista(i),i,this);
				carta.setLocation(xTrans+i*(tamanhoCarta+16),yTrans);
				this.add(carta);
			}
			
		}
		private void gerarFundo() {
			JLabel bg = new JLabel();
			bg.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\bg.png"));
			bg.setSize(1920,1080);
			this.add(bg);
		}
		private void gerarSelecionarDecks(int xTrans, int yTrans) {
			
			JLabel deck0 = new JLabel();
			deck0.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\DeckHumanos.png"));
			deck0.setSize(192,192);
			adicionarMouseListener(deck0,new Deck0());
			deck0.setLocation(xTrans,150+yTrans);
			this.add(deck0);
			
			JLabel deck1 = new JLabel();
			deck1.setLocation(xTrans,400+yTrans);
			deck1.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\DeckAnimais.png"));
			deck1.setSize(192,192);
			adicionarMouseListener(deck1,new Deck1());
			this.add(deck1);

			
			JLabel deck2 = new JLabel();
			deck2.setLocation(xTrans,650+yTrans);
			deck2.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\DeckMonstros.png"));
			deck2.setSize(192,192);
			adicionarMouseListener(deck2,new Deck2());
			this.add(deck2);
			
		}
		
		private void gerarInfos(int xTrans,int yTrans) {
			
			//IMG

			picInfo.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\CartaPadrao.png"));
			picInfo.setLocation(1625+xTrans,150+yTrans);
			picInfo.setSize(200,200);
			this.add(picInfo);
			//NOME

			txtNome.setLocation(1550+xTrans,310+yTrans);
			txtNome.setSize(230,200);
			txtNome.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtNome);
			

			txtstrNome.setLocation(1800+xTrans,310+yTrans);
			txtstrNome.setSize(200,200);
			txtstrNome.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtstrNome);
			
			//ATAQUE

			txtAtq.setLocation(1550+xTrans,350+yTrans);
			txtAtq.setSize(230,200);
			txtAtq.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtAtq);
			

			txtintAtq.setLocation(1800+xTrans,350+yTrans);
			txtintAtq.setSize(200,200);
			txtintAtq.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintAtq);
			//VIDA

			txtVida.setLocation(1550+xTrans,390+yTrans);
			txtVida.setSize(230,200);
			txtVida.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtVida);
			

			txtintVida.setLocation(1800+xTrans,390+yTrans);
			txtintVida.setSize(200,200);
			txtintVida.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintVida);
			//RESTANTE

			txtRest.setLocation(1550+xTrans,430+yTrans);
			txtRest.setSize(230,200);
			txtRest.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtRest);
			

			txtintRest.setLocation(1800+xTrans,430+yTrans);
			txtintRest.setSize(200,200);
			txtintRest.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintRest);
			//MOBILIDADE

			txtMob.setLocation(1550+xTrans,470+yTrans);
			txtMob.setSize(230,200);
			txtMob.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtMob);
			

			txtintMob.setLocation(1800+xTrans,470+yTrans);
			txtintMob.setSize(200,200);
			txtintMob.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintMob);			
			
			
		}

		public void alterarSelecionada(Peca peca) {

			
			picInfo.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+peca.getNomeArquivo()+".png"));
			txtstrNome.setText( peca.getNome());
			txtintAtq.setText( peca.getAtaque()+"");
			txtintMob.setText(peca.getMobilidade()+"");
			txtintRest.setText(peca.getqtdMax()+"");
			txtintVida.setText(peca.getVida()+"");
			
		}
		private void adicionarMouseListener(JLabel jlbl, Deck deck) {
			jlbl.addMouseListener(new MouseListener() {
				
				public void mouseReleased(MouseEvent e) {
					
				}

				public void mouseClicked(MouseEvent arg0) {

					System.out.println("CLICOU NO DECK: "+  deck.getIdentificador());
					controle.setDeckSelecionado(deck);
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
