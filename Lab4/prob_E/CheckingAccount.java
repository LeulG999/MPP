package Lab4.prob_E;

public class CheckingAccount extends Account {
    private double monthlyFee;

    public CheckingAccount(String accountId, double monthlyFee,double balance) {
        super(accountId, balance);
        this.monthlyFee = monthlyFee;
    }


    @Override
    public double computeUpdatedBalance() {
        return balance- monthlyFee;
    }
}
