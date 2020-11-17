package com.example.domain;

import javax.persistence.Entity;

@Entity
public class TemporaryEmployee extends Employee {
    private int level;

    public TemporaryEmployee() {}

    public TemporaryEmployee(String naam, int age, int level) {
        super(naam, age);
        this.level = level;
    }
}
