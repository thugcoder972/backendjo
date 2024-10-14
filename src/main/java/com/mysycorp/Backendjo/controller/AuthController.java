package com.mysycorp.Backendjo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysycorp.Backendjo.dto.AuthRequest;
import com.mysycorp.Backendjo.entity.User;
import com.mysycorp.Backendjo.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
        try {
            User registeredUser = authService.register(authRequest.getUsername(), authRequest.getPassword());
            return ResponseEntity.ok("Utilisateur enregistré avec succès : " + registeredUser.getUsername());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            User authenticatedUser = authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
            return ResponseEntity.ok("Connexion réussie pour : " + authenticatedUser.getUsername());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
