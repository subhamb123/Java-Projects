/*
 Subham Behera
 Mr.Peterson
 AP Computer Science, Period 5
 September 19-25, 2017
 */
public class SpaceNeedle {
	public static final int size = 7; //Variable that scales the Space Needle
	public static void main(String[] args) {
		needle(); //Makes needle. 
		topBase(); //Makes dome and transition between dome and bottom base. 
		bottomBase(); //Makes the bottom base. 
		needle(); //Makes the transition between the bottom base and the elevator. 
		middle(); //Makes the elevator. 
		topBase(); //Makes the base using the top base method. 
	}
	public static void needle() { //This method makes the needle and the transition between the bottom base and the middle.
		for (int i = 1; i <= size*1; i++) { //Makes the lines
			for (int j = 1; j <= size*3; j++) { //Makes the spaces at each line
				System.out.print(" ");
			}
			System.out.println("||"); 
		}
	}
	public static void topBase(){ // This method makes the dome below the needle. 
		for (int i = 1; i <= size; i++){ //Makes the lines
			for (int j = 1; j <= ((size * 3) - 3 * i); j++){ //Makes the spaces at each line
				System.out.print(" ");
			}
			System.out.print("__/");
			for (int j = 1; j <= ((i - 1) * 3); j++){ //Makes the left colons inside the dome. 
				System.out.print(":");
			}
			System.out.print("||"); 
			for (int j = 1; j <= ((i - 1) * 3); j++){ //Makes the right colons inside the dome. 
				System.out.print(":");
			}
			System.out.print("\\__");
			System.out.println();
		}
		System.out.print("|"); //Makes the transition between the dome and the bottom base. 
		for (int j = 1; j <= (size * 6); j++){ //Makes the amount of quotation marks depending on scale. 
			System.out.print("\""); 
		}
		System.out.print("|");
		System.out.println();
	}
	public static void bottomBase() { //This method makes the bottom base. 
		for (int i = 1; i <= size; i++){ //Makes the lines
			for (int j = 1; j <= (2 * i - 2); j++){ //Makes the spaces at each line. 
				System.out.print(" ");
			}
			System.out.print("\\_");
			for (int j = (size * 3 - 2 * i + 1); j >= 1; j--){ //Makes the amount of \/ per line. 
				System.out.print("/\\");
			}
			System.out.print("_/");
			System.out.println();
		}
	}
	public static void middle() { //This method makes the elevator. 
		for (int i = 1; i <= size*4; i++) { //Number of lines
			for (int j = 1; j <= size*(9/4); j++) { //Number of spaces per line
				System.out.print(" ");
			}
			System.out.print(" |");
			for (int j = 1; j <= size-2; j++) { //Makes the amount of % depending on the scale. 
				System.out.print("%");
			}
			System.out.print("||");
			for (int j = 1; j <= size-2; j++) { //Makes the amount of % depending on the scale. 
				System.out.print("%");
			}
			System.out.print("|");
			System.out.println();
		}
	}

}