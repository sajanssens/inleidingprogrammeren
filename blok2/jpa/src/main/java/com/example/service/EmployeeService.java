package com.example.service;

import com.example.dao.IEmployeeDao;
import com.example.domain.*;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeService {

    @Inject
    private Logger log;

    // application (weld) managed persistence context
    @Inject /*@MySQL*/
    private EntityManager em;

    @Inject
    private IEmployeeDao employeeDao;

    public void start() {
        log("Starting app...");

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

        TemporaryEmployee temporaryEmployee = new TemporaryEmployee("Tempie", 56, 5);
        employeeDao.insert(temporaryEmployee);
        employeeDao.selectAll().forEach(this::log); // includes sub classes

        log(isManaged(updated));
        em.clear();
        log(isManaged(updated));
        em.close();
    }

    private void log(Object o) { log.info(o + ""); }

    private boolean isManaged(Employee p) { return em.contains(p); }

}