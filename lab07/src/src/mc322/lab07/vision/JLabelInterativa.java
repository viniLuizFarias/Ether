package mc322.lab07.vision;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		
		
		//Verifica se há o nome da peça
		if(nomeArquivo == null) {
			  JOptionPane.showMessageDialog(null, "O caminho para o arquivo da peça "+nome+" não foi definido" ,
				       "Error",JOptionPane.ERROR_MESSAGE);
				  System.exit(1);	
		}
		
		
		File f = new File(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+nomeArquivo+".png");
		
		//Verifica se o arquivo da imagem existe
		if(!(f.exists() && !f.isDirectory())) { 
			  JOptionPane.showMessageDialog(null, "Erro: não foi possível encontrar "+ nomeArquivo+".png" ,
				       "Error",JOptionPane.ERROR_MESSAGE);
				  System.exit(1);
		}
		

		ImageIcon imageIcon = new ImageIcon(new ImageIcon(JLabelInterativa.class.getResource(".").getPath()+"\\prefabs\\"+nomeArquivo+".png").getImage().getScaledInstance(tamanho, tamanho, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		
		setSize(tamanho,tamanho);
		

	}
	@Override
	public abstract void tornarInterativa();



	
	
}
