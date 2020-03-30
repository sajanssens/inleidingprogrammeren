package h11.bank;

public class AccountFactory {

    public enum AccountType {CHECKING, RAINBOW, SAVINGS}

    private AccountFactory() { }

    public static BankAccount createAccount(AccountType accountType, long nr, int bal, double rate) {
        switch (accountType) {
            case CHECKING:
                return new CheckingAccount(nr, bal, rate);
            case SAVINGS:
                return new SavingsAccount(nr, bal, rate);
            case RAINBOW:
                return new RainbowAccount(nr, bal, rate);
            default:
                return null;
        }
    }
}