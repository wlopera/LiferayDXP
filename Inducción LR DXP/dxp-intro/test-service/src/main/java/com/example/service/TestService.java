package com.example.service;

import com.example.api.TestApi;
import com.example.model.GreetingsWrapper;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = TestApi.class)
public class TestService implements TestApi {

    // ------------------------
    // Public Methods
    // ------------------------

    @Override
    public GreetingsWrapper sayHello(String arg0) {

        System.out.println("sayHello service");

        GreetingsWrapper g = new GreetingsWrapper();

        if (null == arg0) {

            g.setGreeting("Just Hello");
            return g;
        }

        g.setGreeting("Hello " + arg0 + "!");
        return g;

    }
}
