package h10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

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

        int i1 = Employee.geefMaarWat();
        int i2 = TempEmployee.geefMaarWat();
        assertThat(i1).isEqualTo(42);
        assertThat(i2).isEqualTo(43);

        Employee emp = new TempEmployee("Piet", 50);
        emp.geefMaarWat(); // hiding
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

    @Test
    void testCutSalary() {
        PermEmployee maartje = new PermEmployee("Maartje", 10);
        maartje.setSalary(2500);

        assertThrows(RuntimeException.class, () -> maartje.cutSalary(90));
    }
}