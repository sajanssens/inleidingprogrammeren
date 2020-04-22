package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Laptop extends AbstractEntity {

    private String brand;

    @ManyToOne // bidirectioneel
    private Employee owner;

    public Laptop() { }

    public Laptop(String b) { brand = b; }

}
