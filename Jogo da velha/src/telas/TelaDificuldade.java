package telas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import ia.Inteligencia;
import principal.Principal;

public class TelaDificuldade extends JFrame{

	private JButton facil= new JButton("Facil");
	private JButton medio= new JButton("Medio");
	private JButton dificil= new JButton("Impossivel");
	private JLabel dificuldade=new JLabel("Selecione a dificuldade: ");
	private Inteligencia ia=Inteligencia.getIa();
	
	public TelaDificuldade(){		
		super("Dificuldade");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icon.png")));
		setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		dificuldade.setAlignmentX(Component.CENTER_ALIGNMENT);
		dificuldade.setHorizontalAlignment(SwingConstants.CENTER);
		dificuldade.setFont(new Font("Dialog", Font.BOLD, 23));
		dificuldade.setForeground(new Color(0,150,0));
		facil.setAlignmentX(Component.CENTER_ALIGNMENT);
		facil.setFont(new Font("Dialog", Font.BOLD, 23));
		facil.setFocusable(false);
		medio.setAlignmentX(Component.CENTER_ALIGNMENT);
		medio.setFont(new Font("Dialog", Font.BOLD, 23));
		medio.setFocusable(false);
		dificil.setAlignmentX(Component.CENTER_ALIGNMENT);
		dificil.setFont(new Font("Dialog", Font.BOLD, 23));
		dificil.setFocusable(false);
		facil.setMaximumSize(new Dimension(300,50));
		medio.setMaximumSize(new Dimension(300,50));
		dificil.setMaximumSize(new Dimension(300,50));
		add(dificuldade);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(facil);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(medio);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(dificil);
		getContentPane().setBackground(new Color(50,100,50));
		ButtonHandler handler = new ButtonHandler();
		facil.addActionListener(handler);
		medio.addActionListener(handler);
		dificil.addActionListener(handler);
		
	}
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==facil)
				ia.setDificuldade(2);
			else if (e.getSource()==medio)
				ia.setDificuldade(3);
				else 
					ia.setDificuldade(10);
			
			ia.setAtivo(true);	
			Principal.fecharTelaDificuldade();
			Principal.fecharTelaInicial();
			Principal.iniciarJogo();
			
		}
		
	}
	private class Handler implements WindowListener{
		
		@Override
		public void windowClosing(WindowEvent e) {
			Principal.fecharTelaDificuldade();
			Principal.abrirTelaInicial();
        }
		public void windowOpened(WindowEvent arg0) {}
		public void windowClosed(WindowEvent arg0) {}
		public void windowIconified(WindowEvent arg0) {}
		public void windowDeiconified(WindowEvent arg0) {}
		public void windowActivated(WindowEvent arg0) {}
		public void windowDeactivated(WindowEvent arg0) {}
		
	}



}