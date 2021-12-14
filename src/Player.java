
public class Player {
	private String name;
	private char Status; //W or L
	private String Server;
	private int PARScore;
	private int HIHOScore;
	private int NumberOfWonPARGames;
	private int NumberOfWonHIHOGames;
	
	//constructor
	Player(){
		name = " ";
		Status = 'a';
		PARScore = 0;
		HIHOScore = 0;
		NumberOfWonPARGames = 0;
		NumberOfWonHIHOGames = 0;
		Server = " ";
	}
	//setters and getters for private attributes
	public void setname(String Setname) {
		name = Setname;
	}
	
	public String Getname () {
		return name;
	}
	
	public void setStatus(char setStatus) {
		Status = setStatus;
	}
	
	public char GetStatus () {
		return Status;
	}
	
	public void setPARPoints(int SetPoints) {
		PARScore = SetPoints;
	}
	
	public int GetPARPoints () {
		return PARScore;
	}
	
	public void setHIHOPoints(int SetPoints) {
		HIHOScore = SetPoints;
	}
	
	public int GetHIHOPoints () {
		return HIHOScore;
	}
	
	public void setNumberOfWonPARGames(int SetNumber) {
		NumberOfWonPARGames = SetNumber;
	}
	
	public int GetNumberOfWonPARGames () {
		return NumberOfWonPARGames;
	}
	
	public void setNumberOfWonHIHOGames(int SetNumber) {
		NumberOfWonHIHOGames = SetNumber;
	}
	
	public int GetNumberOfWonHIHOGames () {
		return NumberOfWonHIHOGames;
	}
	
	public void setServer (String SetServe) {
		Server = SetServe;
	}
	
	public String GetServer() {
		return Server;
	}

}
