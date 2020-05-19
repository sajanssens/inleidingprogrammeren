package com.example.resources;

import com.example.domain.Student;
import com.example.domain.Students;
import com.example.services.StudentService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.domain.Values.JANSSENS;
import static java.util.stream.Collectors.toList;

@Path("/students")
@Produces("application/json")
@SessionScoped // therefore this bean needs to be serializable
public class StudentsResource implements Serializable {

    List<Student> students = new ArrayList<>();

    @Inject
    private StudentService studentService;

    @GET
    @Path("{id}")
    public Student get(@PathParam("id") int id) {
        return JANSSENS;
    }

    @GET
    @Path("q")
    public List<Student> getByQ(@QueryParam("lastname") String lastname) {
        return filterStudentsBy(lastname);
    }

    @GET
    @Path("name/{lastname}")
    public Students getByName(@QueryParam("lastname") String lastname) {
        return Students.of(filterStudentsBy(lastname));
    }

    @GET
    public Students getAll() {
        // return students; // doesn't make sense; rest is stateless
        return studentService.getAll();
    }

    @POST
    public Student post(Student student) {
        // students.add(student); // doesn't make sense; rest is stateless
        if (studentService.add(student)) {
            return student;
        }
        throw new RuntimeException("Student not added.");
    }

    private List<Student> filterStudentsBy(@QueryParam("lastname") String lastname) {
        return students.stream()
                .filter(s -> lastname.equals(s.getLastname()))
                .collect(toList());
    }

}
