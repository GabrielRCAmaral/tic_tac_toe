package principal;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import telas.*;
import tabuleiro.*;
import ia.Inteligencia;
import jogadores.*;

public class Principal{
	
	private static Botao[] tabuleiro=Tabuleiro.getInstance().getTabuleiro();
	private static TelaJogo teladoJogo;
	private static TelaInicial telaInicial;
	private static Inteligencia ia =Inteligencia.getIa();
	private static TelaDificuldade telaDificuldade;
	
	public static void main(String args[]){
		telaInicial= new TelaInicial();
		telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaInicial.setSize(530,350);
		telaInicial.setVisible(true);
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setResizable(false);
		
		
	}
	
	public static void fecharTelaDificuldade(){
	
		telaDificuldade.dispose();
	
	}
	
	public static void selecionarDificuldade(){
		telaDificuldade= new TelaDificuldade();
		telaDificuldade.setSize(530,350);
		telaDificuldade.setVisible(true);
		telaDificuldade.setLocationRelativeTo(null);
		telaDificuldade.setResizable(false);
	
	}
	
	public static void iniciarJogo(){
		
		teladoJogo = new TelaJogo();
		teladoJogo.setSize(530,350);
		teladoJogo.setLocationRelativeTo(null);
		teladoJogo.setResizable(false);	
		teladoJogo.setVisible(true);
		Tabuleiro.getInstance().resetTabuleiro();
	
		
	}
	
	public static void fecharTelaInicial(){
		telaInicial.setVisible(false);
		
	}
	
	public static void fecharJogo(){
		teladoJogo.dispose();
		teladoJogo.resetScores();
		if(ia.getAtivo()) ia.setAtivo(false);
		
	}
	
	public static void abrirTelaInicial(){
		telaInicial.setVisible(true);
		
	}
	public static void jogoAcabou(){
		
		String ganhador="";
		boolean jogando=true;
		
		if(Tabuleiro.getInstance().testeVitoria(1)){
			jogando =false;
			ganhador=Tabuleiro.getInstance().getJogador1().getNome();
			teladoJogo.contVitoria(1);
			teladoJogo.atualizarPlacar();
				
				
		}else if(Tabuleiro.getInstance().testeVitoria(2)){
			jogando=false;
			ganhador=Tabuleiro.getInstance().getJogador2().getNome();
			teladoJogo.contVitoria(2);
			teladoJogo.atualizarPlacar();
				
		} else if(tabuleiro[0].getValor()!=0&&tabuleiro[1].getValor()!=0&&tabuleiro[2].getValor()!=0&&tabuleiro[3].getValor()!=0&&tabuleiro[4].getValor()!=0&&tabuleiro[5].getValor()!=0&&tabuleiro[6].getValor()!=0&&tabuleiro[7].getValor()!=0&&tabuleiro[8].getValor()!=0){
					jogando=false;
					ganhador="Deu velha!";
					teladoJogo.atualizarPlacar();
				
				}
				
		if(!jogando){
			String m = "<html>GANHADOR: "+ganhador+"<br><br>Quer jogar novamente?<br><br></html>";
			JLabel msg = new JLabel(m,JLabel.CENTER);
			int jogarNovamente=JOptionPane.showConfirmDialog(teladoJogo,msg,"Jogar Novamente",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			
			if (jogarNovamente==JOptionPane.NO_OPTION) {
				fecharJogo();
				abrirTelaInicial();
				
			}
			Tabuleiro.getInstance().resetTabuleiro();
		}	
	}
	
	
	
	
	
	
	

}