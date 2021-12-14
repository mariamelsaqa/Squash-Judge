
public class HIHO {
	private int NumberOfGames;
	private int NumberOfRounds;
	
	//constructor
	HIHO(){
		NumberOfGames = 0;
		NumberOfRounds = 0;
	}

	//setters and getters for private attributes
	public void setNumberOfGames (int SetNumberOfGames) {
		NumberOfGames = SetNumberOfGames;
	}
	
	public int GetNumberOfGames() {
		return NumberOfGames;
	}
	
	public void setNumberOfRounds (int SetNumberOfRounds) {
		NumberOfRounds = SetNumberOfRounds;
	}
	
	public int GetNumberOfRounds() {
		return NumberOfRounds;
	}
}
