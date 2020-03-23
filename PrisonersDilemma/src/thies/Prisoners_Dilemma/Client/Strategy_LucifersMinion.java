package thies.Prisoners_Dilemma.Client;

public class Strategy_LucifersMinion extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves = 0, handshakeA = 7, handshakeB = 23;
	boolean Lucifer = true;
	private static String myHistory, otherHistory;

	char getMove() {
		moves++;
		if(moves == (handshakeA + 1) || moves == (handshakeB + 1)) {
			if(otherHistory.charAt(0) == 'd') {
				Lucifer = false;
			}
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
				if(moves > 4 && moves != (handshakeA + 1) && moves != (handshakeB + 1) && otherHistory.charAt(0) == 'c') {
					Lucifer = false;
					return 'd';
				}
				
				if(moves != handshakeA && moves != handshakeB) {
					return 'c';
				}
					
				if(moves == handshakeA || moves == handshakeB) {
					return 'd';
					}
			}
			
			System.out.println("a mistake must have happened");
			return'd';
			
		} else {
			return 'd';
		}
			
	}

	
	void reset() {
		moves = 0;
		Lucifer = true;
		myHistory = "";
		otherHistory = "";
	}


	void addHistory(char myMove, char otherMove) {
		myHistory = Character.toString(myMove);
		otherHistory = Character.toString(otherMove);
	}

}
