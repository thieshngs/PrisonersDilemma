package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_equalizer_F extends Strategy{
	int myMovesMemory = 1, otherMovesMemory = 1, moves;
	char getMove(String myHistory, String otherHistory) {
		moves++;
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		String mergedHistory = myHistory + otherHistory;
		if(myHistory == "" && otherHistory == "") {
			return 'c';
		} else if(mergedHistory.contentEquals("cc")){
			return 'c';
		} else if(mergedHistory.contentEquals("cd")){
			if(Utility.randomPercent() > 86.66666667) {return 'd';} else {return 'c';}
		} else if(mergedHistory.contentEquals("dc")){
			if(Utility.randomPercent() > 20) {return 'd';} else {return 'c';}
		} else {
			if(Utility.randomPercent() > 40) {return 'd';} else {return 'c';}
		}
	}
	
	public void reset() {
		moves = 0;
	}
}
