package com.example.services;

import com.example.dao.EmployeeDao;
import com.example.domain.Employee;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static com.example.domain.Values.*;

public class EmployeeService {

    @Inject private EmployeeDao dao;

    public Employee get(long id) {
        return dao.select(id);
        // return BRAM;
    }

    public Employee add(Employee e) {
        dao.insert(e);
        return dao.update(e);
        // return e;
    }

    public List<Employee> get() {
        return Arrays.asList(BRAM, MIEKE, NIEK, GIJS);
    }
}
