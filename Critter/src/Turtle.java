import java.util.*;

public class Turtle implements Critter{
	private int count;
	private int direction;
	
	Turtle()
	{
		this.count = 1;
		this.direction = 0;
	}

	public char getChar()
	{
		return 'T';
	}
	
	public int getMove(CritterInfo info)
	{
		int[] directions = {SOUTH, WEST, NORTH, EAST};
		if (count != 5)
		{
			count++;
			return directions[direction];
		}
		else
		{
			count = 1;
			int x = direction;
			if (direction == 3)
				direction = 0;
			else {
				direction++;
			}
			return directions[x];
			
		}
	}
}
