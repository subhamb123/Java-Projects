/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
March 25, 2018
 */
import java.util.*;

public class WordComparator implements Comparator<String>{
	//Compares two words
	public int compare(String o1, String o2) {
		if (o1.length() == o2.length()) {
			return o1.compareTo(o2);
		}
		return -Integer.compare(o1.length(), o2.length());
	}
}