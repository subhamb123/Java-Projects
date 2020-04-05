/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
October 19, 2017
 */
import java.util.*; //Import Scanner

public class Birthdays {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter today's date (month day):"); //Asks user for current date. 
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		int month = console.nextInt();
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		int day = console.nextInt();
		int number = amount(month, day); //Puts into method to get day of year
		System.out.println("Today is " + month + "/" + day + ", day #" + number + " of the year.");
		System.out.println();
		//Information about the first person. 
		System.out.println("Please enter person #1's birthday (month day):");
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		int person1Month = console.nextInt();
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		int person1Day = console.nextInt();		
		int number2 = amount(person1Month, person1Day); //Puts into method to get day of year
		int timeLeft = number2 - number; // How much time until next birthday. 
		//Prints statements depending on how much time is left. 
		if(timeLeft > 0) {
			System.out.println(person1Month + "/" + person1Day + "/" + "2017 falls on day #" + number2 + " of 365. Your next birthday is in " + timeLeft + " day(s).");
		}
		else if(timeLeft < 0) {
			timeLeft = 365 + timeLeft;
			System.out.println(person1Month + "/" + person1Day + "/" + "2017 falls on day #" + number2 + " of 365. Your next birthday is in " + timeLeft + " day(s).");
		}
		else if(timeLeft == 0){
			System.out.println(person1Month + "/" + person1Day + "/" + "2017 falls on day #" + number2 + " of 365. Happy birthday! :)");
		}
		System.out.println();
		//Information about the second person. 
		System.out.println("Please enter person #2's birthday (month day):");
		//Same as information of first person.
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		int person2Month = console.nextInt();
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		int person2Day = console.nextInt();
		int number3 = amount(person2Month, person2Day);
		int timeLeft2 = number3 - number;
		if(timeLeft2 > 0) {
			System.out.println(person2Month + "/" + person2Day + "/" + "2017 falls on day #" + number3 + " of 365. Your next birthday is in " + timeLeft2 + " day(s).");
		}
		else if(timeLeft2 < 0) {
			timeLeft = 365 - timeLeft;
			System.out.println(person2Month + "/" + person2Day + "/" + "2017 falls on day #" + number3 + " of 365. Your next birthday is in " + timeLeft2 + " day(s).");
		}
		else if(timeLeft2 == 0){
			System.out.println(person2Month + "/" + person2Day + "/" + "2017 falls on day #" + number3 + " of 365. Happy birthday! :)");
		}
		System.out.println();
		//Tells which person's birthday is sooner. 
		if(timeLeft == timeLeft2) {
			System.out.println("Person #1 and Person #2 have the same birthday");
		}
		else if(timeLeft > timeLeft2) {
			System.out.println("Person #2's birthday is sooner.");
		}
		else if(timeLeft < timeLeft2) {
			System.out.println("Person #1's birthday is sooner.");
		}
		System.out.println();
		if(number != 294) { //Tells that October 21st was Alfred Nobel's Birthday if current day is not 10/21
			System.out.println("Did you know October 21st was Alfred Nobel's birthday?");
		}
	}
	
	//Finds day number in year. 
	public static int amount(int month, int day) {
		int number = 0;
		
		//for loop that adds days based on month
		for(int i = 1; i < month; i++) {
			if(i == 4 || i == 6 || i == 9 || i == 11) {
				number += 30;
			}
			else if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				number += 31;
			}
			else {
				number += 28;
			}
		}
		number += day;
		return number;
	}
}