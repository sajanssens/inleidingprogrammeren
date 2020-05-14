package com.example.dependent.low;

import static com.example.cdi.util.Values.OK;

// Low level module
public class Email {

    public String run() {
        System.out.println("sending email.....");
        // ....
        return OK;
    }

}
