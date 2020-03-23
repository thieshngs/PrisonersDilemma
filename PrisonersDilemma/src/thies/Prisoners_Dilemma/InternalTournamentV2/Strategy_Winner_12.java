package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_Winner_12 extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 2, moves= 0;


	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		moves++;
		
		if(moves < 3) {
			return 'c';
		} else {
			String mergedMoves = myHistory + otherHistory;
			switch (mergedMoves) {
			case "ccc":
				return 'c';
			case "ccd":
				return 'd';
			case "cdc":
				return 'c';
			case "cdd":
				return 'd';
			case "dcc":
				return 'd';
			case "dcd":
				return 'c';
			case "ddc":
				return 'd';
			case "ddd":
				return 'd';
			default:
				System.out.println("an error has occured with the move-history (Winner12): " + mergedMoves);
				return 'd';			}
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
