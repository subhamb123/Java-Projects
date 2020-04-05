import java.util.*;

public class Board {
	private String[][] board;//the list that contains all the characters of the board
	private WordList wordlist;//is the word list that it will scan
	public Board(int a, WordList wordlist) {
		board = new String[a][a];//creates the size of the board
		this.wordlist = wordlist;//instantiates the wordlist
		//boolean prefixDone = false, suffixDone = false;
		Random r = new Random();//r will randomly fill all the spaces of the board with letters from a string takeen from wordlist
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//prefix spot on the board
				if (i == 0 && j == 0) {
					String[] prefixes = {"RE-", "STR-", "UN-"};
					board[i][j] = prefixes[(int)(Math.random()*prefixes.length)];
				}
				else if (i == 0 && j == board[0].length -1) {
					String[] suffixes = {"-ED", "-EST", "-ING"};
					board[i][j] = suffixes[(int)(Math.random()*suffixes.length)];
				}
				else {
					//String b = wordlist.get(r.nextInt(wordlist.size()));
					board[i][j] = wordlist.nextLetter();
				}
			}
		}
	}
	public ArrayList<String> find() {
		ArrayList<String> list = new ArrayList<String>();//makes a new list that will return all the possible words in board under a maximum word size
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				find(i,j,0,list, "", new int[board.length][board.length]);//calls the recursive find method
				//it uses a new int[] called breadcrumbs which is the same size as the board but only filled with zeros
				//when the recursive search goes over a part of the board, the same part is changed on the breadcrumbs to a one so that the program doesn't go back on itself
				//another thing that is added is the int which checks for how long the word is
				//one more thing that is added is the "" which is used as the word that is checked and added to the list
			}
		}
		Collections.sort(list, new WordComparator());//compares and sorts the list from greatest to least using the wordcomparitor class
		return list;//returns the final list
	}
	void find(int x, int y, int times, ArrayList<String> list, String s, int[][] breadcrumbs) {//recursive find method
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return;
		}
		//PREFIX
			if (x == 0 && y == 0 && times == 0 && breadcrumbs[0][0] == 0) {
				s += board[x][y].substring(0, board[x][y].length()-1);
				int addedLength = board[x][y].length()-1;
				if (wordlist.contains(s) && !list.contains(s))
					list.add(s);
				find(x+1, y, times+addedLength, list, s, breadcrumbs);
				find(x, y+1, times+addedLength, list, s, breadcrumbs);
				find(x+1, y+1, times+addedLength, list, s, breadcrumbs);
				return;
				
			}
			//SUFFIX
			else if (x == 0 && y == board[0].length-1 && times <= wordlist.getLongestWordLength()-2 && breadcrumbs[x][y] == 0) {
				s += board[x][y].substring(1, board[x][y].length());
				int addedLength = board[x][y].length()-1;
				if (wordlist.contains(s) && !list.contains(s) && s.length() <= wordlist.getLongestWordLength())
					list.add(s);
				return;
			}
			breadcrumbs[0][0] = 1;
			
			if (breadcrumbs[x][y] == 0 && times <= wordlist.getLongestWordLength()) {//checks for if search is in the bounds of board or if the maximum is hit or if that posisiton on breadcrumbs is equal to 0
				breadcrumbs[x][y] = 1;//changes the position to 1
				s += board[x][y];//adds the character on that point to s
				if (wordlist.contains(s) && !list.contains(s) && times <= 8) {//checks if the wordlist contains s and if list doesn't contain s
					list.add(s);
				}//recursive search for the rest of the 
				find(x+1, y, times+1, list, s, breadcrumbs);
				find(x+1, y+1, times+1, list, s, breadcrumbs);
				find(x-1, y, times+1, list, s, breadcrumbs);
				find(x-1, y-1, times+1, list, s, breadcrumbs);
				find(x, y+1, times+1, list, s, breadcrumbs);
				find(x+1, y+1, times+1, list, s, breadcrumbs);
				find(x, y-1, times+1, list, s, breadcrumbs);
				find(x-1, y-1, times+1, list, s, breadcrumbs);
				s = s.substring(0, s.length()-1);
				breadcrumbs[x][y] = 0;
			}
		
	}
	public String toString() {//toString method for the board
		String response = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				response += board[i][j]+"\t";//prints out the board
			}
			response += "\n";
		}
		return response;
	}
}
