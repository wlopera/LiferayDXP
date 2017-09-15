package com.exmple.controller;

import com.example.api.TestApi;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jodd.json.JsonSerializer;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/test")
public class ExampleRestController extends Application {

    // ------------------------
    // Rest Application Config
    // ------------------------

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    // ------------------------
    // Public Methods
    // ------------------------

    /*
     * Private attributes
     */
    private TestApi api;

    // ------------------------
    // Public Methods
    // ------------------------

    @GET
    @Path("hello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello(@PathParam("name") String name) {

        System.out.println("sayHello controller");
        return new JsonSerializer().serialize(api.sayHello(name));
    }

    // ------------------------
    // OSGI References
    // ------------------------

    @Reference
    public void setApi(TestApi api) {
        this.api = api;
    }

}
