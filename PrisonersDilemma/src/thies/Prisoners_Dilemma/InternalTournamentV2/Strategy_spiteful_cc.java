package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_spiteful_cc extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves = 0;
	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		moves++;
		if(moves < 3) {
			return 'c';
		}else if(myHistory == "d"){
			return 'd';
		} else if(otherHistory == "d") {
			return 'd';
		} else {
			return 'c';
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
