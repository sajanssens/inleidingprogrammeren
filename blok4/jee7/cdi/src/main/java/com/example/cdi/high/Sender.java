package com.example.cdi.high;

import com.example.cdi.util.EM;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

// High level module
@Dependent
public class Sender {

    // Satisfies:
    // 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
    private final List<Sendable> sendables = new ArrayList<>();

    public Sender() { }

    public String sendAll() {
        return sendables.stream()
                .map(Sendable::send)
                .collect(joining(", "));
    }

    public <S extends Sendable> String send(Class<S> sendable) {
        return sendables.stream()
                .filter(s -> s.getClass().equals(sendable))
                .map(Sendable::send)
                .collect(joining(", "));
    }

    // Dependency Injection -----------------------------

    // 1. field injection
    // @Inject @Named("Email")  /*@EM*/
    Sendable sendable;

    // 2. constructor injection
    @Inject
    public Sender(@EM Sendable s) { addSendable(s); }

    // 3. setter/property injection
    // @Inject
    // public void setSendable(@EM Sendable s) { addSendable(s); }

    public Sender(Sendable... s) { sendables.addAll(Arrays.asList(s)); }

    public void addSendable(Sendable s) {
        // Satisfies:
        // 2. Abstractions should not depend on details. Details should depend on abstractions.

        // Inversion of control: new is gone. Let someone else supply the object(s)
        sendables.add(s);
    }
}
