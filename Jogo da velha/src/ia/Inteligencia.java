package ia;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import tabuleiro.*;


public class Inteligencia{


	private class Jogada{
		
		private int score;
		private int posicao;
		
		public Jogada(int score,int posicao){
			this.score=score;
			this.posicao=posicao;
			
		}
			
		
	}
	
	private  Botao[] tabuleiro=Tabuleiro.getInstance().getTabuleiro();
	private  int dificuldade;
	private static Inteligencia ia;
	private boolean ativo=false;
	private List<Integer> tabModificado;
	private List<Jogada> jogadasPossiveis;
	private Inteligencia(){}
	
	public static Inteligencia getIa(){
		
		if(ia==null) ia=new Inteligencia();
		
		return ia;
		
	}
	
	public List<Integer> toArrayTabuleiro(){
		
		 List<Integer> list = new ArrayList<>();
		 
        for (int i=0;i<9;i++) {
            list.add(tabuleiro[i].getValor());
        }
        return list;
		
	}
	
	  public void callMinimax(int profundida, int vez){
		  
        jogadasPossiveis = new ArrayList<>();
        miniMax(profundida, vez);
    }
    
	public String getNome(){
		
		return "Computador";
		
	}
	
	 private  int miniMax(int profundida,int vez) {
		
		if(dificuldade!=10){
			if (profundida == dificuldade) 
				return 0;
		}
		if(jogador1Ganhou())
			return -1;
		if(jogador2Ganhou())
			
			return 1;
		if(getPosicaoVaga().size()==0)
			return 0;
				
		int proxMov;
		List<Integer> scores = new ArrayList<>();
		List<Integer> movimentosVago =getPosicaoVaga();
		
         for (int i = 0; i < movimentosVago.size(); ++i) {
             proxMov= movimentosVago.get(i);  
			
            if (vez == 0) { 
                tabModificado.set(proxMov,2); 
                int scoreAtual = miniMax(profundida+ 1, 1);
                scores.add(scoreAtual);
				
				if (profundida == 0) 
                    jogadasPossiveis.add(new Jogada(scoreAtual, proxMov));
                
            } else if (vez == 1) {
                tabModificado.set(proxMov,1); 
                scores.add(miniMax(profundida + 1, 0));
            }
			
			tabModificado.set(proxMov,0);
            
        }
        return vez == 0 ? max(scores) : min(scores);

    }
	 public int melhorMovimento() {
        int MAX = -100000;
        int best = -1;

        for (int i = 0; i < jogadasPossiveis.size(); ++i) { 
            if (MAX < jogadasPossiveis.get(i).score) {
                MAX = jogadasPossiveis.get(i).score;
                best = i;
            }
        }

        return jogadasPossiveis.get(best).posicao;
    }
	 public int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
	
	 public int min(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
	

	public void setDificuldade(int dificuldade){
			
			this.dificuldade=dificuldade;
		
	}
	
	
	public boolean getAtivo(){
		
		return ativo;
	}
	
	public void setAtivo(boolean ativo){
		
			this.ativo=ativo;
		
	} 
	
	public void jogada(){
		
		tabModificado = toArrayTabuleiro();
		if(getPosicaoVaga().size()!=0||!jogador1Ganhou()||!jogador2Ganhou()){
			
			if(dificuldade==2){
				Random rand = new Random();
				int i = rand.nextInt(getPosicaoVaga().size());
				tabuleiro[getPosicaoVaga().get(i)].doClick();
			}
			if(dificuldade!=2){
				
				callMinimax(0,0);
				tabuleiro[melhorMovimento()].doClick();
			}
		}
		
	}
	
	public List<Integer> getPosicaoVaga(){
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<9;i++){
			
			if(tabModificado.get(i)==0) list.add(i);  
			
		}
		return list;
	}
	
	public  boolean jogador1Ganhou(){
	
		if ((tabModificado.get(2) == 1)&&(tabModificado.get(4) == 1)&&(tabModificado.get(6) == 1)||(tabModificado.get(0) == 1)&&(tabModificado.get(4) == 1)&&(tabModificado.get(8) == 1)||(tabModificado.get(2) == 1)&&(tabModificado.get(1) == 1)&&(tabModificado.get(0) == 1)||(tabModificado.get(3) == 1)&&(tabModificado.get(4) == 1)&&(tabModificado.get(5) == 1)||(tabModificado.get(6) == 1)&&(tabModificado.get(7) == 1)&&(tabModificado.get(8) == 1)||(tabModificado.get(0) == 1)&&(tabModificado.get(3) == 1)&&(tabModificado.get(6) == 1)||(tabModificado.get(1) == 1)&&(tabModificado.get(4) == 1)&&(tabModificado.get(7) == 1)||(tabModificado.get(2) == 1)&&(tabModificado.get(5) == 1)&&(tabModificado.get(8) == 1))
			return true;
		else 
			return false;
	}		
			
	public boolean jogador2Ganhou(){
		
		 if ((tabModificado.get(2) == 2)&&(tabModificado.get(4) == 2)&&(tabModificado.get(6) == 2)||(tabModificado.get(0) == 2)&&(tabModificado.get(4) == 2)&&(tabModificado.get(8) == 2)||(tabModificado.get(2) == 2)&&(tabModificado.get(1) == 2)&&(tabModificado.get(0) == 2)||(tabModificado.get(3) == 2)&&(tabModificado.get(4) == 2)&&(tabModificado.get(5) == 2)||(tabModificado.get(6) == 2)&&(tabModificado.get(7) == 2)&&(tabModificado.get(8) == 2)||(tabModificado.get(0) == 2)&&(tabModificado.get(3) == 2)&&(tabModificado.get(6) == 2)||(tabModificado.get(1) == 2)&&(tabModificado.get(4) == 2)&&(tabModificado.get(7) == 2)||(tabModificado.get(2) == 2)&&(tabModificado.get(5) == 2)&&(tabModificado.get(8) == 2))
			return true;
		else 
			return false;
	}
	
}

	





