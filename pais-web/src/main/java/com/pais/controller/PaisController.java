package com.pais.controller;

import com.pais.api.PaisApi;
import com.pais.model.Pais;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jodd.json.JsonSerializer;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/pais")
public class PaisController extends Application {
	private List<Pais> paises;

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
    private PaisApi paisApi; 

    // ------------------------´
    // Public Methods
    // ------------------------

    @GET
    @Path("getPaises/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaises() {
    	if (paises == null || paises.size() == 0) {
    		paises = paisApi.getPaises();
    	}
    	System.out.println("..................Paises: " + paises);
        return new JsonSerializer().serialize(paises);
    }

    // ------------------------
    // Public Methods
    // ------------------------
    @POST
    @Path("agregarPais/")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
    public String agregarPais(Pais pais) {
    	getPaises(); 
    	System.out.println("##=> Pais a crear: " + pais);
//    	for (Pais pais: paises){
//    		if(pais.getNombre().startsWith(name)) {
//    			return new JsonSerializer().serialize(pais);
//    		}
//    	}
    	return null;
    }
    
 // ------------------------
    // Public Methods
    // ------------------------
    @POST
    @Path("modificarPais/")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
    public String modificarPais(Pais pais) {
    	getPaises(); 
    	System.out.println("##=> Pais a modificar: " + pais);
//    	for (Pais pais: paises){
//    		if(pais.getNombre().startsWith(name)) {
//    			return new JsonSerializer().serialize(pais);
//    		}
//    	}
    	return null;
    }
    
    // ------------------------
    // OSGI References
    // ------------------------

    @Reference
    public void setPaisApi(PaisApi paisApi) {
        this.paisApi = paisApi;
    }

}
