package com.mysycorp.Backendjo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysycorp.Backendjo.dto.TicketDTO;
import com.mysycorp.Backendjo.entity.Ticket;
import com.mysycorp.Backendjo.mapper.TicketMapper;
import com.mysycorp.Backendjo.repository.TicketRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    @Transactional(readOnly = true)
    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(ticketMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Ticket not found with id " + id));
        return ticketMapper.toDTO(ticket);
    }

    @Transactional
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(savedTicket);
    }

    @Transactional
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Ticket existingTicket = ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));

        // Mettre à jour les informations du ticket
        existingTicket.setSeat(ticketDTO.getSeat());
        existingTicket.setUsed(ticketDTO.isUsed());  // Mise à jour de isUsed

        // En cas de mise à jour d'autres champs, on pourrait ajouter la logique ici

        Ticket updatedTicket = ticketRepository.save(existingTicket);
        return ticketMapper.toDTO(updatedTicket);
    }

    @Transactional
    public TicketDTO markTicketAsUsed(Long id) {
        Ticket existingTicket = ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));

        // Marquer le ticket comme utilisé
        existingTicket.setUsed(true); // Assurez-vous que setUsed est disponible dans l'entité Ticket

        Ticket updatedTicket = ticketRepository.save(existingTicket);
        return ticketMapper.toDTO(updatedTicket);
    }

    public void deleteTicket(Long id) {
        // TODO: Implémenter la logique pour supprimer un ticket
        throw new UnsupportedOperationException("Unimplemented method 'deleteTicket'");
    }

    // D'autres méthodes peuvent être ajoutées pour gérer la mise à jour, la suppression, etc.
}


