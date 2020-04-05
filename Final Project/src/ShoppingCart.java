import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
	boolean discount; //Fields
	double total;
	public ShoppingCart() {
		list = new ArrayList<ItemOrder>(); //Constructor
	}
	
	public double getTotal() {
		double total=0.0;
		for (ItemOrder item : list) { //Total of the amount of the same items
			total+=item.getPrice();
		}
		if (this.discount) {
			return total*0.9; //Qualify for discount
		}
		return total;
	}
	public void setDiscount(boolean selected) {
		discount = selected; //Sets discount
		
	}
	public void add(ItemOrder order) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getItem().toString().equals(order.getItem().toString())) { //Adds item to the order
				total -= list.get(i).getPrice();
				list.remove(i);
				break;
			}
		}
		
		list.add(order);
		total += order.getPrice();
	}
}
