package com.example.dependent.low;

import static com.example.cdi.util.Values.OK;

// Low level module
public class Sms {

    public String stuur() {
        System.out.println("sending sms.....");
        // ....
        return OK;
    }
}
