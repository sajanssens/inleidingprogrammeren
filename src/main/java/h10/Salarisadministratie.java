package h10;

public class Salarisadministratie {

    public void printSalary(Employee e) {
        System.out.println(e.getSalary());
    }

    public void raiseSalary(SalaryRaisable sr){
        sr.raiseSalary(100);
    }

}
