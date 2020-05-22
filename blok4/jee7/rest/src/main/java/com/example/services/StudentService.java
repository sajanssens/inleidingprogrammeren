package com.example.services;

import com.example.domain.Student;
import com.example.domain.Students;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful/*(passivationCapable = false)*/
public class StudentService implements Serializable {

    List<Student> students = new ArrayList<>();

    public boolean add(Student student) {
        return students.add(student);
    }

    public Students getAll() {
        return Students.of(students);
    }
}
