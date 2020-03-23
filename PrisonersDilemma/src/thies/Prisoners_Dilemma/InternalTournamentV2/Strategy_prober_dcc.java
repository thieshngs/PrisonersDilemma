package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_prober_dcc extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 2, moves = 0;
	boolean all_d, memoryCleared = false;
	Strategy[] strats = {new Strategy_tft(), new Strategy_all_d()};
	
	char getMove(String myHistory, String otherHistory) {
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		moves++;
		
		if (moves < 5) {
			switch (moves) {
			case 1:
				return 'd';
			case 2:
				return 'c';
			case 3:
				return 'c';
			case 4:
				switch (otherHistory) {
				case "cd":
					all_d = false;
					otherMovesMemory = 1;
//					return 'c';
					return 'd';
				case "dc":
					all_d = false;
					otherMovesMemory = 1;
					return 'd';
				case "cc":
					all_d = true;
					otherMovesMemory = 0;
					return 'd';
				case "dd":
					all_d = false;
					myMovesMemory = 0;
					otherMovesMemory = 1;
					return 'd';
				default:
					System.out.println(otherHistory + " is not a valid combination of moves (prober_dcc)");
					return 'd';
				}
			default:
				System.out.println("an error has occured in Strategy prober_cdd");
			}
		} else {
			if(all_d == false) {
				if(memoryCleared == false) {
					otherHistory = "";
					myHistory = "";
					memoryCleared = true;
				}
				return strats[0].getMove(myHistory, otherHistory);
			} else if(all_d == true ) {
				return strats[1].getMove(myHistory, otherHistory);
			} else {
				System.out.println("an error has occured in Strategy prober_cdd");
			}
		}
		return 'e';
	}
	
	public void reset() {
		moves = 0;
		myMovesMemory = 0;
		otherMovesMemory = 2;
	}
}
