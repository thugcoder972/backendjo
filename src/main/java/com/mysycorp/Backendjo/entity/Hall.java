package com.mysycorp.Backendjo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Relation avec ComplexeSportif
    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id") // Colonne pour établir la relation
    private ComplexeSportif complexeSportif;

    // Relation avec EpreuveSportive
    @OneToMany(mappedBy = "hall")
    private List<EpreuveSportive> epreuvesSportives; // Ajout de la relation avec EpreuveSportive

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

    public List<EpreuveSportive> getEpreuvesSportives() {
        return epreuvesSportives;
    }

    public void setEpreuvesSportives(List<EpreuveSportive> epreuvesSportives) {
        this.epreuvesSportives = epreuvesSportives;
    }
}
