package Lab4.prob_E;

import java.util.ArrayList;
import java.util.List;

public class Employee
{
    private  String name;
    public List<Account> accountList = new ArrayList<>();

    public Employee(String name)
    {
        this.name = name;
    }

    public void addAccount(Account acc)
    {
        accountList.add(acc);
    }

    public double computeUpdatedBalanceSum()
    {
        double salarySum = 0;
        for(Account account : accountList)
        {
            salarySum = account.computeUpdatedBalance();
        }
        return salarySum;
    }
}

