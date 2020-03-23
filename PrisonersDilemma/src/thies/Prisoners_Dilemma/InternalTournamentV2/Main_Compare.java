package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Main_Compare {
	public static void main(String[] args) {
		Strategy[] compare = new Strategy[2];
		compare[0] = new Strategy_tft_Omega();
		compare[1] = new Strategy_gradual_Omega2();
		
		
		Strategy[]  strats = new Strategy[Utility.tournamentParticipants];
		strats = Utility.fillTournament();
		for(int i = 0; i < 2; i++) {
			System.out.println(compare[i] + "--------------------------------------");
			for(int j = 0; j < Utility.tournamentParticipants; j++) {
				Game game = new Game(compare[i], strats[j]);
				strats[j].reset();
				compare[i].reset();
				game.play(1500);
				String strategy = Utility.removeFirstXCharacters(Utility.removeLastXCharacter(compare[i].toString(), 9), 26);
				String opponent = Utility.removeFirstXCharacters(Utility.removeLastXCharacter(strats[j].toString(), 9), 26);
				System.out.println("result " + strategy + " vs " + opponent + ":" + game.result1);
			}
			System.out.println("-------------------------------------------------------------------------------");
		}
	}
}
