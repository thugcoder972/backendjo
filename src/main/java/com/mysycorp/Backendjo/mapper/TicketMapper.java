package com.mysycorp.Backendjo.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.mysycorp.Backendjo.dto.TicketDTO;
import com.mysycorp.Backendjo.entity.Tarif;
import com.mysycorp.Backendjo.entity.Ticket;

@Component
public class TicketMapper {

    public TicketDTO toDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setStartTimeEpreuve(ticket.getStartTimeEpreuve());
        dto.setAchatId(ticket.getAchat() != null ? ticket.getAchat().getId() : null);
        dto.setAdministrationId(ticket.getAdministration() != null ? ticket.getAdministration().getId() : null);
        dto.setComplexeSportifId(ticket.getComplexeSportif().getId());
        dto.setEpreuveSportiveId(ticket.getEpreuveSportive().getId());
        dto.setHallId(ticket.getHall().getId());
        dto.setRemainingPlaces(ticket.getRemainingPlaces());
        dto.setTarifIds(ticket.getTarifs().stream().map(Tarif::getId).collect(Collectors.toSet()));
        return dto;
    }

    public Ticket toEntity(TicketDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setStartTimeEpreuve(dto.getStartTimeEpreuve());
        // Set relations with Achat, Administration, ComplexeSportif, etc. using their respective services/repositories
        ticket.setRemainingPlaces(dto.getRemainingPlaces());
        return ticket;
    }

    public TicketDTO toDto(Ticket ticket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }
}

