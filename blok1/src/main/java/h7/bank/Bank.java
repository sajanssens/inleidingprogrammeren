package h7.bank;

public class Bank {

    private String name;

    private BankAccount[] bankAccounts = new BankAccount[100];
    private int aantalAccounts = 0;

    public Bank(String name) {
        this.name = name;
    }

    public void addBankAccount(BankAccount ac) {
        bankAccounts[aantalAccounts] = ac;
        aantalAccounts++;
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
        for (int i = 0; i < aantalAccounts; i++) {
            BankAccount ac = bankAccounts[i];
            sum += ac.getBalance().doubleValue();
        }
        return sum;
    }

    public void printAccountsInfo() {
        for (int i = 0; i < aantalAccounts; i++) {
            BankAccount ac = bankAccounts[i];
            double interest = ac.calculateInterestOneYear().doubleValue();
            System.out.println("Account " + ac.getNumber() + " has interest: " + interest);
        }
    }
}
