package Lab4.prob_C;

import java.util.List;

class Commissioned extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(int empId, double commission, double baseSalary, List<Order> orders) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    double calcGrossPay(int month, int year) {
        double total = 0;
        for (Order o : orders) {
            if (o.getMonth() == month && o.getYear() == year) {
                total += o.getOrderAmount();
            }
        }
        return baseSalary + commission * total;
    }
}
