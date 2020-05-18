package com.example.services;

import com.example.dao.EmployeeDao;
import com.example.domain.Employee;

import javax.inject.Inject;

public class EmployeeService {

    @Inject private EmployeeDao dao;

    public Employee get(long id) {
        return dao.select(id);
    }

    public Employee add(Employee e) {
        dao.insert(e);
        return dao.update(e);
    }
}
