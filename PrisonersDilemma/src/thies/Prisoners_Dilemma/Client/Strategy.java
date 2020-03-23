package thies.Prisoners_Dilemma.Client;

public abstract class Strategy {
	
	abstract char getMove();
	abstract void reset();
	abstract void addHistory(char myMove, char otherMove);

}