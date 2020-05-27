package com.example;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class App extends Application {

    // public Set<Class<?>> getClasses() {
    //     return new HashSet<>(Arrays.asList(
    //             StudentsResource.class,
    //             HelloWorldResource.class,
    //             // add more resources here...
    //             ApieeService.class
    //     ));
    // }

}