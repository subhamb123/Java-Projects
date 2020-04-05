import java.util.*;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Boggle");
		WordList wordlist = new WordList("WordList.txt", 3, 8);//creates a new wordlist object with the max wordlength being 8 and the min being 3 
		Board board = new Board(4, wordlist);//creates a new board
		System.out.println(board.toString());//prints the board to display it
		System.out.println("Write words that appears on the board. It can be formed horizontally, diagonally, or vertically.");
		String s = scanner.nextLine();
		ArrayList<String> w = new ArrayList<String>();
		while(!s.equalsIgnoreCase("terminate")) {
			w.add(s);
			s = scanner.nextLine();
		}
		ArrayList<String> words = board.find();//uses the find method to display the words
		System.out.println();
		System.out.println("Found " + words.size() + " word(s)");
		int count = 0;
		for (int i = 0; i < words.size(); i++){
			if(w.contains(words.get(i))) {
				System.out.println(words.get(i)+ "----> Both you and the computer found this word."); 
				count++;
			}
		    else System.out.println(words.get(i));
		}
		if(count == 1) System.out.println("You found " + count + " word.");
		else System.out.println("You found " + count + " words.");
	}

}
