package jogadores;

public class JogadorPessoa implements IJogador{
	
	private String nome;
	private int score;

	public JogadorPessoa(String nome){
		
		this.nome =nome;
		
		
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