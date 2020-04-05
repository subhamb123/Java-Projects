/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
January 2, 2018
 */
public class RandomPractice {
	private int numerator;
	private int denominator;
	public RandomPractice(int numerator, int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("Division by zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}
	public RandomPractice(int wholeNumber) {
		this(wholeNumber,1);
	}
	public RandomPractice(String improper) {
		
	}
	public String toString(){
		if(numerator % denominator == 0) {
			return Integer.toString(numerator/denominator);
		}
		return numerator + "/" + denominator;
	}
	public String toMixedNumberString() {
		if(numerator % denominator == 0) {
			return Integer.toString(numerator/denominator);
		}
		if(numerator / denominator == 0) {
			return numerator%denominator + "/" + denominator;
		}
		if(numerator == 0) {
			return "0";
		}
		return numerator/denominator + "_" + Math.abs(numerator%denominator) + "/" + denominator;
	}
	public int compareTo(Fraction other) {
		return numerator * other.denominator - other.numerator * denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public Fraction add(Fraction fraction) {
		Fraction result = new Fraction(numerator * fraction.denominator + fraction.numerator * denominator, denominator  * fraction.denominator);
		result.reduce();
		return result;
	}
	public Fraction subtract(Fraction fraction) {
		Fraction result = new Fraction(numerator * fraction.denominator - fraction.numerator * denominator, denominator  * fraction.denominator);
		result.reduce();
		return result;
	}
	public Fraction multiply(Fraction fraction) {
		Fraction result = new Fraction(numerator * fraction.numerator, denominator  * fraction.denominator);
		result.reduce();
		return result;
	}
	public Fraction divide(Fraction fraction) {
		if (fraction.denominator == 0) {
			throw new IllegalArgumentException("Division by zero");
		}
		Fraction result = new Fraction(numerator * fraction.denominator, denominator  * fraction.numerator);
		result.reduce();
		return result;
	}
	public void reduce() {
		int high;
		int number=1;
		if (Math.abs(numerator)<Math.abs(denominator)) {
			high=Math.abs(numerator);
		} else {
			high=Math.abs(denominator);
		}
		for (int i=1;i<=high;i++) {
			if (numerator%i==0 && denominator%i==0) {
				number=i;
			}
		}
		this.numerator/=number;
		this.denominator/=number;
	}
	
}