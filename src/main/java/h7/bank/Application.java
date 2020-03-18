package h7.bank;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        Bank rabo = new Bank("Rabobank");

        BankAccount ac1 = new BankAccount("NL23RABO0123456789", BigDecimal.valueOf(300d), 2.2d);
        BankAccount ac2 = new BankAccount("NL24RABO0987654321", BigDecimal.valueOf(400d), 1.2d);

        rabo.setAc1(ac1);
        rabo.setAc2(ac2);

        rabo.transfer(ac1, ac2, 100d);

        double ac1bal = rabo.getAc1().getBalance().doubleValue();
        double ac2bal = rabo.getAc2().getBalance().doubleValue();

        System.out.println(ac1bal);
        System.out.println(ac2bal);

    }
}
