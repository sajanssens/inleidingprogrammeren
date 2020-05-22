package com.example.resources;

import com.example.resources.StudentsResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class StudentsResourceIT {

    @ArquillianResource
    private URL deploymentURL;
    private String studentsResource;

    @Before
    public void setup() {
        studentsResource = deploymentURL + "resources/students";
    }

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(StudentsResource.class.getPackage())
                ;
    }

    @Test
    public void getGreeterReturnsCorrectMessage() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/greeter")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertEquals("Goedemorgen in Utrecht.", message);
    }

}