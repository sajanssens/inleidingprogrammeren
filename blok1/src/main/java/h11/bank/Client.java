package h11.bank;

public class Client {

    public static void main(String[] args) {
        // House h = new House();

        // BankAccount account1 = AccountFactory.createAccount(SAVINGS, 11111111, 100, 1.03);
        // BankAccount account2 = AccountFactory.createAccount(CHECKING, 22222222, 200, 1.02);
        // BankAccount account3 = AccountFactory.createAccount(RAINBOW, 3333333, 300, 1.02);

        BankAccount account1 = new SavingsAccount(11111111, 100, 1.03);
        BankAccount account2 = new CheckingAccount(22222222, 200, 1.02);
        BankAccount account3 = new RainbowAccount(3333333, 300, 1.02);

        double interest1 = account1.interest();
        double interest2 = account2.interest();
        double interest3 = account3.interest();
    }
}
