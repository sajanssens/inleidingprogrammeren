package com.example.resources;

import com.example.domain.Student;
import com.example.domain.Students;

import javax.ws.rs.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.domain.Values.STUDENTS;
import static java.util.stream.Collectors.toList;

@Path("/students")
@Produces("application/json")
// @SessionScoped // therefore this bean needs to be serializable
public class StudentsResource implements Serializable {

    List<Student> students = new ArrayList<>();

    // @Inject
    // private StudentService studentService;

    @GET
    @Path("{id}")
    public Student get(@PathParam("id") int id) {
        return STUDENTS.get(id);
    }

    @GET
    @Path("q")
    public List<Student> getByQ(@QueryParam("lastname") String lastname) {
        return filterStudentsBy(lastname);
    }

    // @GET
    // @Path("name/{lastname}")
    // public Students getByName(@QueryParam("lastname") String lastname) {
    //     return Students.of(filterStudentsBy(lastname));
    // }

    @POST
    public Student post(Student student) {
        students.add(student); // doesn't make sense; rest is stateless
        return student;
        // if (studentService.add(student)) {
        //     return student;
        // }
        // throw new RuntimeException("Student not added.");
    }

    @GET
    public Students getAll() {
        return Students.of(students); // doesn't make sense; rest is stateless
        // return studentService.getAll();
    }

    private List<Student> filterStudentsBy(String lastname) {
        return students.stream()
                .filter(s -> lastname.equals(s.getLastname()))
                .collect(toList());
    }

}
