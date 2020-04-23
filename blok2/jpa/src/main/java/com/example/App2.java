package com.example;

import com.example.dao.EmployeeDao;
import com.example.domain.Employee;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static com.example.util.Util.logger;

public class App2 {

    private final Logger log = logger(getClass());

    // application managed persistence context
    private EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

    public static void main(String[] args) {
        new App2().start();
    }

    private void start() {
        EmployeeDao employeeDao = new EmployeeDao(em);

        Employee employee = employeeDao.select(1);
        log(employee);
    }

    private void log(Object o) { log.info(o + ""); }

}