/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
March 25, 2018
 */
import java.util.*;

public class Program {
	public static void main(String[] args) {
		WordList wordlist = new WordList("WordList.txt", 3, 8); //Instantiates
		Board board = new Board(wordlist, 4);
		System.out.println("Welcome to Boggle, by Subham"); //Introduction and print board from toString() method
		System.out.println(board);
		ArrayList<String> words = board.find(); //Tells longest word available
		
		System.out.println("Found " + words.size() + " word(s)"); //Shows how many words found
		int length = 0;
		//Prints out the subcategories
		for(String s : words) {
			if(s.length() != length) {
				length = s.length();
				System.out.println();
				System.out.println(length + " letter words");
			}
			System.out.println(s);
		}
	}
}
