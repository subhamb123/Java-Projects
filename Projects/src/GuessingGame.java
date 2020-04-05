/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
November 1, 2017
 */
import java.util.*; // Import Scanner package. 
public class GuessingGame {
	public static final int NUMBER = 100; // Class constant. 
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); // New object for input. 
		// Variables
		int games = 1; 
	    int totalGuess = 0;
	    int guess = 0;
	    int lowestAmount = 2147483647;
		boolean newGame = true;
		// Checks if user wants to play again, first loop is run by default. 
		while(newGame) {
			guess = method(console); // Calls the method. 
			totalGuess += guess; // Adds current guesses to total amount
			// Checks best guess. 
			if (guess < lowestAmount) {
				lowestAmount = guess;
			}
			// Asks if user wants to play again. 
			System.out.print("Do you want to play again? ");
			String input = console.next();
			if (input.toLowerCase().charAt(0) == 'y') {
				newGame = true;
				games++;
			}
			else {				
				newGame = false;
			}
		}
		// Prints out statistics. 
		double number = (double) totalGuess/games;
		System.out.println("Number of games: " + games);
		System.out.println("Total Guesses: " + totalGuess);
		System.out.println("Average number of guesses: " + Math.round(10.0 * number) / 10.0);
		System.out.println("Fewest guesses taken: " + lowestAmount);
	
	}
	public static int method(Scanner console) {
		System.out.println("I'm thinking of a number between 1 and " + NUMBER + "...");
		System.out.print("Your guess? ");
		int guesses = 0;
		Random rand = new Random(); // New object for random number. 
		int number = rand.nextInt(NUMBER) + 1;
		int guess = checkInput(console); // Checks the input. 
		int lastGuess = guess;
		while (guess != number) { // Checks if the user did not get number. 
			if (guess > number) {
				System.out.println("It's lower.");
				System.out.print("Your guess? ");
				guess = checkInput(console); // Checks the input. 
				if (guess > lastGuess) { // Checks if number inputed was farther than previous number. 
					System.out.println("Your guess was further from the target number");
				}
				lastGuess = guess; // Assigns current guess to check condition. 
			}
			else {
				System.out.println("It's higher");
				System.out.print("Your guess? ");
				guess = checkInput(console); // Checks the input. 
				if (guess < lastGuess) { // Checks if number inputed was farther than previous number. 
					System.out.println("Your guess was further from the target number");
				}
				lastGuess = guess; // Assigns current guess to check condition. 
			}
			guesses++;
		}
		guesses++;
		System.out.println("You guessed it in " + guesses + " guesses!");
		return guesses;
	}
		public static int checkInput(Scanner console)  {
			// Checks if guess is something other than a whole number. 
			while (!console.hasNextInt()) { 
				System.out.println("Your guess was not a whole number between 1 and " + NUMBER + ".");
				console.nextLine();
				System.out.print("Your guess? ");
			}
			int guess = console.nextInt();
			// Checks if it is between the range. 
			while (guess < 1 || guess > NUMBER) {
				System.out.println("Your guess was not a whole number between 1 and " + NUMBER + ".");
				console.nextLine();
				System.out.print("Your guess? ");
				guess = console.nextInt();
			}
			
			return guess;
		}
}

