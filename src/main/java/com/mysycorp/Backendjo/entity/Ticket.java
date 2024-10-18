package com.mysycorp.Backendjo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seat;
    private boolean used;  // Utilisez 'used' pour indiquer si le ticket est utilisé
    private Double price;  // Ajout d'un attribut pour le prix

    @ManyToOne
    @JoinColumn(name = "epreuve_sportive_id")
    private EpreuveSportive epreuveSportive;

    @ManyToOne
    @JoinColumn(name = "achat_id")
    private Achat achat;

    @ManyToOne
    @JoinColumn(name = "tarif_id")
    private Tarif tarif; // Relation avec Tarif

    @OneToOne
    @JoinColumn(name = "token_ticket_id")
    private TokenTicket tokenTicket;
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean isUsed() {
        return used;  // Retournez la variable 'used'
    }

    public void setUsed(boolean used) {
        this.used = used;  // Mettez à jour la variable 'used'
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Tarif getTarif() {
        return tarif; // Getter pour le tarif
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif; // Setter pour le tarif
    }

    // Méthodes pour le prix
    public Double getPrice() {
        return price; // Getter pour le prix
    }

    public void setPrice(Double price) {
        this.price = price; // Setter pour le prix
    }
}
