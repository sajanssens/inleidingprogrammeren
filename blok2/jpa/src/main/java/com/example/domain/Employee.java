package com.example.domain;

import com.example.util.BooleanTFConverter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;
import static javax.persistence.TemporalType.DATE;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
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
    private Date dateOfBirth = new Date();

    // Better: use LocalDate or LocalDateTime
    // Will be converted to time by LocalDateTimeAttributeConverter
    // @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime timeOfBirth = LocalDateTime.of(1979, 8, 22, 0, 1, 2, 3);

    @Lob // CLOB Character large object
    @Basic(fetch = LAZY)
    private String resume;

    @Lob // BLOB Binary large object
    private byte[] image;

    @Convert(converter = BooleanTFConverter.class)
    private boolean hasDriversLicence = true;

    @Embedded
    private Address address;

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

    @OneToMany(cascade = {PERSIST, MERGE}, fetch = LAZY)  // unidirectional: additional table emp_phone is created
    private final List<Phone> phones = new ArrayList<>();

    @OneToMany(cascade = MERGE, mappedBy = "owner")   // bidirectional
    private List<Laptop> laptops = new ArrayList<>(); // this is the passive side

    @ManyToMany(cascade = ALL) // bidirectional; "owner"
    @JoinTable(name = "departmentemployees",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> worksAtDepartments = new HashSet<>();

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

    public List<Phone> getPhones() { return phones; }
}
