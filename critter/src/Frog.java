 import java.util.Random;

public class Frog implements Critter{
	private int count = 3;
	private int direction;
	
	public char getChar() {
		return 'F';
	}
	
	public int getMove(CritterInfo info)
	{
		if (!(count == 3))
		{
			count++;
			return direction;
		}
		else
		{
			Random r = new Random();
			int x = r.nextInt(4);
			if (x == 0)
				direction = NORTH;
			else if (x == 1)
				direction = EAST;
			else if (x == 2)
				direction = SOUTH;
			else
				direction = WEST;
			count = 1;
			return direction;
		}
	}

}
