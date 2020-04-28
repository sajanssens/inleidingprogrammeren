package com.example.dao;

import com.example.domain.Employee;
import org.junit.jupiter.api.Test;

import static com.example.util.Util.h2;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeDaoIT {

    private EmployeeDao dao = new EmployeeDao(h2());

    @Test
    void whenInsertEmployeeItGetsAnId() {
        dao.insert(new Employee("A", 1));
        assertThat(dao.selectAll()).allMatch(e -> e.getId() != null);
    }
}