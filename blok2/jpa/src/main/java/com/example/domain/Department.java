package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department extends AbstractEntity {

    // collection valued

    @ManyToMany(mappedBy = "worksAtDepartments") // BiDi, passive side
    private List<Employee> workers = new ArrayList<>();

    @Id @GeneratedValue
    private int id;

    private String name;

    public Department() { }

    public Department(String n) {this.name = n; }

    public Department add(Employee employee) {
        this.workers.add(employee);
        return this;
    }


}
