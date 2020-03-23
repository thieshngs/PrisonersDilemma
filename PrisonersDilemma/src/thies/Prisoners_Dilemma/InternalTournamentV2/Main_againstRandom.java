package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Main_againstRandom {
	public static void main(String[] args) {
		Strategy[] strats = new Strategy[2];
		strats[0] = new Strategy_tft_Omega();
		strats[1] = new Strategy_gradual_Omega2();
		Strategy random = new Strategy_random();
		int result1 = 0;
		int result2 = 0;
		int iterations = 10000000;
		int movesPerMeeting = 50;
		
		for(int j = 0;j < 2;j++) {
			
			for(int i = 0; i < iterations; i++) {
				if(i % 100000 == 0) {
					System.out.println(i);
				}
				strats[j].reset();
				Game game = new Game(strats[j], random);
				game.play(movesPerMeeting);
				if(j == 0) {
					result1 = result1 + game.getTotalScore1();
				} else if(j == 1){
					result2 = result2 + game.getTotalScore1();
				} else {
					System.out.println("an eror occured in Main_againstRandom");
				}
			}
		}
		
		System.out.println("results of " + Utility.removeFirstXCharacters(Utility.removeLastXCharacter(strats[0].toString(), 9), 26) + ": " + result1);
		System.out.println("results of " + Utility.removeFirstXCharacters(Utility.removeLastXCharacter(strats[1].toString(), 9), 26) + ": " + result2);
		
	}
}
