public class ItemOrder {
	Item itemOrder;
	int quantity = 0; //Private fields
	int price = 0;
	public ItemOrder(Item item, int q) {
		itemOrder = item; //Constructor
		quantity = q;
	}
	public double getPrice() {
	    return itemOrder.priceFor(quantity); //Returns price
	}
	public Item getItem() {
		return itemOrder; //Returns Item
	}
}
