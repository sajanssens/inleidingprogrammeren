package com.example.dependencyinverted.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

// High level module
public class Sender {

    // Satisfies:
    // 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
    private final List<Sendable> sendables = new ArrayList<>();

    public Sender(Sendable... s) { sendables.addAll(Arrays.asList(s)); }

    public void addSendable(Sendable s) {
        // Satisfies:
        // 2. Abstractions should not depend on details. Details should depend on abstractions.

        // Inversion of control: new is gone. Let someone else supply the object(s)
        sendables.add(s);
    }

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
}
