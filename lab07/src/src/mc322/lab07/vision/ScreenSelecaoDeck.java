package mc322.lab07.vision;
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
		private String nomeSelecionada="@@";
		private Controle controle;
		private int vidaSelecionada,ataqueSelecionada,restanteSelecionada,mobilidadeSelecionada=0;
		public ScreenSelecaoDeck(int altura, int largura,Controle controle) {
			
			
			super();
			setSize(altura,largura);
			this.setTitle("Seleção de Deck");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setVisible(false);
			this.controle = controle;

			Deck0 deck0 = new Deck0(); 
			Deck1 deck1 = new Deck1(); 
			Deck2 deck2 = new Deck2(); 
			
			gerarInfos(0,0);
			gerarCartas(450,150,deck0);
			gerarCartas(450,400,deck1);
			gerarCartas(450,650,deck2);
			
			gerarSelecionarDecks(100, 0);
			
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		private void gerarCartas(int xTrans,int yTrans,Deck deck) {

			int tamanhoCarta=192;
			for(int i=0;i<5;i++) {
				JLabelVisualizarCarta carta = new JLabelVisualizarCarta(deck.getPecaLista(i).getNome(),deck.getPecaLista(i).getNomeArquivo(), tamanhoCarta, deck.getIdentificador(),i);
				carta.setLocation(xTrans+i*(tamanhoCarta+16),yTrans);
				//ISSO DEIXA TODAS AS CARTAS SEM TEXTURA - PARA TESTE
				carta.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\Carta.png"));
				this.add(carta);
			}
			
		}
		private void gerarSelecionarDecks(int xTrans, int yTrans) {
			
			JLabel deck1 = new JLabel();
			deck1.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\Carta.png"));
			deck1.setSize(192,192);
			adicionarMouseListener(deck1);
			deck1.setLocation(xTrans,150+yTrans);
			this.add(deck1);
			
			JLabel deck2 = new JLabel();
			deck2.setLocation(xTrans,400+yTrans);
			deck2.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\Carta.png"));
			deck2.setSize(192,192);
			adicionarMouseListener(deck2);
			this.add(deck2);

			
			JLabel deck3 = new JLabel();
			deck3.setLocation(xTrans,650+yTrans);
			deck3.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\Carta.png"));
			deck3.setSize(192,192);
			adicionarMouseListener(deck3);
			this.add(deck3);
			
		}
		
		private void gerarInfos(int xTrans,int yTrans) {
			//IMG
			JLabel picInfo = new JLabel();
			picInfo.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\grama.png"));
			picInfo.setLocation(1625+xTrans,150+yTrans);
			picInfo.setSize(200,200);
			this.add(picInfo);
			//NOME
			JLabel txtNome = new JLabel("Nome : ");
			txtNome.setLocation(1550+xTrans,310+yTrans);
			txtNome.setSize(200,200);
			txtNome.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtNome);
			
			JLabel txtintNome = new JLabel(this.nomeSelecionada);
			txtintNome.setLocation(1750+xTrans,310+yTrans);
			txtintNome.setSize(200,200);
			txtintNome.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintNome);
			
			//ATAQUE
			JLabel txtAtq = new JLabel("Ataque : ");
			txtAtq.setLocation(1550+xTrans,350+yTrans);
			txtAtq.setSize(200,200);
			txtAtq.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtAtq);
			
			JLabel txtintAtq = new JLabel(this.ataqueSelecionada+"");
			txtintAtq.setLocation(1750+xTrans,350+yTrans);
			txtintAtq.setSize(200,200);
			txtintAtq.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintAtq);
			//VIDA
			JLabel txtVida = new JLabel("Vida : ");
			txtVida.setLocation(1550+xTrans,390+yTrans);
			txtVida.setSize(200,200);
			txtVida.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtVida);
			
			JLabel txtintVida = new JLabel(this.vidaSelecionada+"");
			txtintVida.setLocation(1750+xTrans,390+yTrans);
			txtintVida.setSize(200,200);
			txtintVida.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintVida);
			//RESTANTE
			JLabel txtRest = new JLabel("Quantidade : ");
			txtRest.setLocation(1550+xTrans,430+yTrans);
			txtRest.setSize(200,200);
			txtRest.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtRest);
			
			JLabel txtintRest = new JLabel(this.restanteSelecionada+"");
			txtintRest.setLocation(1750+xTrans,430+yTrans);
			txtintRest.setSize(200,200);
			txtintRest.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintRest);
			//MOBILIDADE
			JLabel txtMob = new JLabel("Mobilidade : ");
			txtMob.setLocation(1550+xTrans,470+yTrans);
			txtMob.setSize(200,200);
			txtMob.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtMob);
			
			JLabel txtintMob = new JLabel(this.mobilidadeSelecionada+"");
			txtintMob.setLocation(1750+xTrans,470+yTrans);
			txtintMob.setSize(200,200);
			txtintMob.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintMob);			
			
			
		}

		public void alterarSelecionada(Peca peca) {
			this.mobilidadeSelecionada=peca.getMobilidade();
			this.ataqueSelecionada=peca.getAtaque();
			this.vidaSelecionada = peca.getVida();
			this.nomeSelecionada=peca.getNome();
			
		}
		private void adicionarMouseListener(JLabel jlbl) {
			jlbl.addMouseListener(new MouseListener() {
				
				public void mouseReleased(MouseEvent e) {
					
				}

				public void mouseClicked(MouseEvent arg0) {

					System.out.println("CLICOU");
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
