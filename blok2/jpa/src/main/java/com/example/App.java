package com.example;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

    public static void main(String[] args) {
        // CDI < 2.0 (JEE7)
        // Container is hard coded to be Weld.
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        // EmployeeService employeeService = new EmployeeService(); // oude stijl
        EmployeeService employeeService = container.select(EmployeeService.class).get();
        employeeService.start();
    }

}
