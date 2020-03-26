package jogadores;

public class JogadorComputador implements IJogador{

	
	private String nome;
	private int score;
	
	public JogadorComputador(){
		
		this.nome ="Computador";
		
	}
	
	@Override 
	public String getNome(){
		
		return nome;
		
	}
	@Override
	public void setScore(int score){
		
		this.score=score;
	}
	@Override
	public int getScore(){
		
		return score;
	}
	
	
}