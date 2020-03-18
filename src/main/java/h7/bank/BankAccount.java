package h7.bank;

import java.math.BigDecimal;

public class BankAccount {

    private String number;
    private BigDecimal balance;
    private double interestRate;

    public BankAccount(String number, BigDecimal balance, double interestRate) {
        this.number = number;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void withdraw(double amount) {
        if (balance.subtract(BigDecimal.valueOf(amount)).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance too low!");
        }
        this.balance = this.balance.subtract(BigDecimal.valueOf(amount));
    }

    public void deposit(double amount) {
        this.balance = this.balance.add(BigDecimal.valueOf(amount));
    }

    public BigDecimal calculateInterestOneYear() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
