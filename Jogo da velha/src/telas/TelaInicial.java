package telas;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import principal.Principal;
import tabuleiro.*;

public class TelaInicial extends JFrame{

	private JButton umJogador;
	private JButton doisJogadores;
	private JLabel menu;
	private JLabel p;
	
	public TelaInicial(){
		
		super("Menu");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icon.png")));
		setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		umJogador=new JButton("Jogar sozinho");
		doisJogadores=new JButton("Jogar com amigo");
		menu =new JLabel("Menu");
		menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setFont(new Font("Dialog", Font.BOLD, 23));
		menu.setForeground(new Color(0,150,0));
		umJogador.setAlignmentX(Component.CENTER_ALIGNMENT);
		umJogador.setFont(new Font("Dialog", Font.BOLD, 23));
		umJogador.setFocusable(false);
		doisJogadores.setAlignmentX(Component.CENTER_ALIGNMENT);
		doisJogadores.setFont(new Font("Dialog", Font.BOLD, 23));
		doisJogadores.setFocusable(false);
		umJogador.setMaximumSize(new Dimension(300,50));
		doisJogadores.setMaximumSize(new Dimension(300,50));
		add(menu);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(umJogador);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(doisJogadores);
		getContentPane().setBackground(new Color(50,100,50));
		ButtonHandler handler = new ButtonHandler();
		umJogador.addActionListener(handler);
		doisJogadores.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			Principal.fecharTelaInicial();
			if(e.getSource()==umJogador){
				
				Tabuleiro.getInstance().setJogadores(1);
				
				
			} 	
			else
				Tabuleiro.getInstance().setJogadores(2);
			
			
			
		}
		
	}

}