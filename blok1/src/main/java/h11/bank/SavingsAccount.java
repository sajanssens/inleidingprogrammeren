package h11.bank;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(long accountNumber, int balance, double rate) {
        super(accountNumber, balance, rate);
    }

    @Override
    public double interest() {
        return balance * rate * 1.0;
    }
}
