package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_random extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 0;
	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		
		if(Utility.randomPercent() > 50) {
			return 'c';
		} else {
			return 'd';
		}
	}
	
	public void reset() {
	}
}
