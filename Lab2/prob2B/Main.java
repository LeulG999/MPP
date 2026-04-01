package prob2B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
       Order o1=new Order(1);
       OrderLine ol1=new OrderLine(o1);
       o1.addLine(ol1);
        Order o2=new Order(2);
        OrderLine ol2=new OrderLine(o2);
        o2.addLine(ol2);
        Order o3=new Order(3);
        OrderLine ol3=new OrderLine(o3);
        o3.addLine(ol3);
        Order o4=new Order(4);
        OrderLine ol4=new OrderLine(o4);
        o4.addLine(ol4);
        Order o5=new Order(5);
        OrderLine ol5=new OrderLine(o5);
        o5.addLine(ol5);
     List<Order> orders=Arrays.asList(o1,o2,o3,o4,o5);

        System.out.println(orders);
    }
}
