package com.mysycorp.Backendjo.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startTimeEpreuve;

    // Relation ManyToOne avec Achat : un ticket est associé à un achat
    @ManyToOne
    @JoinColumn(name = "achat_id")
    private Achat achat;

    // Relation ManyToOne avec Administration : un ticket est géré par une administration
    @ManyToOne
    @JoinColumn(name = "administration_id", nullable = false)
    private Administration administration;

    // Relation ManyToOne avec ComplexeSportif : un ticket est associé à un complexe sportive
    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id", nullable = false)
    private ComplexeSportif complexeSportif;

    // Relation ManyToOne avec EpreuveSportive : un ticket est associé à une épreuve sportive
    @ManyToOne
    @JoinColumn(name = "epreuve_sportive_id", nullable = false)
    private EpreuveSportive epreuveSportive;

    // Relation ManyToOne avec Hall : un ticket est lié à un hall
    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    // Relation ManyToMany avec Tarif : un ticket peut avoir plusieurs tarifs
    @ManyToMany
    @JoinTable(
        name = "ticket_tarif",
        joinColumns = @JoinColumn(name = "ticket_id"),
        inverseJoinColumns = @JoinColumn(name = "tarif_id")
    )
    private Set<Tarif> tarifs = new HashSet<>();

    @Column(nullable = false)
    private int remainingPlaces;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTimeEpreuve() {
        return startTimeEpreuve;
    }

    public void setStartTimeEpreuve(LocalDateTime startTimeEpreuve) {
        this.startTimeEpreuve = startTimeEpreuve;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Administration getAdministration() {
        return administration;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }

    public ComplexeSportif getComplexeSportif() {
        return complexeSportif;
    }

    public void setComplexeSportif(ComplexeSportif complexeSportif) {
        this.complexeSportif = complexeSportif;
    }

    public EpreuveSportive getEpreuveSportive() {
        return epreuveSportive;
    }

    public void setEpreuveSportive(EpreuveSportive epreuveSportive) {
        this.epreuveSportive = epreuveSportive;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Tarif> getTarifs() {
        return tarifs;
    }

    public void setTarifs(Set<Tarif> tarifs) {
        this.tarifs = tarifs;
    }

    public int getRemainingPlaces() {
        return remainingPlaces;
    }

    public void setRemainingPlaces(int remainingPlaces) {
        this.remainingPlaces = remainingPlaces;
    }

    public Object getSeat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSeat'");
    }

    public void setSeat(Object seat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSeat'");
    }

    public Object getIsUsed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIsUsed'");
    }

    public void setIsUsed(Object isUsed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIsUsed'");
    }
}
