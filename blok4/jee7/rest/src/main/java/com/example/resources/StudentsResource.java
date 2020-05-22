package com.example.resources;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("students")
@Api("students") // ??
public class StudentsResource {

    // List<Student> students = new ArrayList<>();

    // @Inject
    // private StudentService studentService;

    @GET @Path("greeter")
    public String helloGreeter() { return "Goedemorgen in Utrecht."; }

    // @GET
    // @Path("{id}")
    // public Student get(@PathParam("id") int id) {
    //     return STUDENTS.get(id);
    // }
    //
    // @GET
    // @Path("q")
    // public List<Student> getByQ(@QueryParam("lastname") String lastname) {
    //     return filterStudentsBy(lastname);
    // }

    // @GET
    // @Path("name/{lastname}")
    // public Students getByName(@QueryParam("lastname") String lastname) {
    //     return Students.of(filterStudentsBy(lastname));
    // }

    // @POST
    // public Student post(Student student) {
    //     students.add(student); // doesn't make sense; rest is stateless
    //     return student;
    //     // if (studentService.add(student)) {
    //     //     return student;
    //     // }
    //     // throw new RuntimeException("Student not added.");
    // }

    // @GET
    // public Students getAll() {
    //     return Students.of(students);
    //     // return studentService.getAll();
    // }
    //
    // private List<Student> filterStudentsBy(String lastname) {
    //     return students.stream()
    //             .filter(s -> lastname.equals(s.getLastname()))
    //             .collect(toList());
    // }

}
