package com.example.dependent.high;

// The Dependency Inversion principle states that:
// 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
// 2. Abstractions should not depend on details. Details should depend on abstractions.

import com.example.dependent.low.Email;
import com.example.dependent.low.Sms;

// High level module
public class Sender {

    // violation of 1.; hard to maintain and extend
    private Email email;
    private Sms sms;

    public Sender() {
        // Instantiate objects myself.
        // Not possible to change these instances, so:
        //  - hard to maintain and extend;
        //  - not reusable as lib class
        //  - tight coupling, high risk of breaking this high level module
        this.email = new Email(); // new is evil...?
        this.sms = new Sms();
    }

    public String sendAll() {
        // violation of 2.; hard to maintain and extend
        return email.run() + ", " + sms.stuur();
    }
}
