package com.example.resources;

import com.example.domain.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/students")
public class StudentsResource {

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Student get(@PathParam("id") int id) {
        return Student.builder().lastname("Janssens").yearOfBirth(id).build();
    }

}
