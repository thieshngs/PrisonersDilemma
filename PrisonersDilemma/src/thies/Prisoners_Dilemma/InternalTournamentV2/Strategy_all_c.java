package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_all_c extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 0, moves;

	char getMove(String myHistory, String otherHistory) {
		moves++;
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		return 'c';
	}
	
	public void reset() {
		moves = 0;
	}

}