import java.util.Scanner;

public class Fraction {
	private int n;
	private int d;
	
	// constructors
	public static void main(String[] args) {
		Scanner y = new Scanner(System.in);
		System.out.println("Enter 1st fraction numerator");
		while(!y.hasNextInt()) {
			System.out.println("Enter a valid input!");
			y.nextLine();
		}
		int a = y.nextInt();
		System.out.println("Enter 1st fraction denominator");
		while(!y.hasNextInt()) {
			System.out.println("Enter a valid input!");
			y.nextLine();
		}
		int b = y.nextInt();
		Fraction fraction = new Fraction(a,b);
		
		System.out.println("Enter 2nd fraction numerator");
		while(!y.hasNextInt()) {
			System.out.println("Enter a valid input!");
			y.nextLine();
		}
		a = y.nextInt();
		System.out.println("Enter 2nd fraction denominator");
		while(!y.hasNextInt()) {
			System.out.println("Enter a valid input!");
			y.nextLine();
		}
		b = y.nextInt();
		
		System.out.println("Addition");
		System.out.println(fraction.add(new Fraction(a,b)));
		System.out.println("Subtraction");
		System.out.println(fraction.subtract(new Fraction(a,b)));
		System.out.println("Multiplication");
		System.out.println(fraction.multiply(new Fraction(a,b)));
		System.out.println("Division");
		System.out.println(fraction.divide(new Fraction(a,b)));
	}
	public Fraction(int n, int d) {
		if(d == 0) throw new IllegalArgumentException();
		
		this.n = n;
		this.d = d;
		
		reduce();
	}
	
	public Fraction(int n) {
		this(n, 1);
	}
	
	public Fraction(String s) {
		n = 0;
		d = 0;
		
		int sign = 1;
		int i = 0;
		
		// handle the sign
		if(s.charAt(0) - '0' < 0) {
			i++;
			if(s.charAt(0) == '-') sign = -1;
		}
		
		// initialize the numerator
		while(s.charAt(i) != '/') {
			n *= 10;
			n += s.charAt(i) - '0';
			i++;
		}
		
		n *= sign;
		
		i++;
		
		// initialize the denominator
		while(i < s.length()) {
			d *= 10;
			d += s.charAt(i) - '0';
			i++;
		}
		
		if(d == 0) throw new IllegalArgumentException();
		
		reduce();
	}
	
	// getters and setters
	public int getNumerator() {
		return n;
	}
	
	public int getDenominator() {
		return d;
	}
	
	public void setNumerator(int n) {
		this.n = n;
	}
	
	public void setDenominator(int d) {
		this.d = d;
	}
	
	// returns the sum between this and another Fraction
	public Fraction add(Fraction other) {
		Fraction result = new Fraction(n * other.d + other.n * d, d  * other.d);
		result.reduce();
		return result;		
	}
	
	// returns the difference between this and another Fraction
	public Fraction subtract(Fraction other) {
		Fraction result = new Fraction(n * other.d - other.n * d, d  * other.d);
		result.reduce();
		return result;	
	}
		
	// returns the product between this and another Fraction
	public Fraction multiply(Fraction other) {
		Fraction result = new Fraction(n * other.n, d * other.d);
		result.reduce();
		return result;
	}
	
	// returns the quotient between this and another Fraction
	public Fraction divide(Fraction other) {
		if(other.n == 0) throw new IllegalArgumentException();
		
		Fraction result = new Fraction(n * other.d, d * other.n);
		result.reduce();
		return result;
	}
	
	// String representation in the form of an improper fraction
	public String toString() {
		if(n % d == 0) return Integer.toString(n/d);
		return n + "/" + d;
	}
	
	// String representation in the form of a mixed fraction
	public String toMixedNumberString() {
		if(n == 0) return "0";
		if(n % d == 0) return Integer.toString(n/d);
		if(n / d == 0) return n%d + "/" + d;
		return n/d + "_" + Math.abs(n%d) + "/" + d;
	}
	
	// compares the fraction to another fraction; returns a number < 0 if smaller, 0 if equal, and > 0 if larger.
	public int compareTo(Fraction other) {
		return n * other.d - other.n * d;
	}
	
	// simplifies the fraction
	public void reduce() {
		int gcd = gcd(n, d);
		
		if(gcd == -1) {
			d = 1;
			return;
		}
		
		if(d < 0) {
			n *= -1;
			d *= -1;
		}
		
		n /= gcd;
		d /= gcd;
	}
	
	// finds the largest common divisor between two integers, where a > b
	public int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		
		// ensure that a > b
		if(a < b) {
			int t = a;
			a = b;
			b = t;
		}
		
		if(b == 0) return -1;
		
		// keep dividing by the remainder
		while(true) {
			if(a % b == 0) return b;
			a %= b;
			if(b % a == 0) return a;
			b %= a;
		}
	}
}