package com.mysycorp.Backendjo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AchatDTO {
    private Long id;
    private Long userId;  // Référence à l'utilisateur qui a fait l'achat
    private List<TicketDTO> tickets;  // Liste des tickets associés à l'achat
    private LocalDateTime dateAchat;  // Date de l'achat

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }
}
