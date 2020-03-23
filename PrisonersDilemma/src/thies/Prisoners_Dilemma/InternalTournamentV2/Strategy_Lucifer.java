package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_Lucifer extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves = 0, counter = 20, handshakeCounter = 0;
	boolean minion = true;
	Strategy Omega = new Strategy_gradual_Omega2();

	char getMove(String myHistory, String otherHistory) {
		moves++;
		counter--;
		
		
		if(moves > 2 && counter > 0 && otherHistory.charAt(0) == 'd') {
			minion = false;
		} else if(moves > 2 && counter < 0 && otherHistory.charAt(0) == 'c') {
			minion = false;
		}
		
		if(counter < 0) {
			if(handshake(myHistory.charAt(0), otherHistory.charAt(0)) == false) {
				minion = false;
			}
			counter = 20 * (handshakeCounter + 1);
		}
		
		if(moves == 1) {
			return 'c';
		} else if(moves == 2) {
			if(otherHistory.charAt(0) == 'c') {
				minion = false;
				return Omega.getMove(myHistory, otherHistory);
			} else {
				return 'd';
			}
		} else {
			if(minion) {
				if(counter > 0) {
					return 'd';
				}
				
				if(counter == 0) {
					handshakeCounter++;
					return 'c';
				}
			} else {
				return Omega.getMove(myHistory, otherHistory);
			}
		}
		
		System.out.println("a mistake must have happened");
		return'd';
		
	}
	
	static boolean handshake(char myHistory, char otherHistory) {
		if (otherHistory == 'd') {
			if(myHistory == 'c') {
				return true;
			}
		}
		return false;
	}

	void reset() {
		moves = 0;
		counter = 20;
		handshakeCounter = 0;
		minion = true;
		Omega.reset();
	}
	

}
