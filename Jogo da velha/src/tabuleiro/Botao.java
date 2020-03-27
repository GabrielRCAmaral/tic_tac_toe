package tabuleiro;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import ia.Inteligencia;
import principal.Principal;

public class Botao extends JButton implements ActionListener{

	private ImageIcon x,o,i;
	private int valor=0;
	private boolean botaoUsado=false;
	private Inteligencia ia = Inteligencia.getIa();
	
	public Botao(){
		x=new ImageIcon(getClass().getResource("/recursos/X.png"));
		o=new ImageIcon(getClass().getResource("/recursos/O.png"));
		i= new ImageIcon(getClass().getResource("/recursos/Fundo.png"));
		setIcon(i);
		this.addActionListener(this);
			
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(!this.botaoUsado){
			
			this.botaoUsado=true;
			this.setFocusable(false);
		
			if(Tabuleiro.getInstance().getVez()==0){
				valor=1;
				setIcon(x);
				Tabuleiro.getInstance().setVez(1);
					
			}else{ 
				valor=2;
				setIcon(o);
				Tabuleiro.getInstance().setVez(0);	
				
			}
			playSound();
			Principal.jogoAcabou();
			Tabuleiro.getInstance().vezComputador();
			
		}
		
	}
	
	public int getValor(){
		
		return valor;
	}
	
	public void playSound(){
		try{
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/recursos/clique.wav"));
			Clip clip = AudioSystem.getClip( );
			clip.open(audioInputStream);
			clip.start( );
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
   }
   
   public void resetBotao(){
		valor=0;
		setIcon(i);
		this.botaoUsado=false;
		this.setFocusable(true);
	   
	   
   }
 	
}




