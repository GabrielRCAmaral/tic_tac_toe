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
import java.awt.GridLayout;
import java.awt.Toolkit;
import tabuleiro.*;
import ia.Inteligencia;
import principal.Principal;
import jogadores.*;

public class TelaJogo extends JFrame{

	private Botao[] tabuleiro= Tabuleiro.getInstance().getTabuleiro();
	private JLabel p=new JLabel();
	private JLabel p2=new JLabel();
	private JLabel titulo;
	private JLabel placar;
	private Inteligencia ia = Inteligencia.getIa();
	private IJogador jogador1;
	private IJogador jogador2;
	
	public TelaJogo(){
		super("tabuleiro");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/icon.png")));
	
		addWindowListener(new Handler());
		setLayout(new BorderLayout(10,10));
		JLabel fundo=new JLabel(new ImageIcon(getClass().getResource("../recursos/granito.jpg")));
		add(fundo);
		fundo.setLayout(new BorderLayout(10,10));
		p.setLayout(new GridLayout(3,3,10,10));
		p.setIcon(new ImageIcon(getClass().getResource("../recursos/granito.jpg")));
		titulo = new JLabel("TABULEIRO");
		
		placar= new JLabel("<html>Placar: "+"<br>"+Tabuleiro.getInstance().getJogador1().getNome()+": " +Tabuleiro.getInstance().getJogador1().getScore()+"<br>"+Tabuleiro.getInstance().getJogador2().getNome()+": "+Tabuleiro.getInstance().getJogador2().getScore()+"</html");
		
		for(int i=0;i<9;i++){
			tabuleiro[i]= new Botao();
			p.add(tabuleiro[i]);
		}
			
		p2.setLayout(new BorderLayout());
		p2.setPreferredSize(new Dimension(200,200));
		p2.setIcon(new ImageIcon(getClass().getResource("../recursos/FundoPlacar.jpg")));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		placar.setHorizontalAlignment(SwingConstants.CENTER);
		placar.setFont(new Font("Dialog", Font.BOLD, 24));
		placar.setForeground(new Color(255,255,255));
		titulo.setFont(new Font("Dialog", Font.BOLD, 18));
		titulo.setForeground(Color.white);
		p2.add(placar, BorderLayout.CENTER);
		fundo.add(titulo, BorderLayout.NORTH);
		fundo.add(p,BorderLayout.CENTER);
		fundo.add(p2, BorderLayout.EAST);

	}
	public void atualizarPlacar(){
		
		placar.setText("<html>Placar: "+"<br>"+Tabuleiro.getInstance().getJogador1().getNome()+": " +Tabuleiro.getInstance().getJogador1().getScore()+"<br>"+Tabuleiro.getInstance().getJogador2().getNome()+": "+Tabuleiro.getInstance().getJogador2().getScore()+"</html");
		
	}

	public void contVitoria(int indice){
		
		if(indice==1)
			Tabuleiro.getInstance().getJogador1().setScore(Tabuleiro.getInstance().getJogador1().getScore()+1);
		else 
			Tabuleiro.getInstance().getJogador2().setScore(Tabuleiro.getInstance().getJogador2().getScore()+1);
		
	}
	
	public void resetScores(){
		
		Tabuleiro.getInstance().getJogador1().setScore(0);
		Tabuleiro.getInstance().getJogador2().setScore(0);
		
	}
		
	private class Handler implements WindowListener{
		
		@Override
		public void windowClosing(WindowEvent e) {
			
			ia.setAtivo(false);
            Principal.fecharJogo();
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