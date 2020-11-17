package com.example.dao;

public class Tuple<T, V> {
    public final T a;
    public final V b;

    public Tuple(T a, V b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Tuple(" + a + ", " + b + ')';
    }
}
