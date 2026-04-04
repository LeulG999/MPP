package Lab4.prob_C;

abstract class Employee {
    private int empId;

    public Employee(int empId) {
        this.empId = empId;
    }

    public Paycheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        double fica = 0.23 * grossPay;
        double state = 0.05 * grossPay;
        double local = 0.01 * grossPay;
        double medicare = 0.03 * grossPay;
        double socialSecurity = 0.075 * grossPay;

        return new Paycheck(grossPay, fica, state, local, medicare, socialSecurity);
    }

    abstract double calcGrossPay(int month, int year);
}
