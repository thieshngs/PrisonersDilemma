package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_spiteful extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves;
	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		
		if(myHistory == "" && otherHistory == "") {
			return 'c';
		} else if(myHistory.contains("d")){
			return 'd';
		} else if(otherHistory.contains("d")) {
			return 'd';
		} else {
			return 'c';
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
