package h10;

public class TempEmployee extends Employee {
    private int numberOfHours;

    public TempEmployee(String name, int numberOfHours) {
        super(name);
        this.numberOfHours = numberOfHours;
    }

    @Override
    public long getSalary() {
        return numberOfHours / 40 * salary * 10;
    }

    @Override
    public String toString() {
        return super.toString() +
                " TempEmployee{" +
                "numberOfHours=" + numberOfHours +
                '}';
    }

    public static int geefMaarWat() {
        return 43;
    }
}
