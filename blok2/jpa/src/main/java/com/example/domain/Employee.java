package com.example.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;

@Entity
@NamedQuery(name = "findAll", query = "select e from Employee e")
public class Employee extends AbstractEntity { // POJO, "Java bean"

    @NotNull               // Bean validation API
    @Size(max = 100)       // Bean validation API
    @Column(name = "name") // JPA
    private String naam;

    private int age;
    private Gender gender;

    @Column(unique = true)
    @Email // @Pattern(regexp = EMAIL) // Bean validation API
    private String emailAddress;

    // Relations ***********************************************************

    // ----------------- Single Valued relationships

    // @OneToOne  // unidirectional

    @ManyToOne(cascade = MERGE)          // unidirectional
    @JoinColumn(name = "departmentId")
    private Department bossOfDepartment; // owning side

    // @ManyToOne // bidirectional

    // ----------------- Collection valued relationships

    // @OneToMany  unidi

    @OneToMany(cascade = MERGE, mappedBy = "owner")   // bidirectional
    private List<Laptop> laptops = new ArrayList<>(); // this is the passive side

    // @ManyToMany //bidirectional

    // *********************************************************************

    public Employee() { }

    public Employee(String naam, int age) {
        this(naam, age, Gender.UNKNOWN);
    }

    public Employee(String naam, int age, Gender gender) {
        this.naam = naam;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + naam + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setNaam(String naam) { this.naam = naam; }

    public void setBossOfDepartment(Department bossOfDepartment) { this.bossOfDepartment = bossOfDepartment; }

    public void addLaptop(Laptop lp) {
        this.laptops.add(lp); // this --> zet iets
        lp.setOwner(this);    // iets --> zet this
    }
}
