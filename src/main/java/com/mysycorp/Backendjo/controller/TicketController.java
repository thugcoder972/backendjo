package com.mysycorp.Backendjo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysycorp.Backendjo.entity.Ticket;
import com.mysycorp.Backendjo.repository.TicketRepository;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    // Récupérer tous les tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Récupérer un ticket par ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouveau ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Mettre à jour un ticket existant
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setSeat(ticketDetails.getSeat());
                    ticket.setIsUsed(ticketDetails.getIsUsed());
                    ticket.setAchat(ticketDetails.getAchat()); // S'assurer que l'entité Achat est gérée
                    // On peut aussi mettre à jour d'autres attributs si nécessaire
                    Ticket updatedTicket = ticketRepository.save(ticket);
                    return ResponseEntity.ok(updatedTicket);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un ticket par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTicket(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticketRepository.delete(ticket);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
