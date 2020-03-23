package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_tft_hard extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 2, moves= 0;

	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		moves++;
		
		if(moves < 3) {
			return 'c';
		} else if(otherHistory.equals("cc")) {
			return 'c';
		} else if(otherHistory.equals("cd")) {
			return 'd';
		} else if(otherHistory.equals("dc")) {
			return 'd';
		} else if(otherHistory.equals("dd")) {
			return 'd';
		} else {
			System.out.println(otherHistory + " contains elements that can't be read (tft_hard)");
			return'd';
		}
		
		
	}
	
	public void reset() {
		moves = 0;
	}
}
