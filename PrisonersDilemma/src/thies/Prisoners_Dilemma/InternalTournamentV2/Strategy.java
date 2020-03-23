package thies.Prisoners_Dilemma.InternalTournamentV2;

public abstract class Strategy {
	
	abstract char getMove(String myHistory, String otherHistory);
	abstract void reset();

}
