package h11.bank;

public abstract class BankAccount {
    protected long accountNumber;
    protected int balance;
    protected double rate;

    public BankAccount(long accountNumber, int balance, double rate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.rate = rate;
    }

    public abstract double interest();
}
