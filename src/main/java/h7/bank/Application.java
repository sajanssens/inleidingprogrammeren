package h7.bank;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        BankMetList rabo = new BankMetList("Rabobank");

        BankAccount ac1 = new BankAccount("NL23RABO0123456789", BigDecimal.valueOf(300d), 2.2d);
        BankAccount ac2 = new BankAccount("NL24RABO0987654321", BigDecimal.valueOf(400d), 1.2d);
        BankAccount ac3 = new BankAccount("NL24RABO0532765431", BigDecimal.valueOf(600d), 1.2d);

        rabo.addBankAccount(ac1);
        rabo.addBankAccount(ac2);
        rabo.addBankAccount(ac3);

        rabo.transfer(ac1, ac2, 100d);

        double ac1bal = ac1.getBalance().doubleValue();
        double ac2bal = ac2.getBalance().doubleValue();

        System.out.println(ac1bal);
        System.out.println(ac2bal);

        double interest = ac1.calculateInterestOneYear().doubleValue();
        System.out.println(interest);

        rabo.printAccountsInfo();

        double totalAmount = rabo.totalAmount();
        System.out.println(totalAmount);
    }
}
