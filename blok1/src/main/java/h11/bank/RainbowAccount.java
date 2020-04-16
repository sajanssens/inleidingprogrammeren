package h11.bank;

public class RainbowAccount extends BankAccount {
    public RainbowAccount(long accountNumber, int balance, double rate) {
        super(accountNumber, balance, rate);
    }

    @Override
    public double interest() {
        return balance * rate * 1.4;
    }
}
