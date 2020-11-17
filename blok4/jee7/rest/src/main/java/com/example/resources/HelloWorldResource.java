package com.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public Response helloworld() {
        return Response.ok().entity("HOI").build();
    }

    @GET
    @Path("/ok")
    public Response ok() {
        return Response.ok().build();
    }

    @GET
    @Path("/error")
    public Response get() {
        return Response.serverError().entity("Something went terribly wrong!").build();
    }

}
