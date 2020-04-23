package com.example.domain;

import javax.persistence.Entity;

@Entity
public class Car extends AbstractEntity {

    private String brand;

    public Car() { }

    public Car(String brand) { this.brand = brand; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }
}


