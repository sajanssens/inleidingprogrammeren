package h7.bank;

import java.util.ArrayList;
import java.util.List;

public class BankMetList {

    private String name;
    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public BankMetList(String name) {
        this.name = name;
    }

    public void addBankAccount(BankAccount ac) {
        bankAccounts.add(ac);
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        try {
            from.withdraw(amount);
            to.deposit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Transactie afgebroken: " + e.getMessage());
        }
    }

    public double totalAmount() {
        double sum = 0;
        for (BankAccount ac : bankAccounts) {
            sum += ac.getBalance().doubleValue();
        }
        return sum;
    }

    public void printAccountsInfo() {
        for (BankAccount ac : bankAccounts) {
            double interest = ac.calculateInterestOneYear().doubleValue();
            System.out.println("Account " + ac.getNumber() + " has interest: " + interest);
        }
    }

}
