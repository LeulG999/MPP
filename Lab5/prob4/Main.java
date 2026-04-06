package Lab5.prob4;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Customer cust = CustOrderFactory.createCustomer("Bob");

		Order order = CustOrderFactory.createOrder(cust, LocalDate.now());
		CustOrderFactory.addItem(order, "Shirt");
		CustOrderFactory.addItem(order, "Laptop");

		order = CustOrderFactory.createOrder(cust, LocalDate.now());
		CustOrderFactory.addItem(order, "Pants");
		CustOrderFactory.addItem(order, "Knife set");

		System.out.println(cust.getOrders());
	}
}

		
