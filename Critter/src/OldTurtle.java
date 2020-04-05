public class OldTurtle implements Critter {
	
	// Additional fields for use in the class
	private int steps=0;
	private int direction=0;
	private int move=0;
	private boolean moving=false;
	
	// Returns the corresponding char for Old Turtles
	public char getChar() {
		return 'O';
	}
	
	// Cycles between the four directions in clockwise fashion that each Turtle will move for ten turns, not moving every other turn
	public int getMove(CritterInfo info) {
		if (this.steps==0) {
			steps=10;
			if (move%4==2) {
				direction=NORTH;
			} else if (move%4==0) {
				direction= SOUTH;
			} else if (move%4==3) {
				direction= EAST;
			} else if (move%4==1) {
				direction= WEST;
			}
			move++;
		}
		steps--;
		moving=!moving;
		if (moving) {
			return direction;
		}
		return CENTER;
	}
}