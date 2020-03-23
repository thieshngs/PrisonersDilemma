package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Tournament {
	int[] results = new int[Utility.tournamentParticipants];
	Strategy[] strats = new Strategy[Utility.tournamentParticipants];
	
	public void play(int roundsPerGame) {
		
		strats = Utility.fillTournament();
		
		for(int i = 0; i < strats.length; i++) {
			Strategy[] opponentStrats = new Strategy[Utility.tournamentParticipants];
			opponentStrats = Utility.fillTournament();
			
			for(int j = 0; j < opponentStrats.length; j++) {
				System.out.println("next match: " + Utility.removeFirstXCharacters(Utility.removeLastXCharacter(strats[i].toString(), 9), 26) + " vs " + Utility.removeFirstXCharacters(Utility.removeLastXCharacter(opponentStrats[j].toString(), 9), 26));
				Game game = new Game(strats[i], opponentStrats[j]);
				strats[i].reset();
				opponentStrats[j].reset();
				game.play(roundsPerGame);
				results[i] += game.getTotalScore1();
			}
		}
		
	}
	
	public int[] getTotalResults() {
		return results;
	}
}
