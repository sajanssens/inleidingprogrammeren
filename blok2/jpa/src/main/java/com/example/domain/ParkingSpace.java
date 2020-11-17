package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ParkingSpace extends AbstractEntity {

    private int number;

    public ParkingSpace() {
    }

    public ParkingSpace(int number) {
        this.number = number;
    }

    @OneToMany(mappedBy = "parkingSpace") // Bidi, passive side; mappedBy is needed
    private Collection<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        this.employees.add(e);
        // null.methode()
    }
}
