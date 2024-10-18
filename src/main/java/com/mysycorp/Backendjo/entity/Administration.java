package com.mysycorp.Backendjo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import tech.ailef.snapadmin.external.annotations.DisplayName;

@Entity
public class Administration {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String role;

    @OneToMany(mappedBy = "administration")
    private List<ComplexeSportif> complexesSportifs;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private User user;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @DisplayName
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
