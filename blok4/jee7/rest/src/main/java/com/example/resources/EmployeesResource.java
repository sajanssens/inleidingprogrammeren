package com.example.resources;

import com.example.domain.Employee;
import com.example.services.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/employees")
public class EmployeesResource {

    @Inject private EmployeeService employeeService;

    @GET
    @Produces("application/json")
    public List<Employee> getAll() {
        return employeeService.get();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Employee get(@PathParam("id") long id) {
        return employeeService.get(id);
    }

    @POST
    public Employee post(Employee e) {
        return employeeService.add(e);
    }

}
