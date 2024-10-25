package com.mysycorp.Backendjo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@GetMapping("/api/hello")  // URL de l'API
    public String hello() {
        return "Hello from Spring Boot!";  // Réponse de l'API
    }
}
