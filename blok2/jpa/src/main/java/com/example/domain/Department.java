package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department extends AbstractEntity {

    @Id @GeneratedValue
    private int id;

    private String name;

    public Department() { }

    public Department(String n) {this.name = n; }

}
