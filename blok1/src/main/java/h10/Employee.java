package h10;

public abstract class Employee {

    protected String name;
    protected int salary;

    public Employee(String name) {
        this.name = name;
    }

    public abstract long getSalary();

    public void setSalary(int salary) { this.salary = salary; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    public static int geefMaarWat() {
        return 42;
    }
}
