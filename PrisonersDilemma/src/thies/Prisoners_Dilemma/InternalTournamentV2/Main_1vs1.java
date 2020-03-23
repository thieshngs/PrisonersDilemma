package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Main_1vs1 {
	public static void main(String[] args) {
		Strategy player1 = new Strategy_LucifersMinion_V2();
		Strategy player2 = new Strategy_Lucifer_V4();
		Game game = new Game(player1, player2);
		game.play(1500);
		System.out.println("result player 1:  " + game.result1);
		System.out.println("result player 2:  " + game.result2);

	}
}
