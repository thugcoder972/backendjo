package com.mysycorp.Backendjo.dto;

public class AuthRequest {
    private String username;
    private String password;
    private String email; // Ajout du champ email

    // Getters et setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email; // Getter pour l'email
    }

    public void setEmail(String email) {
        this.email = email; // Setter pour l'email
    }
}


