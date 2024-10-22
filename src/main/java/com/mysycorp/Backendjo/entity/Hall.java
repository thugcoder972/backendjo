package com.mysycorp.Backendjo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import tech.ailef.snapadmin.external.annotations.DisplayName;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private int numberPlace;

    // Relation ManyToOne avec ComplexeSportif : un hall appartient à un complexe sportif
    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id", nullable = false)
    private ComplexeSportif complexeSportif;

    // Relation OneToMany avec EpreuveSportive : un hall peut accueillir plusieurs épreuves sportives
    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<EpreuveSportive> epreuves = new HashSet<>();
    // Relation OneToMany avec Ticket : un hall peut avoir plusieurs tickets
    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @DisplayName //annotation pour afficher le nom dans l'interface admin
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    public ComplexeSportif getComplexeSportif() {
        return complexeSportif;
    }

    public void setComplexeSportif(ComplexeSportif complexeSportif) {
        this.complexeSportif = complexeSportif;
    }

    public Set<EpreuveSportive> getEpreuves() {
        return epreuves;
    }

    public void setEpreuves(Set<EpreuveSportive> epreuves) {
        this.epreuves = epreuves;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}

