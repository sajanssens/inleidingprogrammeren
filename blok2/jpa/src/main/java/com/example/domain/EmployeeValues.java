package com.example.domain;

public final class EmployeeValues {
    private EmployeeValues() {}

    public static final String EMAIL = "\\A[a-z0-9!#$%&'*+/=?^_‘{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_‘{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";
    public static final Employee BRAM = new Employee("Bram", 40);
    public static final Employee MIEKE = new Employee("Mieke", 40);
    public static final Employee NIEK = new Employee("Niek", 10);
    public static final Employee GIJS = new Employee("Gijs", 6);
}
