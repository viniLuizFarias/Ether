package mc322.lab07.vision;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mc322.lab07.model.Peca;
import mc322.lab07.controller.Controle;
import mc322.lab07.model.Deck;
import mc322.lab07.model.Jogador;

public class ScreenInGame extends JFrame implements IJanela{
	
		private int altura,largura;
		private int turno;
		private int jogador1,jogador2;//VIDAS
		
		//INFOS CARTA
		private String nome="@@";
		private int ataque,vida,restante;
		private Controle controle;
		
	public ScreenInGame(int altura, int largura,Controle controle){
		super();
		this.turno=0;
		setSize(altura,largura);
		this.setTitle("Ether");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(false);
		this.controle = controle;
		
		gerarTabuleiro(20, 10,256,180);
		gerarCartas(286, 0,0,controle.getJogador(0).getDeck());
		gerarCartas(286, 820,1,controle.getJogador(1).getDeck());
		gerarScoreboard(25,100);
		gerarInfos(0, 0);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	
	private void gerarCartas(int xTrans,int yTrans,int idJogador,Deck deck) {
		//GERA AS CARTAS DA MÃO DO JOGADOR
		int tamanhoCarta=192;
		for(int i=0;i<5;i++) {
			System.out.println(idJogador);
			String nomeArq = deck.getPecaLista(i).getNomeArquivo();
			System.out.println(nomeArq);
			JLabelCarta carta = new JLabelCarta("Carta", tamanhoCarta,idJogador,i,true,nomeArq,controle);
			carta.setLocation(xTrans+i*(tamanhoCarta+64),yTrans);
			this.add(carta);
		}
		
	}
	private void gerarTabuleiro(int l, int c,int xTrans,int yTrans) {
		//GERA O TABULEIRO
		int tamanhoCelula = 64;
		for(int i=0;i<l;i++) {
			for(int j=0;j<c;j++) {
				JLabelCelula celula = new JLabelCelula("Celula", i, j,tamanhoCelula,"grama",controle);
				celula.setLocation(xTrans+i*tamanhoCelula, yTrans+j*tamanhoCelula);
				this.add(celula);
			}
		}
		
	}
	private void gerarCartas(int xTrans,int yTrans) {
		//GERA AS CARTAS DA MÃO DO JOGADOR
		int tamanhoCarta=192;
		for(int i=0;i<5;i++) {
			JLabelCarta carta = new JLabelCarta("Carta", tamanhoCarta,0,i,true,"Carta",controle);
			carta.setLocation(xTrans+i*(tamanhoCarta+64),yTrans);
			this.add(carta);
		}
		
	}
	
	private void gerarInfos(int xTrans,int yTrans) {
		//IMG
		JLabelCarta picInfo = new JLabelCarta("Carta",192,1, 1, true, "Carta",controle);
		picInfo.setLocation(1625,150);
		this.add(picInfo);
		//NOME
		JLabel txtNome = new JLabel("Nome : ");
		txtNome.setLocation(1550,310);
		txtNome.setSize(200,200);
		txtNome.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtNome);
		
		JLabel txtintNome = new JLabel(this.nome);
		txtintNome.setLocation(1750,310);
		txtintNome.setSize(200,200);
		txtintNome.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintNome);
		
		//ATAQUE
		JLabel txtAtq = new JLabel("Ataque : ");
		txtAtq.setLocation(1550,350);
		txtAtq.setSize(200,200);
		txtAtq.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtAtq);
		
		JLabel txtintAtq = new JLabel(this.ataque+"");
		txtintAtq.setLocation(1750,350);
		txtintAtq.setSize(200,200);
		txtintAtq.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintAtq);
		//VIDA
		JLabel txtVida = new JLabel("Vida : ");
		txtVida.setLocation(1550,390);
		txtVida.setSize(200,200);
		txtVida.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtVida);
		
		JLabel txtintVida = new JLabel(this.vida+"");
		txtintVida.setLocation(1750,390);
		txtintVida.setSize(200,200);
		txtintVida.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintVida);
		//RESTANTE
		JLabel txtRest = new JLabel("Restante : ");
		txtRest.setLocation(1550,430);
		txtRest.setSize(200,200);
		txtRest.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtRest);
		
		JLabel txtintRest = new JLabel(this.restante+"");
		txtintRest.setLocation(1750,430);
		txtintRest.setSize(200,200);
		txtintRest.setFont(new Font("MV Boli", Font.BOLD,30));
		this.add(txtintRest);
		
		
		
	}
	private void gerarScoreboard(int xTrans,int yTrans) {
		
		
		//TURNO
		JLabel txtTurno = new JLabel();
		txtTurno.setText("TURNO:");
		txtTurno.setSize(200,200);
		txtTurno.setFont(new Font("MV Boli", Font.BOLD,30));
		txtTurno.setLocation(xTrans,yTrans);
		this.add(txtTurno);
		
		JLabel txtintTurno = new JLabel();
		txtintTurno.setText(this.turno + "");
		txtintTurno.setSize(200,200);
		txtintTurno.setFont(new Font("MV Boli", Font.BOLD,30));
		txtintTurno.setLocation(xTrans+150,yTrans);
		this.add(txtintTurno);
		
		//JOGADOR 1
		JLabel txtVida1 = new JLabel();
		txtVida1.setText("Jogador 1:");
		txtVida1.setSize(200,200);
		txtVida1.setFont(new Font("MV Boli", Font.BOLD,30));
		txtVida1.setLocation(xTrans,yTrans+250);
		this.add(txtVida1);
		
		JLabel txtintVida1 = new JLabel();
		txtintVida1.setText("###");
		txtintVida1.setSize(200,200);
		txtintVida1.setFont(new Font("MV Boli", Font.BOLD,30));
		txtintVida1.setLocation(xTrans,yTrans+300);
		this.add(txtintVida1);
		//JOGADOR 2
		JLabel txtVida2 = new JLabel();
		txtVida2.setText("Jogador 2:");
		txtVida2.setSize(200,200);
		txtVida2.setFont(new Font("MV Boli", Font.BOLD,30));
		txtVida2.setLocation(xTrans,yTrans+450);
		this.add(txtVida2);
		
		JLabel txtintVida2 = new JLabel();
		txtintVida2.setText("###");
		txtintVida2.setSize(200,200);
		txtintVida2.setFont(new Font("MV Boli", Font.BOLD,30));
		txtintVida2.setLocation(xTrans,yTrans+500);
		this.add(txtintVida2);
		
	}
	

	public void alterarSelecionada(Peca peca) {

		
	}
	
	
	//GETTERS E SETTERS
	public void setVidaJogador1(int vida) {
		this.jogador1=vida;
		
	}
	public int getVidaJogador1() {
		return this.jogador1;
	}
	
	public void setVidaJogador2(int vida) {
		this.jogador2=vida;
		
	}
	public int getVidaJogador2() {
		return this.jogador2;
	}
		
	public void setTurno(int turno) {
		this.turno=turno;
		
	}
	public int getTurno() {
		return this.turno;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setAtaque(int ataque) {
		this.turno=ataque;
		
	}
	public int getAtaque() {
		return this.ataque;
	}
	public void setRestante(int restante) {
		this.turno=restante;
		
	}
	public int getRestante() {
		return this.restante;
	}



	
		
		
	
}
