package com.example.api;

import com.example.model.GreetingsWrapper;

public interface PaisApi {
    
    public GreetingsWrapper sayHello(String name);
    
}