package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_mem2 extends Strategy{
	int myMovesMemory = 2, otherMovesMemory = 2, moves = 0, counter = 2, currentStrategy, all_d = 0;
	Strategy[] strats = {new Strategy_tft(), new Strategy_tf2t(), new Strategy_all_d()};
	
	char getMove(String myHistory, String otherHistory) {
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		moves++;
		
		if(moves < 3) {
			return strats[0].getMove(myHistory, otherHistory);
		} else if(all_d > 1) {
			currentStrategy = 2;
		}else if(counter == 2) {
			counter = 0;
			String mergedMoves = myHistory + otherHistory;
			switch (mergedMoves) {
			case "cccc":
				currentStrategy = 0;
				all_d = 0;
				break;
			case "cddc":
				currentStrategy = 1;
				all_d = 0;
				break;
			case "dccd":
				currentStrategy = 1;
				all_d = 0;
				break;
			case "ddcc":
				currentStrategy = 1;
				all_d = 0;
				break;
			case "ccdd":
				currentStrategy = 1;
				all_d = 0;
				break;
			default:
				currentStrategy = 2;
				all_d ++;
			}
		}
		counter++;
		return strats[currentStrategy].getMove(myHistory, otherHistory);
		
	}
	
	public void reset() {
		moves = 0;
	}
	

}
