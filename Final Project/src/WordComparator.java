import java.util.*;

public class WordComparator implements Comparator<String>{//this comparable compares the length of a sting, typically a word
	public int compare (String b, String a) {
		int num = a.length() - b.length();
		if(num != 0) {
			return num;
		}
		return b.compareTo(a);
	}
}
