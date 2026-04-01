package prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNum;
    private List<OrderLine> lines;

    public Order(int orderNum){
        this.orderNum=orderNum;
        this.lines=new ArrayList<>();
    }
    public void addLine(OrderLine line){
        lines.add(line);
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", lines=" + lines +
                '}';
    }
}
