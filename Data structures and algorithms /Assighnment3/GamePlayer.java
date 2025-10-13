public class GamePlayer{//Start of GamePlayer Class
	private String Name;
	private String Password;
	private int Rounds;
	private int Successes;
	private int MinDists;
	private int Attempts;
	public void GamePlayerC(String Na, String Pass, int ro, int s, int MD, int At){
		String Name = Na;
		String Password = Pass;
		int Rounds = ro;
		int Successes = s;
		int MinDists = MD;
		int Attempts = At;
		
	}
	public GamePlayer (String Na ){
		Name = Na;
		
	}
	public String getName(){
	return Name;	
	}
	public int getRound(){
	return Rounds;	
	}
	public int getSuccess(){
	return Successes;	
	}
	public int getMinDist(){
	return MinDists;	
	}
	public int getAttempt(){
		return Attempts;
	}
	public double getRatio(){
		double ratio = (Successes/Attempts);
		return ratio;
	}
	public String getPass(){
		return Password;
	}
	
	public void setPass(String P){
		Password = P;
	}
	public void setRound(int R){
		Rounds = R;
	}
	
	public void setSucc(int S){
		Successes = S;
	}
	
	public void setMinDist(int MD){
		MinDists = MD;
	}
	
	public void setAttem(int A){
		Attempts = A;
	}
	
	public void failure(){
	Attempts++;
	}
	public void success(int y, int x){//this code doesnt do 
		
	}
	public void Success1(){
		Successes++;
	}
	
	
	
	
}//end of GamePlayer class

//Ryan Farrar 