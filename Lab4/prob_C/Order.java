package Lab4.prob_C;

class Order {
    private int orderNo;
    private int month;
    private int year;
    private double orderAmount;

    public Order(int orderNo, int month, int year, double orderAmount) {
        this.orderNo = orderNo;
        this.month = month;
        this.year = year;
        this.orderAmount = orderAmount;
    }

    public int getMonth() { return month; }
    public int getYear() { return year; }
    public double getOrderAmount() { return orderAmount; }
}
