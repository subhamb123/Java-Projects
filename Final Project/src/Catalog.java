import java.util.ArrayList;

public class Catalog {
	ArrayList<Item> items = new ArrayList<Item>(); //Private Field
	String name = "";
	public Catalog(String n) {
		name = n;
		items = new ArrayList<Item>(); //Constructor
	}
	public void add(Item item) { //Adds item
		items.add(item);
	}
	public int size() {//Return size
		return items.size();
	}
	public Item get(int index) { //Gets place of item
		return items.get(index);
	}
	public String getName() { //Gets name of item
		return name;
	}
}
