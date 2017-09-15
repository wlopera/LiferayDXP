package com.example.service;

import com.example.api.PaisApi;
import com.example.model.GreetingsWrapper;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = PaisApi.class)
public class PaisService implements PaisApi {

    // ------------------------
    // Public Methods
    // ------------------------

    @Override
    public GreetingsWrapper sayHello(String arg0) {

    	System.out.println("##=> PaisServiceImpl: "+ arg0);

        GreetingsWrapper g = new GreetingsWrapper();

        if (null == arg0) {

            g.setGreeting("Just Hello");
            return g;
        }

        g.setGreeting("Hello " + arg0 + "!");
        return g;

    }
}
