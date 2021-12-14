import java.util.*;
//import java.lang.*;
public class MAIN {

	public static void main(String[] args) {
		
		//initialize the objects of the classes
		PAR P1 = new PAR();
		PAR P2 = new PAR();
		
		HIHO H1 = new HIHO();
		HIHO H2 = new HIHO();
		
		Player Player1 = new Player();
		Player Player2 = new Player();
		
		//initialize needed variables
		String FirstName, SecondName, Winner, Server;
		int PARpoints1 = 0, PARpoints2 = 0; //variables to store the PAR score for player 1 and 2
		int HIHOpoints1 = 0, HIHOpoints2 = 0; //variables to store the HIHO score for player 1 and 2
		int game = 0; //variable to store number of games
		
		int GameNo = 0; //variable to store number of games inside the loop
		int RoundNo = 0; //variable acts as a counter to number of rounds
		
		int P1PARWonGames = 0, P2PARWonGames = 0; //Number of won games in PAR Mode for player 1 and 2
		int P1HIHOWonGames = 0, P2HIHOWonGames = 0; //Number of won games in HIHO Mode for player 1 and 2
		
		String FinalWinnerPAR, FinalWinnerHIHO; //Who won in PAR and HIHO Modes
		
		int WinnerNumberOfGamesPAR = 0, LoserNumberOfGamesPAR = 0; //Store winner and loser in PAR mode
		int WinnerNumberOfGamesHIHO = 0, LoserNumberOfGamesHIHO = 0; //Store winner and loser in HIHO mode
		
		Server = Player1.Getname(); //Default server is player 1
		
		int NoOfroundsPAR = 11; //Variable to store number of rounds in PAR mode

		//initialize a scanner to take inputs
		Scanner S = new Scanner(System.in);
		
		// Firstly, take the players names
		
		System.out.println("Please enter the first player name.");
		FirstName = S.nextLine();
		
		System.out.println("Please enter the second player name.");
		SecondName = S.nextLine();
		
		//set the names of the players
		Player1.setname(FirstName);
		Player2.setname(SecondName);
		
		//check which mode the user will use
		String Mode;
		System.out.println("What mode are you playing in? (Manual or Random)");
		Mode = S.nextLine();
		
			if(Mode.equals("Random")) { //to print the header once
				System.out.printf("%s\t%s\t%s\t%s\n", "Game #","Round #",Player1.Getname(), Player2.Getname()); //print the header
			}
		//Begin of while loop
		while(Player1.GetNumberOfWonPARGames() < 3 && Player2.GetNumberOfWonPARGames() <3) {
			RoundNo = 0; //restart the counter of number of rounds
			GameNo++; //increment number of games
			//Begin of Second while loop
			while((Player1.GetPARPoints() <NoOfroundsPAR && Player2.GetPARPoints() < NoOfroundsPAR) || (Player1.GetHIHOPoints() <9 && Player2.GetHIHOPoints()<9)) {
				RoundNo++; //increment number of rounds
				//if the user chose Manual mode, it will prompt to ask each time who won the round
				if (Mode.equals("Manual")) {
				System.out.println("Who won this round");
				Winner = S.nextLine();
				}
				else { //anything else will enter the random mode
					if (RandomInt(1,2) == 1) { //insert player1 name as a winner
						Winner = Player1.Getname();
					}else { //insert player2 name as a winner
						Winner = Player2.Getname();
					}
				}
				//if player1 is the winner increment number of points
				//in PAR mode it should not exceed number of rounds when the game ends
				//in HIHO mode only when the winner is the serving player the point is counted
				if(Winner.equals(Player1.Getname())) {
					if(PARpoints1 < NoOfroundsPAR) {
					PARpoints1=PARpoints1+1;}
					
					if (Server.equals(Player1.Getname()) && HIHOpoints1 < 9) {
						HIHOpoints1 = HIHOpoints1 + 1;
						Player1.setHIHOPoints(HIHOpoints1);
					}else {
						Server = Player1.Getname();
					}
					
					Player1.setPARPoints(PARpoints1);
					
					//set W for the winner and L for the loser
					Player1.setStatus('W');
					Player2.setStatus('L');
					
				}else {
					if(PARpoints2 < NoOfroundsPAR) {
					PARpoints2=PARpoints2+1;}
					
					if (Server.equals(Player2.Getname()) && HIHOpoints2 < 9) {
						HIHOpoints2 = HIHOpoints2+ 1;
						Player2.setHIHOPoints(HIHOpoints2);
					}else {
						Server = Player2.Getname();
					}
					
					
					Player2.setPARPoints(PARpoints2);
					
					Player2.setStatus('W');
					Player1.setStatus('L');
					
				}
				
				//if there is a tie at 10 or more the number pf PAR rounds should increase by 2
				if(((PARpoints1 - PARpoints2) == 0) && (PARpoints1 >= 10)) {
					NoOfroundsPAR = PARpoints1 + 2;
				}
				
				//Set number of rounds for both players on both modes
				P1.setNumberOfRounds(RoundNo);
				P2.setNumberOfRounds(RoundNo);
				H1.setNumberOfRounds(RoundNo);
				H2.setNumberOfRounds(RoundNo);
				
				if(Mode.equals("Manual")){
					System.out.printf("%s\t%s\t%s\t%s\n", "Game #","Round #",Player1.Getname(), Player2.Getname());} //print the header everytime we are printing the result in the manual mode
				System.out.printf("%d\t%d\t%s\t%s\n", GameNo,RoundNo,Player1.GetStatus(), Player2.GetStatus()); //print the values
			
			
			} //end of second while loop
			
			//increment number of won games
			if(Player1.GetPARPoints() == NoOfroundsPAR) {
				P1PARWonGames = P1PARWonGames + 1;
			}else if(Player2.GetPARPoints() == NoOfroundsPAR) {
				P2PARWonGames = P2PARWonGames + 1;
			}
			
			if(Player1.GetHIHOPoints() == 9) {
				P1HIHOWonGames = P1HIHOWonGames + 1;
			}else if(Player2.GetHIHOPoints() == 9) {
				P2HIHOWonGames = P2HIHOWonGames + 1;
			}
			
			//resetting the number of points
			PARpoints1 = 0;
			PARpoints2 = 0;
			
			HIHOpoints1 = 0;
			HIHOpoints2 = 0;
			
			Player1.setPARPoints(PARpoints1);
			Player2.setPARPoints(PARpoints2);
			
			Player1.setHIHOPoints(HIHOpoints1);
			Player2.setHIHOPoints(HIHOpoints2);

			//incrementing the number of games for both players in both modes
			game = game + 1;
			P1.setNumberOfGames(game);
			P2.setNumberOfGames(game);
			H1.setNumberOfGames(game);
			H2.setNumberOfGames(game);
			
			//incrementing the number of games won by both players in both modes
			Player1.setNumberOfWonPARGames(P1PARWonGames);
			Player2.setNumberOfWonPARGames(P2PARWonGames);
			
			Player1.setNumberOfWonHIHOGames(P1HIHOWonGames);
			Player2.setNumberOfWonHIHOGames(P2HIHOWonGames);
			
			} //endwhile
		
		//check who is the winner and the loser at the end of all the games in both modes then print
		if(Player1.GetNumberOfWonPARGames() > Player2.GetNumberOfWonPARGames()) {
			FinalWinnerPAR = Player1.Getname();
			WinnerNumberOfGamesPAR = Player1.GetNumberOfWonPARGames();
			LoserNumberOfGamesPAR = Player2.GetNumberOfWonPARGames();
			
		}else {
			FinalWinnerPAR = Player2.Getname();
			WinnerNumberOfGamesPAR = Player2.GetNumberOfWonPARGames();
			LoserNumberOfGamesPAR = Player1.GetNumberOfWonPARGames();
		}
		System.out.printf("%s%s%s%d%s%d%s\n","According to PAR Judge, ", FinalWinnerPAR , " won the match with X-Y games (",WinnerNumberOfGamesPAR, " - ", LoserNumberOfGamesPAR, ")");
		
		
		if(Player1.GetNumberOfWonHIHOGames() > Player2.GetNumberOfWonHIHOGames()) {
			FinalWinnerHIHO = Player1.Getname();
			WinnerNumberOfGamesHIHO = Player1.GetNumberOfWonHIHOGames();
			LoserNumberOfGamesHIHO = Player2.GetNumberOfWonHIHOGames();
			
		}else {
			FinalWinnerHIHO = Player2.Getname();
			WinnerNumberOfGamesHIHO = Player2.GetNumberOfWonHIHOGames();
			LoserNumberOfGamesHIHO = Player1.GetNumberOfWonHIHOGames();
		}

		System.out.printf("%s%s%s%d%s%d%s\n","According to HIHO Judge, ", FinalWinnerHIHO , " won the match with X-Y games (",WinnerNumberOfGamesHIHO, " - ", LoserNumberOfGamesHIHO, ")");
		
		S.close(); //close Scanner
		
		
		} //end MAIN function
	
	
	
	//Function that returns random variable 1 or 2
	public static int RandomInt (int min, int max) {
		Random rand = new Random ();
		int randomNum = rand.nextInt((max-min)+1)+min;
		
		return randomNum;
	}

}
