import java.util.Random;

public class Bird implements Critter {
	private int[] directions = {NORTH, EAST, SOUTH, WEST};
	
	public char getChar() {
		return 'B';
	}

	public int getMove(CritterInfo info) {
		Random rand = new Random();
		int n = rand.nextInt(4);
		
		return directions[n];
	}

}
