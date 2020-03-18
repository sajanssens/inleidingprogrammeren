package h7.bank;

public class Bank {

    private String name;

    private BankAccount ac1;
    private BankAccount ac2;

    public Bank(String name) {
        this.name = name;
    }

    public void setAc1(BankAccount ac1) {
        this.ac1 = ac1;
    }

    public void setAc2(BankAccount ac2) {
        this.ac2 = ac2;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        try {
            from.withdraw(amount);
            to.deposit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Transactie afgebroken: " + e.getMessage());
        }
    }

    public BankAccount getAc1() {
        return ac1;
    }

    public BankAccount getAc2() {
        return ac2;
    }
}
