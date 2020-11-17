package com.example;

import com.example.dao.EmployeeDao;
import com.example.domain.Employee;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class App2 {

    @Inject
    private Logger log;

    // application managed persistence context
    @Inject /*@MySQL*/
    private EntityManager em;

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