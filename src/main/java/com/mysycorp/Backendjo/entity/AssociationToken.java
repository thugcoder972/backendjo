package com.mysycorp.Backendjo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssociationToken {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "token_user_id")
    private TokenUser tokenUser;

    @ManyToOne
    @JoinColumn(name = "token_ticket_id")
    private TokenTicket tokenTicket;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TokenUser getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(TokenUser tokenUser) {
        this.tokenUser = tokenUser;
    }

    public TokenTicket getTokenTicket() {
        return tokenTicket;
    }

    public void setTokenTicket(TokenTicket tokenTicket) {
        this.tokenTicket = tokenTicket;
    }
}

