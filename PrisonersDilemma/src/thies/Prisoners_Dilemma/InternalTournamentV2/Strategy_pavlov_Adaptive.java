package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_pavlov_Adaptive extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 1, moves, cCounter, dCounter, category, counter;
	String identifyBehaviour;
	boolean identified = false;
	Strategy tft = new Strategy_tft();
	Strategy endStrategy;
	
	char getMove(String myHistory, String otherHistory) {
		if(identified == false) {
			while(counter <= 6) {
				counter++;
				if (counter > 1) {
					if(counter == 2) {
						identifyBehaviour = Character.toString(otherHistory.charAt(0));
					} else {
						identifyBehaviour = otherHistory.charAt(0) + identifyBehaviour;
					}
					
					if(otherHistory.charAt(0) == 'c') {
						cCounter++;
					}
				}
				
				
				return tft.getMove(myHistory, otherHistory);
			}
			if(cCounter == 6) {
				category = 1;
			} else if(cCounter < 2) {
				category = 2;
			} else if(cCounter == 3 && deadlock(identifyBehaviour)) {
				category = 3;
			} else {
				category = 4;
			}
			
			switch (category) {
			case 1:
				endStrategy = new Strategy_tft();
				break;
			case 2:
				endStrategy = new Strategy_all_d();
				break;
			case 3:
				endStrategy = new Strategy_tf2t();
				break;
			case 4:
				endStrategy = new Strategy_all_d();
				break;
			}
				identified = true;
				return endStrategy.getMove(myHistory, otherHistory);
			
		} else {
			return endStrategy.getMove(myHistory, otherHistory);
		}
	}

	void reset() {
		moves = 0;
		identified = false;
		identifyBehaviour = "";
		cCounter = 0;
		dCounter = 0;
		counter = 0;
	}
	
	boolean deadlock(String str) {
		int deadlockCounter = 0;
		for(int i = str.length() - 1; i > 0; i--) {
			if(str.charAt(i-1) != str.charAt(i)) {
				deadlockCounter++;
			}
		}
		if(str.charAt(str.length() - 1) == 'd') {
			deadlockCounter++;
		}
		if (deadlockCounter == str.length()) {
			return true;
		} else {
			return false;
		}
	}
}
