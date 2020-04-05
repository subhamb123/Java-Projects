/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
October 4, 2017
 */
import java.util.*;                                                                             //Imports the scanner package.  
public class Interest {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);                                               //Creates console to use for input. 
		method(console);                                                                        //Calls the method and inputs console in the method parameter.  
		
	}
	public static void method(Scanner console) {
		System.out.println("Enter your initial investment:");
		while(!console.hasNextDouble()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		double investment = console.nextDouble();                                               //Records user input.
	    System.out.println("Enter your annual deposit:");
	    while(!console.hasNextDouble()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
	    double deposit = console.nextDouble();                                                  //Records user input. 
	    System.out.println("Enter number of years:");
	    while(!console.hasNextDouble()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		double years = console.nextDouble();                                                    //Records user input.
		System.out.println("Enter interest rate:");
		while(!console.hasNextDouble()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		double interest = console.nextDouble();                                                 //Records user input.
	    System.out.println("Year\tInterest\tDeposit\tBalance");
		System.out.println("start\t\t\t\t" + investment);
		double displayValue;                                                                    //Variable to record interest money. 
		for (int i = 1; i<= years; i++) {                                                       //Makes the number of rows according to the number of years. 
			displayValue = (Math.floor(interest*investment/100*100))/100;                       //This is the interest money per year which is truncated to the nearest cent. 
			investment = (Math.floor((investment+deposit+displayValue)*100))/100;               //This is the balance after adding the interest and deposit amount. 
			System.out.println(i + "\t" + displayValue + "\t\t" + deposit + "\t" + investment); //This will print out the table which will display new balance, deposit, interest, and years. 
		}
		
	}
}
