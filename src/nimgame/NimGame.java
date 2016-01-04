package nimgame;
/**
 * @author Shokry
 * @version 1.00
 */

public class NimGame extends Nim {

	/**
	 * 
	 * @param nPiles nPiles number of piles in the game.
	 * @param maxValue maxValue the maximum number of objects in a pile.
	 */
	public NimGame(int nPiles, int maxValue) {
		super(nPiles, maxValue);
	}

	public boolean validInput(int numberOfSticks) {
		return 0 < numberOfSticks && numberOfSticks <= piles.length;
	}
	
	public boolean gameOver() {
		boolean allEmpty = true;
		for (Pile pile : piles) {
			if (pile.size() > 0)
				allEmpty = false;
		}
		return allEmpty;
	}

}
