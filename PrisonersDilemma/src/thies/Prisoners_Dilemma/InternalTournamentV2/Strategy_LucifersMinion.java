package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_LucifersMinion extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves = 0, counter = 20, handshakeCounter = 0;
	boolean Lucifer = true;

	char getMove(String myHistory, String otherHistory) {
		moves++;
		counter--;
		if(counter < 0) {
			if(handshake(myHistory.charAt(0), otherHistory.charAt(0)) == false) {
				Lucifer = false;
			}
			counter = 20 * (handshakeCounter + 1);
		}
		
		if(Lucifer == true) {
			if (moves == 1) {
				return 'd';
			} else if (moves == 2) {
				if (otherHistory.charAt(0) == 'd') {
					Lucifer = false;
					return 'd';
				} else {
					return 'c';
				}
			} else {
				if(moves > 4 && counter % 20 != 0 && otherHistory.charAt(0) == 'c') {
					Lucifer = false;
					return 'd';
				}
				
				if(counter > 0) {
					return 'c';
				}
					
				if(counter == 0) {
					handshakeCounter++;
					return 'd';
					}
			}
			
			System.out.println("a mistake must have happened");
			return'd';
			
		} else {
			return 'd';
		}
			
	}

	static boolean handshake(char myHistory, char otherHistory) {
		if (otherHistory == 'c') {
			if(myHistory == 'd') {
				return true;
			}
		}
		return false;
	}
	
	void reset() {
		moves = 0;
		counter = 20;
		handshakeCounter = 0;
		Lucifer = true;
	}

}
