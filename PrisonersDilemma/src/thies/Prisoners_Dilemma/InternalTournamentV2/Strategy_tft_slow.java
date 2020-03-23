package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_tft_slow extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 2, moves = 0;
	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		moves++;
		String mergedMoves = myHistory + otherHistory;
		
		if(moves < 3) {
			return 'c';
		} else {
			switch (mergedMoves) {
			case "ccc":
				return 'c';
			case "ccd":
				return 'c';
			case "cdc":
				return 'c';
			case "cdd":
				return 'd';
			case "dcc":
				return 'c';
			case "dcd":
				return 'd';
			case "ddc":
				return 'd';
			case "ddd":
				return 'd';
				
			default:
				System.out.println( mergedMoves + " an error has occured (tft_slow)");
				return 'd';
			}
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
