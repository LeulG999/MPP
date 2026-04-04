package Lab4.prob_C;

class Salaried extends Employee {
    private double salary;

    public Salaried(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    double calcGrossPay(int month, int year) {
        return salary;
    }
}
