package com.example.dependencyinverted.low;

import com.example.dependencyinverted.high.Sendable;

import static com.example.cdi.util.Values.OK;

// Low level module, depends on high level Sendable
public class Sms implements Sendable {

    private String stuur() {
        System.out.println("sending sms.....");
        // ....
        return OK;
    }

    @Override
    public String send() {
        return stuur();
    }
}
