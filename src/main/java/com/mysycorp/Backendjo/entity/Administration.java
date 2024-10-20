package com.mysycorp.Backendjo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Administration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nameAdministration;

    @Column(nullable = false, length = 255)
    private String adresseAdministration;

    // Relation OneToMany avec ComplexeSportif : une administration peut gérer plusieurs complexes sportifs
    @OneToMany(mappedBy = "administration", cascade = CascadeType.ALL)
    private Set<ComplexeSportif> complexes = new HashSet<>();
    // Relation OneToMany avec Ticket : une administration peut gérer plusieurs tickets
    @OneToMany(mappedBy = "administration", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAdministration() {
        return nameAdministration;
    }

    public void setNameAdministration(String nameAdministration) {
        this.nameAdministration = nameAdministration;
    }

    public String getAdresseAdministration() {
        return adresseAdministration;
    }

    public void setAdresseAdministration(String adresseAdministration) {
        this.adresseAdministration = adresseAdministration;
    }

    public Set<ComplexeSportif> getComplexes() {
        return complexes;
    }

    public void setComplexes(Set<ComplexeSportif> complexes) {
        this.complexes = complexes;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    public void setUser(User userDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }

    public Object getRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }

    public void setRole(Object role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRole'");
    }
}
