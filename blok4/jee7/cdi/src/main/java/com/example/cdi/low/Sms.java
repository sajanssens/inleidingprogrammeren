package com.example.cdi.low;

import static com.example.cdi.util.Values.OK;

// @Alternative
public class Sms /*implements Sendable */{

    private String stuur() {
        System.out.println("sending sms.....");
        // ....
        return OK;
    }

    // @Override
    public String send() {
        return stuur();
    }
}
