package com.example;

import com.example.dao.EmployeeDao;
import com.example.domain.*;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.util.Util.logger;
import static com.example.util.Util.mysql;

public class App {

    private final Logger log = logger(getClass());

    // application managed persistence context
    private EntityManager em = mysql();

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

        List<Employee> brams = employeeDao.selectAll("Bram");
        brams.forEach(this::log);

        Employee p = new Employee("", 1);
        employeeDao.insert(p);
        employeeDao.delete(p.getId());
        employeeDao.selectAll().forEach(this::log);

        Employee nino = employeeDao.updateFirstname(1, "Gert Jan");
        employeeDao.selectAll().forEach(this::log);

        nino.setNaam("Nino");
        Employee updated = employeeDao.update(nino);

        employeeDao.selectAllNamed().forEach(this::log);

        updated.setBossOfDepartment(new Department("Nergens"));
        updated = employeeDao.update(updated);

        updated.addLaptop(new Laptop("DELL"));
        updated = employeeDao.update(updated);

        updated.setLeaseCar(new Car("Skoda"));
        employeeDao.update(updated);

        updated.setParkingSpace(new ParkingSpace(123));
        employeeDao.update(updated);

        updated.addPhone(new Phone("+316123456789"));
        employeeDao.update(updated);

        updated.addDepartment(new Department("Douane"));
        updated.addDepartment(new Department("Toeslagen"));
        employeeDao.update(updated);

        employeeDao.findEmployeeDepartments().forEach(this::log);

        List<Employee> ninos = employeeDao.findUsingCriteriaAPI("Nino", "");
        ninos.forEach(this::log);

        log(isManaged(updated));
        em.clear();
        log(isManaged(updated));
        em.close();
    }

    private void log(Object o) { log.info(o + ""); }

    private boolean isManaged(Employee p) { return em.contains(p); }

}