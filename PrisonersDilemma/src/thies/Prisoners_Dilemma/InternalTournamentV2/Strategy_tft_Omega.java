package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_tft_Omega extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 1;
	int deadlockThreshold = 3, randomnessThreshold = 8;
	int deadlockCounter = 0, randomnessMeasure = 0, moves = 0, counter = 0;
	boolean random = false;
	Strategy tft = new Strategy_tft();

	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		if(moves <= 2) {
			if(moves == 2) {
				if(otherHistory.charAt(0) != myHistory.charAt(0)) {
					randomnessMeasure++;
				}
			}
			return tft.getMove(myHistory, otherHistory);
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
			return tft.getMove(myHistory, otherHistory);
		}
		
	}
		

	void reset() {
		moves = 0;
		counter = 0;
		deadlockCounter = 0;
		randomnessMeasure = 0;
		random = false;
	}

}
