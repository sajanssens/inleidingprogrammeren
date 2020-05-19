package com.example.domain;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@NoArgsConstructor
public class Students {

    List<Student> students = new ArrayList<>();

    private Students(List<Student> students) { this.students.addAll(students); }

    public static Students of(List<Student> collect) { return new Students(collect); }

    // For JAXB (Java bean standard)
    public List<Student> getStudents() { return students; }
}