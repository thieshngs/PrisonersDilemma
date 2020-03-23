package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_majo_hard extends Strategy{
	int moves;

	char getMove(String myHistory, String otherHistory) {
		moves++;
		myHistory = Utility.checkMemory(myHistory, 0);
		
		if(myHistory == "" && otherHistory == "") {
			return 'd';
		} else {
			int cAmount = 0;
			int dAmount = 0;
			for(int i = 0; i < otherHistory.length(); i++) {
				if(otherHistory.charAt(i) == 'c') {
					cAmount ++;
				} else if (otherHistory.charAt(i) == 'd') {
					dAmount ++;
				} else{
					System.out.println(otherHistory.charAt(i) + " is not a valid option (majo_hard)");
				}
			}
			if(cAmount > dAmount) {
				return 'c';
			} else {
				return 'd';
			}
		
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
