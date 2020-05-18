package com.example.resources;

import com.example.domain.Employee;
import com.example.services.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/employees")
public class EmployeeResource {

    @Inject private EmployeeService employeeService;

    @GET
    @Path("{id}")
    public Employee get(@PathParam("id") long id) {
        return employeeService.get(id);
    }

    @POST
    public Employee post(Employee e) {
        return employeeService.add(e);
    }

}
