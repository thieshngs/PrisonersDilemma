package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Main_Tournament {
	public static void main(String[] args) {
		Tournament tournament = new Tournament();
		tournament.play(1000);
		int[] results = new int[24];
		results = tournament.getTotalResults();
		System.out.println("experiment done!");
		System.out.println("results-----------------------------------------------------------------------");
		for(int i = 0; i < results.length; i++) {
			String strategy = Utility.removeFirstXCharacters(Utility.removeLastXCharacter(tournament.strats[i].toString(), 9), 26);
			if(strategy.length() < 15) {
				System.out.println(strategy + ":\t\t\t" +results[i]);
			} else if (strategy.length() > 22) {
				System.out.println(strategy + ":\t" +results[i]);
			} else {
				System.out.println(strategy + ":\t\t" +results[i]);
			}
			
		}
	}
}
