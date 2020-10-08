package com.example.cdi.low;

import com.example.cdi.high.Sendable;
import com.example.cdi.util.EM;

import static com.example.cdi.util.Values.OK;

@EM
public class Email implements Sendable {

    private String run() {
        System.out.println("sending email.....");
        // ....
        return OK;
    }

    @Override
    public String send() {
        return run();
    }
}
