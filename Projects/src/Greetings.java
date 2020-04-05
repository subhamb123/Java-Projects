/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
October 4, 2017
 */
import java.util.*; //Imports the scanner package.  
public class Greetings {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); //Creates console to use for input. 
		method(console); //Calls the method and inputs console in the method parameter.  
		
	}
	public static void method(Scanner console) {
		System.out.println("Please enter your first name:");
		String firstName = console.next(); //Records user input. 
	    System.out.println("Please enter your last name:");
	    String lastName = console.next();//Records user input. 
	    System.out.println("Please enter your year of birth:");
		int year = console.nextInt();//Records user input. 
	    System.out.println("Greetings, " + firstName.substring(0,1).toUpperCase() /*Gets the first initial and capitalizes it.*/+ ". " + (lastName.substring(0,1).toUpperCase() + lastName.substring(1)) /*Gets the last initial and capitalizes it and adds the rest of the input.*/+ "! You are about " + (2017-year) + " years old.");
	}
}
