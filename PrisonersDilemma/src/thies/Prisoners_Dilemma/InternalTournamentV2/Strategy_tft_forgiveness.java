package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_tft_forgiveness extends Strategy{
	
	int myMovesMemory = 0, otherMovesMemory = 1, moves;
	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		
		if(myHistory == "" && otherHistory == "") {
			return 'c';
		} else {
			if(otherHistory.charAt(0) == 'c') {
				return 'c';
			} else if(Utility.randomPercent() < 3) {
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
