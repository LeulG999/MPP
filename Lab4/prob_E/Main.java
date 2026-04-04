package Lab4.prob_E;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Account[] someCheckingAccounts = new CheckingAccount[2];
        someCheckingAccounts[0] = new CheckingAccount("001-001", 85.00, 500);
        someCheckingAccounts[1] = new CheckingAccount("002-003", 43.00, 400);
        Account[] someSavingsAccounts = new SavingsAccount[3];
        someSavingsAccounts[0] = new SavingsAccount("001-005", 0.03, 200);
        someSavingsAccounts[1] = new SavingsAccount("01-001", 0.03, 200);
        someSavingsAccounts[2] = new SavingsAccount("06-002", 0.04, 600);


        Employee e1 = new Employee("Leul");
        Employee e2 = new Employee("Tsige");
        Employee e3 = new Employee("Jerry");

        e1.addAccount(someCheckingAccounts[0]);
        e1.addAccount(someSavingsAccounts[0]);
        e2.addAccount(someCheckingAccounts[1]);
        e2.addAccount(someSavingsAccounts[1]);
        e3.addAccount(someSavingsAccounts[2]);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        System.out.println(Admin.computeUpdatedBalanceSum(employees));


    }
}
