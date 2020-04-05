/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
November 28, 2017
 */
import java.util.*;                                                                    //Import utilities and input/output. 
import java.io.*;

public class Sum {
	public static final int array = 25;                                                //Class constant to how many digits the number has. 
	public static void main(String args[]) throws FileNotFoundException{
		Scanner console = new Scanner(new File("sum.txt"));                            //Reads the file. 
		start(console);	
	}
	///This method checks if the text file has a next line. 
	public static void start(Scanner console) throws FileNotFoundException{
		int lineCount = 0;                                                             //Keeps track of number of lines. 
		while(console.hasNextLine()) {
			Scanner line = new Scanner(console.nextLine());
			if(line.hasNext()) {
				line(line);                                                            //Calls the line nethod to do something to the line. 
				lineCount++;                                                           //Incremeants counter. 
			}
		}
		System.out.println("Total lines = " + lineCount);                              //Prints out at the end of the program how many lines there are in the file. 
	}
	///This method makes the number at hand into an array. 
	public static int[] makeArray(String number) throws FileNotFoundException{
		int[] zeroNumber = new int[array];                                             //Initializes an array which will hold zero placeholders and the number. 
		int i = 0;                                                                     //i will be used to add that many zeroes to the number so the number can be at the right side for addition. 
		while(i < number.length()&&number.charAt(i) == '0') {
			i++;
		}
		for(; i < number.length(); i++) {                                              //This for loop adds the number of zeroes to the point of what i is. 
			zeroNumber[(array - number.length()) + i] = number.charAt(i) - '0';
		}
		return zeroNumber;
	}
	///This method takes the line and adds all the numbers in that line. 
	public static void line(Scanner line) throws FileNotFoundException{
		int[] currentNumber = makeArray(line.next());                                  //This makes the number selected into an array. 
		toNumber(currentNumber);                                                       //Prints out the selected number. 
		while(line.hasNext()) {
			System.out.print(" + ");
			int[] nextNumber = makeArray(line.next());                                 //This makes the next number into an array. 
			toNumber(nextNumber);                                                      //Prints out the next number. 
			int[][] temporary = new int[2][];                                          //This array holds the two numbers that are being compared. 
			temporary[1] = nextNumber;
			temporary[0] = currentNumber;
			currentNumber = toAdd(temporary);                                          //The current number is being replaced with the two numbers that are added. 
		}
		System.out.print(" = ");
		toNumber(currentNumber);                                                       //Prints out the summed up number of that line. 
		System.out.println();
	}
	///This method prints the number out from the array. 
	public static void toNumber(int[] number) throws FileNotFoundException{
		int i = 0;
		while(i < number.length&&number[i] == 0) {                                     //Gets to the actual number to print out. 
			i++;
		}
		if(i == number.length) {                                                       //This checks if the number itself is zero, then it will print 1 zero. 
			System.out.print(0);
			return;
		}
		for(; i < number.length; i++) {                                                //Prints out rest of the number. 
			System.out.print(number[i]);
		}
	}
	///This method adds the two selected numbers.  
	public static int[] toAdd(int[][] addition) throws FileNotFoundException{
		int[] sum = new int[array];                                                    //This array holds the summed up two numbers. 
		for(int i = array - 1; i >= 0; i--) {
			for(int j = 0; j < addition.length; j++) {
				sum[i] += addition[j][i];                                              // This adds the digits in its corresponding space. 
			}
			if(sum[i] >= 10) {                                                         //This condition checks if the number is carried over to the next digit. 
				sum[i - 1] += sum[i] / 10;
				sum[i] = sum[i] % 10;
			}
		}
		return sum;
	}
}