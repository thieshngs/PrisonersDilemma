package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_Lucifer_V5 extends Strategy{	
	int myMovesMemory = 0, otherMovesMemory = 1;
	int deadlockThreshold = 3, randomnessThreshold = 7;
	int deadlockCounter = 0, randomnessMeasure = 0, moves = 0, counter = 0, handshakeA = 7, handshakeB = 23;
	boolean random = false, minion = false;
	Strategy strategy = new Strategy_tft();

	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		if(moves == 6) {
			if(otherHistory == "ddddd") {
				random = true;
			}
		}
		
		if(minion == false) {
			if(moves <= 2) {
				if(moves == 2) {
					if(otherHistory.charAt(0) != myHistory.charAt(0)) {
						randomnessMeasure++;
						if(otherHistory.charAt(0) == 'd') {
							return'd';
						}
					}
				}
				return 'c';
			} else if(moves == 4) {
				if(otherHistory.charAt(0) == 'c') {
					if(otherHistory.charAt(1) == 'c') {
						if(otherHistory.charAt(2) == 'd') {
							minion = true;
							return 'd';
						}
					}
					
				}
			}
			if(otherHistory.charAt(0) == 'c' && myHistory.charAt(0) == 'c') {
				randomnessMeasure --;
			}
			if(otherHistory.charAt(0) != otherHistory.charAt(1)) {
				randomnessMeasure++;
			} 
			if(otherHistory.charAt(0) != myHistory.charAt(0)) {
				randomnessMeasure++;
			}
			if(otherHistory.charAt(0) != otherHistory.charAt(1)) {
				deadlockCounter++;
			} else {
				deadlockCounter = 0;
			}
			
			
			
			if(deadlockCounter >= deadlockThreshold && random == false) {
				counter++;
				if (counter >= 2) {
					deadlockCounter = 0;
					counter = 0;
					if(randomnessMeasure >= randomnessThreshold) {
						randomnessMeasure = randomnessThreshold - 1;
					}
				}
				return 'c';		
			}else if(randomnessMeasure >= randomnessThreshold) {
				random = true;
				return'd';
			} else {
				return strategy.getMove(myHistory, otherHistory);
			}
		} else {
			if(moves > 2 && moves != (handshakeA + 1) && moves != (handshakeB + 1) && otherHistory.charAt(0) == 'd') {
				minion = false;
			} else if(moves > 2 && otherHistory.charAt(0) == 'c') {
				if (moves == (handshakeA + 1) || moves == (handshakeB + 1)) {
					minion = false;
				}
			}
			
			if(moves != handshakeA && moves != handshakeB) {
				return 'd';
			}
			
			if(moves == handshakeA|| moves == handshakeB) {
				return 'c';
			}
			System.out.println("an error occured");
			return 'd';
		}
		
	}
	
		

	void reset() {
		moves = 0;
		counter = 0;
		deadlockCounter = 0;
		randomnessMeasure = 0;
		random = false;
		minion = false;
	}
}