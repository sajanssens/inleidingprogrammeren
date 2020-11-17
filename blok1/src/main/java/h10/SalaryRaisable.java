package h10;

public interface SalaryRaisable {

    public abstract void raiseSalary(int amount);

    public static final int amount = 10;

    // since java 8
    default long cutSalary(int amount) {
        // doe iets defaults met amount
        throw new RuntimeException("Not implemented...");
    }
}
