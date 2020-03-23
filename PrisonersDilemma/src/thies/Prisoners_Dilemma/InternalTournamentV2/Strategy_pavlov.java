package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_pavlov extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves;
	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		
		if(myHistory == "" && otherHistory == "") {
			return 'c';
		} else {
			if(myHistory.equals(otherHistory)) {
				return 'c';
			} else {
				return 'd';
			}
		}

	}
	
	public void reset() {
		moves = 0;
	}
}
