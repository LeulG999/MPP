package Lab4.prob_C;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Hourly(1, 20.0, 40);
        Employee e2 = new Salaried(2, 4000.0);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(101, 4, 2026, 5000));
        orders.add(new Order(102, 4, 2026, 3000));
        orders.add(new Order(103, 3, 2026, 2000));

        Employee e3 = new Commissioned(3, 0.1, 2000, orders);

        Paycheck p1 = e1.calcCompensation(4, 2026);
        Paycheck p2 = e2.calcCompensation(4, 2026);
        Paycheck p3 = e3.calcCompensation(4, 2026);

        System.out.println(p1.getNetPay());
        System.out.println(p2.getNetPay());
        System.out.println(p3.getNetPay());
    }
}
