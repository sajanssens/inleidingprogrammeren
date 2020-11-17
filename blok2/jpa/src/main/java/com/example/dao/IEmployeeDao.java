package com.example.dao;

import com.example.domain.Employee;

import java.util.List;

public interface IEmployeeDao {

    void insert(Employee p);

    Employee select(long id);

    List<Employee> selectAll();

    List<Employee> selectAll(String name);

    List<Employee> selectAllNamed();

    void delete(Long id);

    Employee updateFirstname(int id, String name);

    Employee update(Employee p);

    List<Employee> findEmployees(boolean eager);

    List<Tuple> findEmployeeDepartments();

    List<Employee> findUsingCriteriaAPI(String name, String email);

}
