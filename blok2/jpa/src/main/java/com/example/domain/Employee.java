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
public class Employee extends AbstractEntity { // POJO

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String naam;

    private int age;
    private Gender gender;

    @Column(unique = true)
    @Email // @Pattern(regexp = EMAIL)
    private String emailaddress;

    @ManyToOne(cascade = MERGE)
    private Department bossOfDepartment; // owning side

    @OneToMany(cascade = MERGE, mappedBy = "owner") // passive side, bidirectioneel
    private List<Laptop> laptops = new ArrayList<>();

    public Employee() { }

    public Employee(String naam, int age) {
        this(naam, age, Gender.UNKNOWN);
    }

    public Employee(String naam, int age, Gender gender) {
        this.naam = naam;
        this.age = age;
        this.gender = gender;
    }

    @Override public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + naam + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setNaam(String naam) { this.naam = naam; }

    public void setBossOfDepartment(Department bossOfDepartment) { this.bossOfDepartment = bossOfDepartment; }

    public void addLaptop(Laptop lp) { this.laptops.add(lp); }
}
