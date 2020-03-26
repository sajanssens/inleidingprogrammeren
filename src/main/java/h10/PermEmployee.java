package h10;

public class PermEmployee extends Employee implements SalaryRaisable {
    private int position;

    public PermEmployee(String name, int position) {
        super(name);
        this.position = position;
    }

    @Override
    public long getSalary() {
        return this.salary * position;
    }

    public void raiseSalary(int amount) {
        this.salary += amount;
    }

}
