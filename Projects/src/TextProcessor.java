/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
October 17, 2017 
 */
public class TextProcessor {
	public static void main(String[] args) {
		System.out.println(isLowerCase('H'));
		System.out.println(toUpperCase('k'));
		System.out.println(toUpperCase("Interlake HS"));
	}
	public static boolean isLowerCase(char c) {
		if (c >= 'a' && c <= 'z') {
			return true;
		}
		return false;
	}
	public static char toUpperCase(char c) {
		if (c >= 'a' && c <= 'z') {
			c = (char) ('A' + (c-'a'));
			return c;
		}
		return c;
	}
	public static String toUpperCase(String s) {
		String x = "";
		for (int i = 0; i < s.length(); i++){
			char y = s.charAt(i);
			if (y >= 'a' && y <= 'z'){
				y = (char)('A' + (y - 'a'));
			}
			x = (String)(x + y);
		}
		return x;
	}
	
}
