package com.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.example.domain.Values.EMAIL;

@Entity
@Table(name = "Person")
@NamedQuery(name = "findAll", query = "select p from Persoon p")
public class Persoon { // POJO

    @Id @GeneratedValue
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String naam;

    private int age;
    private Gender gender;

    @Column(unique = true)
    @Pattern(regexp = EMAIL)
    private String emailaddress;

    public Persoon() {
    }

    public Persoon(String naam, int age) {
        this(naam, age, Gender.UNKNOWN);
    }

    public Persoon(String naam, int age, Gender gender) {
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
}
