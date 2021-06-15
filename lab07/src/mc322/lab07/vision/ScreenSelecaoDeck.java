package mc322.lab07.vision;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import mc322.lab07.model.Deck;
import mc322.lab07.model.Decks.Deck0.Deck0;
import mc322.lab07.model.Decks.Deck1.Deck1;
import mc322.lab07.model.Decks.Deck2.Deck2;

public class ScreenSelecaoDeck extends JFrame{
		private String nomeSelecionada="@@";
		private int vidaSelecionada,ataqueSelecionada,restanteSelecionada=0;
		public ScreenSelecaoDeck(int altura, int largura) {
			
			
			super();
			setSize(altura,largura);
			this.setTitle("Seleção de Deck");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setVisible(false);
			
			Deck0 deck0 = new Deck0(); 
			//Deck1 deck1 = new Deck1(); 
			//Deck2 deck2 = new Deck2(); 
			
			gerarInfos(0,0);
			gerarCartas(450,150,deck0);
			gerarCartas(450,400,deck0);
			gerarCartas(450,650,deck0);
			
			gerarSelecionarDecks(100, 0);
			
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		private void gerarCartas(int xTrans,int yTrans,Deck deck) {
			//GERA AS CARTAS DA MÃO DO JOGADOR
			int tamanhoCarta=192;
			for(int i=0;i<5;i++) {
				JLabelVisualizarCarta carta = new JLabelVisualizarCarta(deck.getPecaLista(i).getNome(),deck.getPecaLista(i).getNomeArquivo(), tamanhoCarta, deck.getIdentificador(),i);
				carta.setLocation(xTrans+i*(tamanhoCarta+16),yTrans);
				this.add(carta);
			}
			
		}
		private void gerarSelecionarDecks(int xTrans, int yTrans) {
			//VOU ALTERAR
			
			JLabelInterativa deck1 = new JLabelInterativa("Selecionar Deck 0",192,"Carta");
			deck1.setLocation(xTrans,150+yTrans);
			this.add(deck1);
			
			JLabelInterativa deck2 = new JLabelInterativa("Selecionar Deck 0",192,"Carta");
			deck2.setLocation(xTrans,400+yTrans);
			this.add(deck2);

			
			JLabelInterativa deck3 = new JLabelInterativa("Selecionar Deck 0",192,"Carta");
			deck3.setLocation(xTrans,650+yTrans);
			this.add(deck3);
			
		}
		
		private void gerarInfos(int xTrans,int yTrans) {
			//IMG
			JLabelInterativa picInfo = new JLabelInterativa("Selecionar Deck 0",192,"Carta");
			picInfo.setLocation(1625+xTrans,150+yTrans);
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
			JLabel txtRest = new JLabel("Restante : ");
			txtRest.setLocation(1550+xTrans,430+yTrans);
			txtRest.setSize(200,200);
			txtRest.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtRest);
			
			JLabel txtintRest = new JLabel(this.restanteSelecionada+"");
			txtintRest.setLocation(1750+xTrans,430+yTrans);
			txtintRest.setSize(200,200);
			txtintRest.setFont(new Font("MV Boli", Font.BOLD,30));
			this.add(txtintRest);
			
			
			
		}
		
}
