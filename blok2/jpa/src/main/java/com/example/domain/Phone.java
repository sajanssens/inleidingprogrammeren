package com.example.domain;

import javax.persistence.Entity;

@Entity
public class Phone extends AbstractEntity {

    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
