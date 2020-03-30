package h11.bank;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(long accountNumber, int balance, double rate) {
        super(accountNumber, balance, rate);
    }

    @Override
    public double interest() {
        return balance * rate * 1.20;
    }
}
