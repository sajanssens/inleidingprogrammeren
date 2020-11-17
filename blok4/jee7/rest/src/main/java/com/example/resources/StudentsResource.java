package com.example.resources;

import com.example.domain.Student;
import com.example.domain.Students;
import com.example.services.StudentService;
import io.swagger.annotations.Api;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.io.Serializable;

@Path("students")
@Api("students")
@Produces("application/json")
@SessionScoped // therefore this bean needs to be serializable // REST SHOULD BE STATELESS, DONT TRY THIS IN PRODUCTION!!!
public class StudentsResource implements Serializable {

    @Inject
    private StudentService studentService;

    @GET @Path("{id}") // read
    public Student get(@PathParam("id") int id) {
        return studentService.get(id);
    }

    @GET @Path("q") // read
    public Students get(@QueryParam("lastname") String lastname) {
        return studentService.find(lastname);
    }

    @GET // read
    public Students getAll() { return studentService.getAll(); }

    @DELETE // delete
    @Path("{id}")
    public Student delete(@PathParam("id") int id) {
        return studentService.remove(id);
    }

    @POST
    public Student post(Student student) {
        if (studentService.add(student)) {
            return student;
        }
        throw new RuntimeException("Student not added.");
    }

}
