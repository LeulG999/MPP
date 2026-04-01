package prob2B;
public class OrderLine {
    private Order order;
    public OrderLine(Order order){
        this.order=order;
    }

    @Override
    public String toString() {
        return "OrderLine";

    }

    public Order getOrder(){
        return order;
    }
}
