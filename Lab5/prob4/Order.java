package Lab5.prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
	private LocalDate orderDate;
	private List<Item> items;
	
	//use a factory method
	 Order(LocalDate orderDate) {
		this.orderDate = orderDate;
		items = new ArrayList<Item>();	
	}
	public void addItem(Item name){
		items.add(name);
	}
	@Override
	public String toString() {
		return orderDate + ": " + 
	              items.toString();
	}
}
