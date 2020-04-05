/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
November 16, 2017
 */
//Import Scanner, Print Steam, and File. 
import java.io.*;
import java.util.*;
public class BabyNames {

	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("** Popularity of a baby name since year 1900 **");
		System.out.println();
		Scanner input = new Scanner(System.in);
		boolean newGame = true;
		//Checks whether the user wants to check again, first loop will always be true. 
		while(newGame) {
			method(input);
			System.out.print("Would you like to search another name? ");
			String userInput = input.next();
			//Checks if user wants to search again. 
			if (userInput.toLowerCase().charAt(0) == 'y') {
				newGame = true;
			}
			else {				
				newGame = false;
			}
		}
		
	}
	public static void method(Scanner input) throws FileNotFoundException {
		Scanner console = new Scanner(new File("names.txt"));
		boolean condition = false;
		System.out.print("name? ");
		String x = input.next(); //Get name
		String name = x.substring(0, 1).toUpperCase() + x.substring(1); //Upper cases the first letter for name of file. 
		while(console.hasNext()) {
			if(console.next().equalsIgnoreCase(name)) { //Checks if name is in the file. 
				File file = new File(name + ".txt"); //Creates new file with the name provided. 
				PrintStream use = new PrintStream(new File(name + ".txt")); //Creates an object to print the statistics out to the file to. 
				//Creates a variable to store statistics. 
				String print = "1900: " + console.nextInt() + "\r\n1910: " + console.nextInt() + "\r\n1920: " + console.nextInt() + "\r\n1930: " + console.nextInt() + "\r\n1940: "
						       + console.nextInt() + "\r\n1950: " + console.nextInt() + "\r\n1960: " + console.nextInt() + "\r\n1970: " + console.nextInt() + "\r\n1980: "
						       + console.nextInt() + "\r\n1990: " + console.nextInt() + "\r\n2000: " + console.nextInt();
				System.out.println(print); //Print out to console. 
				use.print("name? " + name.substring(0, 1).toLowerCase() + name.substring(1) + "\r\n" + print); //Print out to file. 
				condition = true; //Makes sure the "name not found" doesn't run. 
			}
		}
		//When the name is not on the file. 
		if(!condition) { 
			System.out.println("name not found.");
		}
	}
}
