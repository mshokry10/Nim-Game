package nimgame;
/**
 * @author Shokry
 * @version 1.00
 */


public abstract class Nim {
	
	protected Pile[] piles;
	protected static final boolean PLAYER1 = true, PLAYER2 = false;
	protected boolean currentPlayer = PLAYER1;
	
	/**
	 * 
	 * @param nPiles number of piles in the game.
	 * @param maxValue the maximum number of objects in a pile.
	 */
	public Nim(int nPiles, int maxValue) {
		resetGame(nPiles, maxValue);
	}
	
	/**
	 * Resets the game to the initial state.
	 * @param nPiles number of piles in the game.
	 * @param maxValue the maximum number of objects in a pile.
	 */
	public void resetGame(int nPiles, int maxValue) {
		currentPlayer = PLAYER1;
		piles = new Pile[nPiles];
		for (int i = piles.length - 1; i >= 0; i--) {
			piles[i] = new Pile(maxValue);
			--maxValue;
		}
	}
	
	/**
	 * 
	 * @param pileIndex the index of the pile to remove objects from.
	 * @param numberOfObjects the number of objects to remove from the pile.
	 */
	public void makeAMove(int index, int count) {
		piles[index].remove(count);
		if (currentPlayer == PLAYER1)
			currentPlayer = PLAYER2;
		else
			currentPlayer = PLAYER1;
	}
	
	/**
	 * 
	 * @param numberOfObjects
	 * @return returns true if the move is a valid move, and false otherwise.
	 */
	public abstract boolean validInput(int numberOfObjects);
	
	/**
	 * 
	 * @return returns true if the game is over, and false otherwise.
	 */
	public abstract boolean gameOver();
}
