package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Game {

	Strategy player1, player2;
	int result1 = 0, result2 = 0;
	
	public Game(Strategy player1, Strategy player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void play(int rounds) {
		String history1 = "", history2 = "";
		
		for(int i = 0; i < rounds; i++) {
			char move1 = player1.getMove(history1, history2);
			char move2 = player2.getMove(history2, history1);
			
			history1 = Character.toString(move1) + history1;
			history2 = Character.toString(move2) + history2;

			result1 = result1 + getResult(move1, move2);
			result2 = result2 + getResult(move2, move1);
		}
		
//		System.out.println("results Player 1:   " + result1);
//		System.out.println("results Player 2:   " + result2);
	}
	
	public int getResult(char move1, char move2) {
		String mergedMoves = Character.toString(move1) + Character.toString(move2);
		int result = 0;
		switch (mergedMoves) {
		case "cc":
//			result = 3;
			result = 1;
			break;
		case "cd":
//			result = 0;
			result = -5;
			break;
		case "dc":
//			result = 5;
			result = 2;
			break;
		case "dd":
//			result = 1;
			result = -3;
			break;
		default:
			System.out.println("(" + mergedMoves + ")" + " is an invalid combination of moves");
		}
		return result;
	}
	
	public int getTotalScore1(){
		return result1;
	}
	
	public int getTotalScore2() {
		return result2;
	}
	
}
