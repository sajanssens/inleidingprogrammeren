package com.example.domain;

import java.util.Arrays;
import java.util.List;

public class Values {

    public static Student JANSSENS = Student.builder().lastname("Janssens").yearOfBirth(1979).build();
    public static Student KLAASSEN = Student.builder().lastname("Klaassen").yearOfBirth(1985).build();
    public static Student PIETERSEN = Student.builder().lastname("Pietersen").yearOfBirth(1931).build();

    public static List<Student> STUDENTS = Arrays.asList(JANSSENS, KLAASSEN, PIETERSEN);

}
