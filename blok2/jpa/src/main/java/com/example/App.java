package com.example;

import com.example.dao.EmployeeDao;
import com.example.domain.Department;
import com.example.domain.Employee;
import com.example.domain.Laptop;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static com.example.util.Util.logger;

public class App {

    private final Logger log = logger(getClass());

    // application managed persistence context
    private EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        log("Starting app...");

        EmployeeDao employeeDao = new EmployeeDao(em);
        Employee bram = new Employee("Bram", 42);
        // bram.setEmailaddress("bram@test.com");

        employeeDao.insert(bram);

        Employee employee = employeeDao.select(1);
        log(employee);

        employeeDao.selectAll().forEach(this::log);

        List<Employee> michaels = employeeDao.selectAll("Michael");
        michaels.forEach(this::log);

        employeeDao.delete(3);
        employeeDao.selectAll().forEach(this::log);

        Employee nino = employeeDao.updateFirstname(1, "Gert Jan");
        employeeDao.selectAll().forEach(this::log);

        nino.setNaam("Nino");
        Employee updated = employeeDao.update(nino);

        log(isManaged(nino));
        log(isManaged(updated));

        employeeDao.selectAllNamed().forEach(this::log);

        nino.setBossOfDepartment(new Department("Nergens"));
        updated = employeeDao.update(nino);

        nino.addLaptop(new Laptop("DELL"));
        updated = employeeDao.update(nino);
    }

    private void log(Object o) { log.info(o + ""); }

    private boolean isManaged(Employee p) { return em.contains(p); }
}