import java.util.*;
public class Magpie{
	static int count = 0;
	public static void main(String[] args) throws Exception {
		Magpie m = new Magpie();
		System.out.println(getGreeting());
		Scanner scanner = new Scanner(System.in);
		String s = "";
		while(!s.equalsIgnoreCase("terminate")) { //sentinel
			s = scanner.nextLine();
			System.out.println(m.getResponse(s));
			if(count%5==0) {
				System.out.println("Do you want to play a game?");
				String str = scanner.next();
				while(str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y")) {
					Scanner console = new Scanner(System.in);
					System.out.println("GAMES\n===============\n1) Song\n2) Space Needle\n3) Interest Program\n4) Birthday Program\n5) Guessing Game\n6) Baby Names\n7) Sum Program\n8) Fraction\n9) Critter Simulation\n10) Store \n11) Boggle Game\n12) Sort Algorithms");
					System.out.println("Type number that corresponds to the project/game you want to see. ");
					while(!console.hasNextInt()) {
						System.out.println("Enter a valid input!");
						console.nextLine();
					}
					int x = console.nextInt();
					switch(x) {//cases that call the different projects
					//the projcects have been slighly modified to be more user friendly
						case 1: //This case calls the Song Project from chapter 1
							Song.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 2://This case calls the Space needle Project from chapter 2
							SpaceNeedle.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 3://This case calls the Interest Project from chapter 3
							Interest.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 4://This case calls the Birthdays Project from chapter 4
							Birthdays.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 5://This case calls the Guessing Game Project from chapter 5
							GuessingGame.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 6://This case calls the Baby Names Project from chapter 6
							BabyNames.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 7: //This case calls the Calculator Project from chapter 7
							Sum.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 8://This case calls the Fraction Project from chapter 8
							Fraction.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 9://This case calls the Critter Project from chapter 9
							CritterMain.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 10://This case calls the Shopping Cart Project from chapter 10
							ShoppingMain.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 11://This case calls the Boggle Project from chapter 12
							Program.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						case 12://This case calls the Sorting Project from chapter 13
							sortProgram.main(args);
							System.out.println("Do you like it?");
							s = scanner.next();
							System.out.println(m.getResponse(s));
							break;
						default://This case occurs if the user doesn't entetr in a valid input
							System.out.println("Enter a valid input. ");
							break;
					}
					System.out.println("Do you want to see more projects?");
					str = scanner.next();
				}
				if(str.equalsIgnoreCase("no") || str.equalsIgnoreCase("n")) {
					System.out.println("Then what else do you want to do?");
					str = scanner.next();
				}
			}
		}
	}
	public static String getGreeting()//beginning of the chat
	{ 
		return "Hello! Let's chat. ";//introduction with a greeting
	}
	
	public String getResponse(String statement)//these are the varying statements of the chatbot
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
			count++;
		}
		else if (findKeyword(statement, "I want to die") >=0 || findKeyword(statement, "die") >=0 || findKeyword(statement, "death to America") >=0 || findKeyword(statement, "Death") >=0 ) {
			response = "What makes you think that?";
			count++;
		}
		else if (findKeyword(statement, "Yeah, totally I'll do that") >=0 || findKeyword(statement, "Sure thing") >=0) {
			response = "Alright, thanks";
			count++;
		}
		else if (findKeyword(statement, "hello") >=0 || findKeyword(statement, "sup") >=0 || findKeyword(statement, "hey") >=0 || findKeyword(statement, "what's up") >=0 || findKeyword(statement, "hi") >=0) {
			response = "Hi!";
			count++;
		}
		else if (findKeyword(statement, "how are you") >=0) {
			response = "I am fine, thank you! How are you?";
			count++;
		}
		else if (findKeyword(statement, "your name") >=0) {
			response = "My name is Bob.";
			count++;
		}
		else if (findKeyword(statement, "my name") >=0) {
			response = "Do you think I care?";
			count++;
		}
		else if (findKeyword(statement, "lol") >=0) {
			response = "You aren't funny.";
			count++;
		}
		else if (findKeyword(statement, "old are you") >=0) {
			response = "I am 32 nanoseconds old. Don't judge";
			count++;
		}
		else if (findKeyword(statement, "k") >=0 || findKeyword(statement, "ok") >=0 || findKeyword(statement, "sure") >=0 || findKeyword(statement, "totally") >=0) {
			response = "Alright.";
			count++;
		}
		else if (findKeyword(statement, "good") >=0 || findKeyword(statement, "outstanding") >=0 || findKeyword(statement, "yes") >=0 || findKeyword(statement, "excellent") >=0 || findKeyword(statement, "acceptable") >=0 || findKeyword(statement, "exceptional") >=0 || findKeyword(statement, "great") >=0 || findKeyword(statement, "marvelous") >=0 || findKeyword(statement, "superb") >=0 || findKeyword(statement, "wonderful") >=0) {
			response = "Thank you!";
		}
		else if (findKeyword(statement, "no") >= 0 || findKeyword(statement, "ugly") >= 0 || findKeyword(statement, "stupid") >= 0 || findKeyword(statement, "dumb") >= 0 || findKeyword(statement, "n") >=0)
		{
			response = "Why so negative?";
			count++;
		}
		else if (findKeyword(statement, "bye") >= 0 || findKeyword(statement, "exit") >= 0 || findKeyword(statement, "terminate") >= 0 || findKeyword(statement, "end") >= 0 || findKeyword(statement, "cancel") >= 0 || findKeyword(statement, "dismiss") >= 0)
		{
			System.out.println("Bye!");
			System.exit(0);
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
			count++;
		}

		// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		//  Part of student solution
		else if (findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

		else
		{

			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				//  Part of student solution
				// Look for a two word (I <something> you)
				// pattern
				psn = findKeyword(statement, "i", 0);

				if (psn >= 0
						&& findKeyword(statement, "you", psn) >= 0)
				{
					response = transformIYouStatement(statement);
				}
				else
				{
					response = getRandomResponse();
				}
			}
		}
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		count++;
		return "What would it mean to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		count++;
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		count++;
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		count++;
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		count++;
		return response;
	}
	
}
