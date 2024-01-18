package mc322.lab07.vision;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import mc322.lab07.model.Peca;
import mc322.lab07.model.Tabuleiro;
import mc322.lab07.MainJogo;
import mc322.lab07.controller.Controle;
import mc322.lab07.model.Deck;
import mc322.lab07.model.ICarta;


public class ScreenInGame extends JFrame implements IJanela{
	//TELA PRINCIPAL DO JOGO
	
	
	private static final long serialVersionUID = 834757497130264557L;

		private int altura,largura;
		
		private Controle controle;
		
		
		//Comunicação e estrutura com o tabuleiro
		private Tabuleiro tabuleiro;
		private JLabelCelula tabuleiroVisual[][];
		
		//Componentes
		JLabel picInfo = new JLabel();

		
		JLabel txtStrNome = new JLabel("");
		JLabel txtintAtq = new JLabel("");
		JLabel txtintVida = new JLabel("");
		JLabel txtintRest = new JLabel("");
		JLabel txtintMob = new JLabel("");
		JTextArea txtStrDesc = new JTextArea("");
		
		JLabel txtintTurno = new JLabel();
		JLabel txtintVida0 = new JLabel();
		JLabel txtintVida1 = new JLabel();
		
		JLabel txtTurno = new JLabel();
		JLabel txtVida0 = new JLabel();
		JLabel txtVida1 = new JLabel();
		
		JLabel indicadorVezJogador1 = new JLabel();
		JLabel indicadorVezJogador2 = new JLabel();
		
		
	public ScreenInGame(int altura, int largura,Controle controle){
		super();
		setSize(altura,largura);
		this.setTitle("Ether");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(false);
		this.controle = controle;
		this.tabuleiroVisual = new JLabelCelula[altura][largura];
		tabuleiro = this.controle.getTabuleiro();
		this.getContentPane().setBackground(Color.decode("#BB7843"));
		
		gerarTabuleiro(20, 10,256,180);
		gerarCartas(286, 0,0,controle.getJogador(0).getDeck());
		gerarCartas(286, 820,1,controle.getJogador(1).getDeck());
		gerarScoreboard(25,100);
		gerarInfos(0, 0);
		gerarFundo(0,-50);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
	}
	
	private void gerarCartas(int xTrans,int yTrans,int idJogador,Deck deck) {
		//GERA AS CARTAS DA MÃO DO JOGADOR
		int tamanhoCarta=192;
		for(int i=0;i<5;i++) {
			String nomeArq = deck.getCartaLista(i).getNomeArquivo();
			ICarta peca = deck.getCartaLista(i);
			JLabelCarta carta = new JLabelCarta(peca.getNome(), tamanhoCarta,idJogador,i,true,nomeArq,controle,this);
			carta.setLocation(xTrans+i*(tamanhoCarta+64),yTrans);
			this.add(carta);
		}
		
	}
	private void gerarTabuleiro(int l, int c,int xTrans,int yTrans) {
		//GERA O TABULEIRO
		int tamanhoCelula = 64;
		for(int i=0;i<l;i++) {
			for(int j=0;j<c;j++) {
				JLabelCelula celula = new JLabelCelula("Celula", i, j,tamanhoCelula,"grama",controle,this);
				celula.setLocation(xTrans+i*tamanhoCelula, yTrans+j*tamanhoCelula);
				tabuleiroVisual[i][j]=celula;
				this.add(celula);
			}
		}
		
	}

	public void alterarSelecionada(Peca peca) {
		//ALTERA A INTERFACE COM BASE NA CARTA SELECIONADA
		if(peca == null) {
			
			picInfo.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\CartaPadrao.png"));
			txtStrNome.setText("");
			txtintAtq.setText("");
			txtintMob.setText("");
			txtintRest.setText("");
			txtintVida.setText("");
			txtStrDesc.setText("");
			
			return;
		}
		
		picInfo.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+peca.getNomeArquivo()+".png"));
		txtStrNome.setText( peca.getNome());
		txtintAtq.setText( peca.getAtaque()+"");
		txtintMob.setText(peca.getMobilidade()+"");
		txtintRest.setText(peca.getqtdMax()+"");
		txtintVida.setText(peca.getVida()+"");
		txtStrDesc.setText(peca.getDescricao());
		
	}
	public void atualizarScoreboard(int vidaJogador0,int vidaJogador1,int turno) {
		//ATUALIZA AS INFORMAÇÕES DE TURNO E JOGADORES
		
		txtintVida0.setText(vidaJogador0+"");
		txtintVida1.setText(vidaJogador1+"");
		txtintTurno.setText(turno +"");
		
		indicadorVezJogador1.setVisible(turno%2==0);
		indicadorVezJogador2.setVisible(turno%2!=0);
		
	}
	public void atualizarCasaTabuleiroVisual(int linha,int coluna) {
		//ATUALIZA O TABULEIRO 
		Peca peca = tabuleiro.getCasas()[linha][coluna].getPeca();
		String nomeArquivo;
		if(peca == null) {
			
			nomeArquivo = "grama";
		}
		else {
			nomeArquivo = peca.getNomeArquivo();
		}
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+nomeArquivo+".png").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
		tabuleiroVisual[linha][coluna].setIcon(imageIcon);
	}
	
	
	private void gerarInfos(int xTrans,int yTrans) {
		//GERA OS COMPONENTES NOS QUAIS OS ATRIBUTOS DAS CARTAS SERÃO MOSTRADOS
		
		//IMG

		picInfo.setLocation(1625,150);
		picInfo.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\CartaPadrao.png"));
		picInfo.setSize(200,200);
		this.add(picInfo);
		//NOME
		JLabel txtNome = new JLabel("Nome : ");
		txtNome.setLocation(1550,310);
		txtNome.setSize(250,200);
		txtNome.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtNome);
		

		txtStrNome.setLocation(1680,310);
		txtStrNome.setSize(200,200);
		txtStrNome.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtStrNome);
		
		//ATAQUE
		JLabel txtAtq = new JLabel("Ataque : ");
		txtAtq.setLocation(1550,350);
		txtAtq.setSize(250,200);
		txtAtq.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtAtq);
		

		txtintAtq.setLocation(1780,350);
		txtintAtq.setSize(200,200);
		txtintAtq.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintAtq);
		//VIDA
		JLabel txtVida = new JLabel("Vida : ");
		txtVida.setLocation(1550,390);
		txtVida.setSize(250,200);
		txtVida.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtVida);
		

		txtintVida.setLocation(1780,390);
		txtintVida.setSize(200,200);
		txtintVida.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintVida);
		//Limite
		JLabel txtRest = new JLabel("Limite : ");
		txtRest.setLocation(1550,430);
		txtRest.setSize(250,200);
		txtRest.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtRest);
		

		txtintRest.setLocation(1780,430);
		txtintRest.setSize(200,200);
		txtintRest.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintRest);
		//MOBILIDADE
		JLabel txtMob = new JLabel("Mobilidade : ");
		txtMob.setLocation(1550,470);
		txtMob.setSize(250,200);
		txtMob.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtMob);
		

		txtintMob.setLocation(1780,470);
		txtintMob.setSize(200,200);
		txtintMob.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintMob);
		
		//Descrição
		JLabel txtDesc = new JLabel("Descrição : ");
		txtDesc.setLocation(1550,510);
		txtDesc.setSize(250,200);
		txtDesc.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtDesc);
		

		txtStrDesc.setLocation(1550,650);
		txtStrDesc.setSize(300,200);
		txtStrDesc.setLineWrap(true);
		txtStrDesc.setEditable(false);
		txtStrDesc.setWrapStyleWord(true);
		txtStrDesc.setFont(new Font("MV Boli", Font.BOLD,20));
		txtStrDesc.setBackground(Color.decode("#BB7843"));
		this.add(txtStrDesc);
		
		
	}
	public JLabelCelula[][] getTabuleiroVisual() {
		return this.tabuleiroVisual;
	}		
	private void gerarFundo(int xTrans,int yTrans) {
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\bkgInGame.png"));
		bg.setSize(1920+xTrans,1080+yTrans);
		this.add(bg);
	}
	private void gerarScoreboard(int xTrans,int yTrans) {

		indicadorVezJogador1.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\EstrelaVez.png"));
		indicadorVezJogador1.setSize(64,64);
		indicadorVezJogador1.setLocation(xTrans+50,250+yTrans);
		this.add(indicadorVezJogador1);
		
		

		indicadorVezJogador2.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\EstrelaVez.png"));
		indicadorVezJogador2.setSize(64,64);
		indicadorVezJogador2.setLocation(xTrans+50,450+yTrans);
		indicadorVezJogador2.setVisible(false);
		this.add(indicadorVezJogador2);
		
		//TURNO

		txtTurno.setText("TURNO:");
		txtTurno.setSize(200,200);
		txtTurno.setFont(new Font("MV Boli", Font.BOLD,30));
		txtTurno.setLocation(xTrans,yTrans);
		this.add(txtTurno);
		

		txtintTurno.setText("0");
		txtintTurno.setSize(200,200);
		txtintTurno.setFont(new Font("MV Boli", Font.BOLD,30));
		txtintTurno.setLocation(xTrans+150,yTrans);
		this.add(txtintTurno);
		
		//JOGADOR 1

		txtVida0.setText("Jogador 1:");
		txtVida0.setSize(200,200);
		txtVida0.setFont(new Font("MV Boli", Font.BOLD,30));
		txtVida0.setLocation(xTrans,yTrans+250);
		this.add(txtVida0);
		

		txtintVida0.setText(controle.getJogador(0).getVida()+"");
		txtintVida0.setSize(200,200);
		txtintVida0.setFont(new Font("MV Boli", Font.BOLD,30));
		txtintVida0.setLocation(xTrans,yTrans+300);
		this.add(txtintVida0);
		//JOGADOR 2

		txtVida1.setText("Jogador 2:");
		txtVida1.setSize(200,200);
		txtVida1.setFont(new Font("MV Boli", Font.BOLD,30));
		txtVida1.setLocation(xTrans,yTrans+450);
		this.add(txtVida1);
		

		txtintVida1.setText(controle.getJogador(1).getVida()+"");
		txtintVida1.setSize(200,200);
		txtintVida1.setFont(new Font("MV Boli", Font.BOLD,30));
		txtintVida1.setLocation(xTrans,yTrans+500);
		this.add(txtintVida1);
		
	}

	
	


	
		
		
	
}
