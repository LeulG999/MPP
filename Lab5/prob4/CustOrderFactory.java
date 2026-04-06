package Lab5.prob4;


import java.time.LocalDate;

public class CustOrderFactory {

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Order createOrder(Customer cust, LocalDate date) {
        Order order = new Order(date);
        cust.addOrder(order);
        return order;
    }

    public static void addItem(Order order, String name) {
        Item item=new Item(name);
        order.addItem(item);
    }
}
