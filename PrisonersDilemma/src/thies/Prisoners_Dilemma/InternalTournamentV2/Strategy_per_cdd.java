package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_per_cdd extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 0, counter = 0, moves;

	char getMove(String myHistory, String otherHistory) {
		moves++;
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		counter++;
		if(counter == 1) {
			return 'c';
		} else if (counter == 2) {
			return 'd';
		} else if(counter == 3) {
			counter = 0;
			return 'd';
		}else {
			System.out.println(counter + " is an invalid number for the counter (per_cdd)");
			return 'c';
		}
	
	}
	
	public void reset() {
		moves = 0;
		counter = 0;
	}

}
