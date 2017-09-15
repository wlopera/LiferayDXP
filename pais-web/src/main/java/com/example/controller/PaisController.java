package com.example.controller;

import com.example.api.PaisApi;
import com.example.model.GreetingsWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
@ApplicationPath("/pais")
public class PaisController extends Application {

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
    private PaisApi api; 

    // ------------------------
    // Public Methods
    // ------------------------

    @GET
    @Path("getPaises/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaises() {

        System.out.println("##=> PaisController request: ");
        
        List<String> data = new ArrayList<String>();
        data.add("Argentina");
        data.add("Brasil");
        data.add("Colombia");
        data.add("Panama");
        data.add("Venezuela");
        data.add("USA");
        data.add("Italia");
        data.add("Francia");
        data.add("China");
        data.add("Japon");
 
        System.out.println(new JsonSerializer().serialize(data));
        return new JsonSerializer().serialize(data);
    }

    // ------------------------
    // OSGI References
    // ------------------------

    @Reference
    public void setApi(PaisApi api) {
        this.api = api;
    }

}
