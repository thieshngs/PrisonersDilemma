package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_gradual extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 1, defections = 0, defectionLimit, moves;
	boolean defect = false, calmdown = false;
	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		if (calmdown == true) {
				calmdown = false;
				return 'c';
		}
		if (defect == false) {
			if(myHistory == "" && otherHistory == "") {
				return 'c';
			} else if (otherHistory.charAt(0) == 'd'){
				defections++;
				defectionLimit++;
				defect = true;
				return 'd';
			} else if(otherHistory.charAt(0) == 'c') {
				return 'c';
			}
		} else if (defect == true) {
			if(defections == defectionLimit) {
				defect = false;
				calmdown = true;
				return 'c';
			} else if (defections < defectionLimit) {
				defections++;
				return 'd';
			} else {
				System.out.println("an error occured in Strategy gradual");
				return 'd';
			}
		}
		System.out.println("an error occured in Strategy gradual");
		return 'e';
		
		
	}
	
	public void reset() {
		moves = 0;
	}
}
