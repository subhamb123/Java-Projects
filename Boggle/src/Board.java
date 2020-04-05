/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
March 25, 2018
 */
import java.util.*; //Import utilities
public class Board {
	String[][] board = null; //Fields
	WordList wordlist = null;
	public Board(WordList list, int boardSize) {
		wordlist = list;
		board = new String[boardSize][boardSize]; //Defines size of board
		//Fills the board with random letters. 
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				Random r = new Random();
				String word = wordlist.get(r.nextInt(wordlist.size()));
				
				int index = r.nextInt(word.length() - 1);
				String chosen = word.substring(index, index + 1);
				board[i][j] = chosen;
			}
		}
	}
	///Makes the board into a string
	public String toString() {
		String string = "";
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j< board.length; j++) {
				string = string + board[i][j] + "\t";
			}
			string = string + "\n";
		}
		return string;
	}
	///This method holds the array of the list. 
	public ArrayList<String> find() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				find(list, new int[board.length][board.length], i, j, "");
			}
		}
		Collections.sort(list, new WordComparator());
		return list;
	}
	///Helper method to recursively find words
	void find(ArrayList<String> words, int[][] path, int row, int column, String search) {
		if (row >= 0 && column >= 0 && row < board.length && column < board.length && path[row][column] == 0 && search.length() < wordlist.getLongestWordLength()) {
			search += board[row][column];
			path[row][column] = 1;
			if (wordlist.contains(search) && !words.contains(search)) {
				words.add(search);
			} 
			//Backtracking
			find(words, path, row - 1, column - 1, search);
			find(words, path, row, column - 1, search);
			find(words, path, row, column + 1, search);
			find(words, path, row - 1, column + 1, search);
			find(words, path, row - 1, column, search);
			find(words, path, row + 1, column - 1, search);
			find(words, path, row + 1, column, search);
			find(words, path, row + 1, column + 1, search);
			search = search.substring(0, search.length() - 1);
			path[row][column] = 0;
		}
	}
}
