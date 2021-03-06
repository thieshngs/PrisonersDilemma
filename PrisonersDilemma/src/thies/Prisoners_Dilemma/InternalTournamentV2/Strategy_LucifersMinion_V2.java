package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_LucifersMinion_V2 extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves = 0, handshakeA = 7, handshakeB = 23;
	boolean Lucifer = true;

	char getMove(String myHistory, String otherHistory) {
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
	}

}
