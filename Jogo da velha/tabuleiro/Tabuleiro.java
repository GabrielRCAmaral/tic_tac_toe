package tabuleiro;

import javax.swing.JLabel;
import principal.Principal;
import telas.TelaJogo;
import jogadores.*;
import javax.swing.JOptionPane;
import ia.Inteligencia;

public class Tabuleiro{

	private  Botao[] tabuleiro=new Botao[9];
	private static Tabuleiro instance;
	private int vez=0;
	private boolean jogando=false;
	private IJogador jogador1;
	private IJogador jogador2;
	
	
	private Tabuleiro(){}
	
	public IJogador getJogador1(){
		
		return jogador1;
	}
	
	public IJogador getJogador2(){
		
		return jogador2;
	}
	
	public static Tabuleiro getInstance(){
		
		if(instance==null){
			
			instance=new Tabuleiro();
			
		}
		return instance;
		
	}
	
	public void vezComputador(){
		
		if(vez==1&&Inteligencia.getIa().getAtivo())
				Inteligencia.getIa().jogada();	
		
	}
		
	public  void setJogadores(int num){
		
		if(num==2){
			jogador1= new JogadorPessoa(JOptionPane.showInputDialog("Entre o nome do primeiro jogador: "));
			jogador2= new JogadorPessoa(JOptionPane.showInputDialog("Entre o nome do segundo jogador: "));
			Inteligencia.getIa().setAtivo(false);
			Principal.iniciarJogo();
		}else{
		
				jogador1= new JogadorPessoa(JOptionPane.showInputDialog("Entre o nome do jogador: "));
				jogador2= new JogadorComputador();
			
			Principal.selecionarDificuldade();	
		}
		
		
	}
	public void setVez(int vez){
		
		this.vez=vez;
		
	}
	
	
	public int getVez(){
		
		return vez;
	}
	
	public Botao[] getTabuleiro(){
		
		return tabuleiro;
		
	}
	
	public  boolean testeVitoria(int jogador){
	
		return ((tabuleiro[2].getValor() == jogador)&&(tabuleiro[4].getValor() == jogador)&&(tabuleiro[6].getValor() == jogador)||(tabuleiro[0].getValor() == jogador)&&(tabuleiro[4].getValor() == jogador)&&(tabuleiro[8].getValor() == jogador)||(tabuleiro[2].getValor() == jogador)&&(tabuleiro[1].getValor() == jogador)&&(tabuleiro[0].getValor() == jogador)||(tabuleiro[3].getValor() == jogador)&&(tabuleiro[4].getValor() == jogador)&&(tabuleiro[5].getValor() == jogador)||(tabuleiro[6].getValor() == jogador)&&(tabuleiro[7].getValor() == jogador)&&(tabuleiro[8].getValor() == jogador)||(tabuleiro[0].getValor() == jogador)&&(tabuleiro[3].getValor() == jogador)&&(tabuleiro[6].getValor() == jogador)||(tabuleiro[1].getValor() == jogador)&&(tabuleiro[4].getValor() == jogador)&&(tabuleiro[7].getValor() == jogador)||(tabuleiro[2].getValor() == jogador)&&(tabuleiro[5].getValor() == jogador)&&(tabuleiro[8].getValor() == jogador));	
	}
	
	
	public void resetTabuleiro(){
		
		for(int i=0;i<9;i++){
			
			tabuleiro[i].resetBotao();
			
		}
		vez=0;
		if(Inteligencia.getIa().getAtivo())
			vezComputador();
		
	}

}