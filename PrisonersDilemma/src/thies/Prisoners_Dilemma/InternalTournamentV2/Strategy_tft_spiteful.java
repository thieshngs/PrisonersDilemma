package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_tft_spiteful extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 2, moves; 
	boolean all_d = false;
	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		
		if(all_d == false) {
			if(myHistory == "" && otherHistory == "") {
				return 'c';
			} else if (otherHistory == "dd") {
				all_d = true;
				return 'd';
			} else {
				return otherHistory.charAt(0);
			}
		} else {
			return 'd';
		}
			
	}
	
	public void reset() {
		moves = 0;
	}
}
