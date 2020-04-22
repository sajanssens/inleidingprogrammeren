package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Laptop extends AbstractEntity {

    private String brand;

    @ManyToOne // bidirectioneel
    private Employee owner;

    public Laptop() { }

    public Laptop(String b) { brand = b; }

    public void setOwner(Employee owner) { this.owner = owner; }
}
