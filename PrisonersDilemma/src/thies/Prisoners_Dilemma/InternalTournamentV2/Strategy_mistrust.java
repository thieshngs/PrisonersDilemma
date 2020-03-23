package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_mistrust extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 1, moves;
	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		
		if(myHistory == "" && otherHistory == "") {
			return 'd';
		} else {
			return otherHistory.charAt(0);
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
