import java.text.*;
public class Item {      // private fields for Item class.
	String name;
	double price;
	int bulkQuantity;
	double bulkPrice;
	boolean isBulk;
	NumberFormat nf = NumberFormat.getCurrencyInstance();   // Turn price into string.
	public Item(String n, double p) {
		name = n;
		price = p;
		bulkPrice = p;        //Sets constructor
		bulkQuantity = 0;
		isBulk = false;
		if (p < 0) {
			throw new IllegalArgumentException("Illegal Error.");
		}
	}
	public Item(String n, double p, int bQ, double bP) {
		name = n;
		price = p;
		bulkQuantity = bQ;
		bulkPrice = bP;
		isBulk = true;
		if (p < 0 || bQ < 0 || bP < 0) {
			throw new IllegalArgumentException("Can't be negative");
		}
	}
	public double priceFor(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Can't be negative");
		}
		double toReturn = price * quantity;       // Returns the price for an item.
		if (isBulk && quantity != 0) {
			toReturn = (bulkQuantity % quantity) * price + (quantity - (bulkQuantity % quantity) * bulkPrice);
		}
		return toReturn;
	}
	public String toString() {
		String toReturn = name + ", " + nf.format(price);
		if (isBulk) {
			toReturn += " (" + bulkQuantity + " for " + nf.format(bulkPrice) + ")";   // Display
		}
		return toReturn;
	}
	
}
