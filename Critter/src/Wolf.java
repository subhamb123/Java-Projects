import java.util.Random;

public class Wolf implements Critter {
	
	// Additional fields for use in the class
	private int steps=0;
	private int direction=0;
	
	// Returns the corresponding char for Wolves
	public char getChar() {
		return 'W';
	}
	
	// Uses a random number generator to randomly select which direction each Wolf will move for a random number (1-10) of turns
	public int getMove(CritterInfo info) {
		Random r=new Random();
		int move;
		if (this.steps==0) {
			move=r.nextInt(4);
			steps=r.nextInt(10)+1;
			if (move==0) {
				direction=NORTH;
			} else if (move==1) {
				direction= SOUTH;
			} else if (move==2) {
				direction= EAST;
			} else if (move==3) {
				direction= WEST;
			}
			
		}
		steps--;
		return direction;
	}
}
