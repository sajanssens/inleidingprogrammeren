package h10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SalarisadministratieTest {

    Salarisadministratie target = new Salarisadministratie();

    @Test
    void test() {
        final int i = 42;

        Employee e;
        // e = new Employee("Bram");
        // target.printSalary(e);

        e = new TempEmployee("Piet", 50);
        target.printSalary(e);

        e = new PermEmployee("Maartje", 10);
        target.printSalary(e);

        Employee.geefMaarWat();
        TempEmployee.geefMaarWat();

        Employee emp = new TempEmployee("Piet", 50);
        emp.geefMaarWat();
    }

    @Test
    void testRaiseSalary() {
        PermEmployee maartje = new PermEmployee("Maartje", 10);
        maartje.setSalary(2500);

        long salary = maartje.getSalary();
        target.raiseSalary(maartje);
        long salaryRaised = maartje.getSalary();

        long raise = salaryRaised - salary;
        assertThat(raise).isEqualTo(1000);

        Robot robot = new Robot();
        target.raiseSalary(robot);
        int robotSalary = robot.getSalary();
        assertThat(robotSalary).isEqualTo(220);
    }
}