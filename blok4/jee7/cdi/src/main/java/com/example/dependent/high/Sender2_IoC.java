package com.example.dependent.high;

// The Dependency Inversion principle states that:
// 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
// 2. Abstractions should not depend on details. Details should depend on abstractions.

import com.example.dependent.low.Sms;
import com.example.dependent.low.Email;

// High level module
public class Sender2_IoC {

    // violation of 1.; hard to maintain and extend
    private Email email; // DI via field injection
    private Sms sms;

    // DI via ctor
    // public Sender2_IoC(Email email, Sms sms) {
    //     this.email = email;
    //     this.sms = sms;
    // }

    // Inversion of control: new is gone. Let someone else supply the object(s)
    // DI via setter
    public void setEmail(Email email) {
        this.email = email;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public String sendAll() {
        // violation of 2.; hard to maintain and extend
        return email.run() + ", " + sms.stuur();
    }
}
