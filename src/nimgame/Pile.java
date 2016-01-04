package nimgame;

public class Pile {
	private int numberOfSticks;

	public Pile() {
		numberOfSticks = 0;
	}
	
	public Pile(int n) {
		numberOfSticks = n;
	}
	
	public int size() {
		return numberOfSticks;
	}
	
	public void remove(int n) {
		numberOfSticks -= n;
	}
}
