package com.pais.controller;

import com.pais.api.PaisApi;
import com.pais.model.Pais;

import java.util.Collections;
import java.util.Iterator;
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
    
    @GET
    @Path("reiniciarPaises/")
    @Produces(MediaType.APPLICATION_JSON)
    public String reiniciarPaises() {
    	paises = paisApi.getPaises();
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
    	pais.setId(String.valueOf(paises.size()+1));
    	paises.add(pais);
    	System.out.println("##=> Pais a crear: " + paises);
    	return new JsonSerializer().serialize(paises);
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
    	for (Pais paisTemp:paises) {
    		if (pais.getId().equals(paisTemp.getId())) {
    			paisTemp.setNombre(pais.getNombre());
    			paisTemp.setCapital(pais.getCapital());
    			paisTemp.setMoneda(pais.getMoneda());
    			paisTemp.setIdioma(pais.getIdioma());
    			break;
    		}
    	}
    	return new JsonSerializer().serialize(paises);
    }

 // ------------------------
    // Public Methods
    // ------------------------
    @POST
    @Path("borrarPais/")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
    public String borrarPais(Pais pais) {
    	getPaises(); 
    	Iterator<Pais> iterator = paises.iterator();
    	while (iterator.hasNext()) {
    	   Pais itPais = iterator.next();
    	   if (itPais.getId().equals(pais.getId())) {
    		   iterator.remove();
    		   break;
    	   }
    	}
    	return new JsonSerializer().serialize(paises);
    }

    // ------------------------
    // OSGI References
    // ------------------------

    @Reference
    public void setPaisApi(PaisApi paisApi) {
        this.paisApi = paisApi;
    }

}
