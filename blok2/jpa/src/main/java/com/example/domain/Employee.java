package com.example.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@NamedQuery(name = "findAll", query = "select e from Employee e")
public class Employee extends AbstractEntity { // POJO, "Java bean"

    @NotNull               // Bean validation API
    @Size(max = 100)       // Bean validation API
    @Column(name = "name") // JPA
    private String naam;

    // @Basic
    private int age;

    @Enumerated(value = STRING)
    private Gender gender;

    @Column(unique = true)
    @Email // @Pattern(regexp = EMAIL) // Bean validation API
    private String emailAddress;

    @Temporal(value = DATE)
    private Date date = new Date();

    // Better: use LocalDate or LocalDateTime
    private LocalDate dateOfBirth = LocalDate.of(1979, 8, 22);

    // CLOB Character large object
    // BLOB Binary large object
    @Lob
    @Basic(fetch = LAZY)
    private String resume;

    @Lob
    private byte[] image;

    // Relations ***********************************************************

    // ----------------- Single Valued relationships (..ToOne)

    @OneToOne(cascade = ALL)  // unidirectional
    private Car leaseCar;

    @ManyToOne(cascade = MERGE/*, fetch = LAZY*/)          // unidirectional
    @JoinColumn(name = "departmentId")
    private Department bossOfDepartment; // owning side

    @ManyToOne(cascade = {PERSIST, MERGE}) // bidirectional
    private ParkingSpace parkingSpace;

    // ----------------- Collection valued relationships (..ToMany)

    @OneToMany(cascade = {PERSIST, MERGE})  // unidirectional: additional table emp_phone is created
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(cascade = MERGE, mappedBy = "owner")   // bidirectional
    private List<Laptop> laptops = new ArrayList<>(); // this is the passive side

    @ManyToMany(cascade = ALL) // bidirectional
    private Set<Department> worksAtDepartments;

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

    public void setLeaseCar(Car leaseCar) { this.leaseCar = leaseCar; }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
        parkingSpace.addEmployee(this);
    }

    public void addPhone(Phone p) {
        this.phones.add(p);
    }

    public void addDepartment(Department d) {
        this.worksAtDepartments.add(d);
        d.add(this); // this is the owning side, so we make it responsible for managing the (BiDi) relationship.
    }
}
