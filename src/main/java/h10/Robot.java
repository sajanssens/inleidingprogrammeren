package h10;

public class Robot implements SalaryRaisable {

    private int salary = 100;

    @Override
    public void raiseSalary(int amount) {
        salary += amount + 20;
    }

    public int getSalary() {
        return salary;
    }
}
