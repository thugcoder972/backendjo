package com.mysycorp.Backendjo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    // Relation avec EpreuveSportive (facultatif)
    @ManyToOne
    private EpreuveSportive epreuveSportive;

    // Relation avec Ticket
    @ManyToOne
    private Ticket ticket;

    // Relation avec Achat (si besoin)
    @ManyToOne
    private Achat achat;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public EpreuveSportive getEpreuveSportive() {
        return epreuveSportive;
    }

    public void setEpreuveSportive(EpreuveSportive epreuveSportive) {
        this.epreuveSportive = epreuveSportive;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
}
