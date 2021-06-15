package mc322.lab07.vision;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelInterativa extends JLabel {
	private static final long serialVersionUID = -692369956380797782L;
	String nome;
	int tamanho;
	String nomeArquivo;
	public JLabelInterativa(String nome,int tamanho,String nomeArquivo) {
		
		super();
		this.nome = nome;
		this.tamanho = tamanho;
		this.nomeArquivo=nomeArquivo;
		
		this.setIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+nomeArquivo+".png"));
		setSize(tamanho,tamanho);
		
		
	}
	
	
}
