package com.example.dao;

import com.example.domain.Employee;
import com.example.domain.Phone;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static com.example.util.Util.h2;
import static com.example.util.Util.logger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeDaoIT {

    private final Logger log = logger(getClass());
    private final EmployeeDao dao = new EmployeeDao(h2());

    @Test
    void whenEmployeeIsInsertedItGetsAnId() {
        dao.insert(new Employee("A", 1));
        assertThat(dao.selectAll()).allMatch(e -> e.getId() != null);
    }

    @Test
    void whenEmployeesAreFoundTheirPhonesAreLazilyLoaded() {
        Employee a = new Employee("A", 1);
        a.addPhone(new Phone("1"));
        a.addPhone(new Phone("2"));

        Employee b = new Employee("B", 2);
        b.addPhone(new Phone("3"));
        b.addPhone(new Phone("4"));

        dao.insert(a);
        dao.insert(b);

        for (Employee employee : dao.findEmployees(false)) {
            log(employee);
            employee.getPhones().forEach(p -> log(p.getNumber()));
        }

        for (Employee employee : dao.findEmployees(true)) {
            log(employee);
            employee.getPhones().forEach(p -> log(p.getNumber()));
        }
    }

    @Test
    void whenEmployeeIsSelectedItsPhonesAreNotLoaded() {
        Employee a = new Employee("A", 1);
        a.addPhone(new Phone("1"));
        a.addPhone(new Phone("2"));
        dao.insert(a);

        Employee e = dao.select(1);

        assertThrows(LazyInitializationException.class, () -> e.getPhones().get(0));
    }

    private void log(Object o) { log.info(o + ""); }
}