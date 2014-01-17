
public class Player {
	private String name;
	private int playerPosn;
	private int playerScore;
	//private Color playerColor;
	
	public Player(){
	    name = "Unknown";
	    playerPosn = 0;
	}
	
	public int returnPosition(){
		return playerPosn;
	}
	
	public void setPosition(int posn){
		playerPosn = posn;
	}
	
	public void incPosition(int posn){
		playerPosn += posn;
	}
	

}
