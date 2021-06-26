package mc322.lab07.vision;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mc322.lab07.controller.Controle;

public abstract class JLabelInterativa extends JLabel implements IJlabelInterativa{
	private static final long serialVersionUID = -692369956380797782L;
	String nome;
	int tamanho;
	String nomeArquivo;
	public JLabelInterativa(String nome,int tamanho,String nomeArquivo) {
		
		super();
		this.nome = nome;
		this.tamanho = tamanho;
		this.nomeArquivo=nomeArquivo;

		ImageIcon imageIcon = new ImageIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+nomeArquivo+".png").getImage().getScaledInstance(tamanho, tamanho, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		
		
		//this.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+nomeArquivo+".png"));

		setSize(tamanho,tamanho);
		
	}
	@Override
	public abstract void tornarInterativa();



	
	
}
