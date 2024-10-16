package com.mysycorp.Backendjo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Hall {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //relation 
    @ManyToOne
    private ComplexeSportif complexeSportif;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComplexeSportif getComplexeSportif() {
        return complexeSportif;
    }

    public void setComplexeSportif(ComplexeSportif complexeSportif) {
        this.complexeSportif = complexeSportif;
    }

}
