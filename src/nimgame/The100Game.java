package nimgame;
/**
 * @author Shokry
 * @version 1.00
 */

public class The100Game extends Nim {

	public The100Game() {
		super(1, 100);
	}

	public boolean validInput(int numberOfSticks) {
		return 0 < numberOfSticks && numberOfSticks <= 10 && numberOfSticks <= piles[0].size();
	}
	
	public boolean gameOver() {
		return piles[0].size() == 0;
	}
}
