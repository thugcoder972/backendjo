package com.mysycorp.Backendjo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "achats")
public class Achat {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    
    // Relation ManyToOne avec Tarif : un achat est associé à un tarif
    @ManyToOne
    @JoinColumn(name = "tarif_id") // Associe un achat à un tarif
    private Tarif tarif;
    
    // Relation ManyToOne avec User : un achat est fait par un utilisateur
    @ManyToOne
    @JoinColumn(name = "user_id", nullable= false)
    private User user;

    // Relation OneToMany avec Ticket : un achat peut avoir plusieurs tickets
    @OneToMany(mappedBy = "achat")
    private List<Ticket> tickets = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }  

}
