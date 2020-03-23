package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Strategy_tft_Adaptive extends Strategy{
	int myMovesMemory = 0, otherMovesMemory = 1, moves;
	double willingnessToCoorperate, rate;
	char getMove(String myHistory, String otherHistory) {
		
		myHistory = Utility.checkMemory(myHistory, myMovesMemory);
		otherHistory = Utility.checkMemory(otherHistory, otherMovesMemory);
		willingnessToCoorperate = checkNumber(willingnessToCoorperate);
		rate = checkNumber(rate);
		
		if(myHistory == "" && otherHistory == "") {
			return 'c';
		} else {
			if(otherHistory.charAt(0) == 'c') {
				willingnessToCoorperate = willingnessToCoorperate + rate*(1 - willingnessToCoorperate);
			} else {
				willingnessToCoorperate = willingnessToCoorperate + rate*(0 - willingnessToCoorperate);
			}
			
			if(willingnessToCoorperate >= 0.5) return 'c'; else return 'd';
		}
	}
	
	public void reset() {
		moves = 0;
		willingnessToCoorperate = 0.5;
		rate = 0.5;
	}
	
	public static double checkNumber(double number)  {
		if (number < 1) number = 1.0;
		if (number < 0) number = 0.0;
		return number;
	}
	
	
}
