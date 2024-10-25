package com.mysycorp.Backendjo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysycorp.Backendjo.dto.TicketDTO;
import com.mysycorp.Backendjo.entity.Ticket;
import com.mysycorp.Backendjo.repository.AchatRepository;
import com.mysycorp.Backendjo.repository.AdministrationRepository;
import com.mysycorp.Backendjo.repository.ComplexeSportifRepository;
import com.mysycorp.Backendjo.repository.EpreuveSportiveRepository;
import com.mysycorp.Backendjo.repository.HallRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class TicketMapper {

    @Autowired
    private AchatRepository achatRepository;

    @Autowired
    private AdministrationRepository administrationRepository;

    @Autowired
    private ComplexeSportifRepository complexeSportifRepository;

    @Autowired
    private EpreuveSportiveRepository epreuveSportiveRepository;

    @Autowired
    private HallRepository hallRepository;

    public TicketDTO toDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setStartTimeEpreuve(ticket.getStartTimeEpreuve());
        dto.setAchatId(ticket.getAchat() != null ? ticket.getAchat().getId() : null);
        dto.setAdministrationId(ticket.getAdministration() != null ? ticket.getAdministration().getId() : null);
        dto.setComplexeSportifId(ticket.getComplexeSportif() != null ? ticket.getComplexeSportif().getId() : null);
        dto.setEpreuveSportiveId(ticket.getEpreuveSportive() != null ? ticket.getEpreuveSportive().getId() : null);
        dto.setHallId(ticket.getHall() != null ? ticket.getHall().getId() : null);
        dto.setRemainingPlaces(ticket.getRemainingPlaces());
       
        return dto;
    }

    public Ticket toEntity(TicketDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setStartTimeEpreuve(dto.getStartTimeEpreuve());
        
        // Set relations with Achat
        if (dto.getAchatId() != null) {
            ticket.setAchat(achatRepository.findById(dto.getAchatId())
                .orElseThrow(() -> new EntityNotFoundException("Achat not found with id " + dto.getAchatId())));
        }

        // Set relations with Administration
        if (dto.getAdministrationId() != null) {
            ticket.setAdministration(administrationRepository.findById(dto.getAdministrationId())
                .orElseThrow(() -> new EntityNotFoundException("Administration not found with id " + dto.getAdministrationId())));
        }

        // Set relations with ComplexeSportif
        if (dto.getComplexeSportifId() != null) {
            ticket.setComplexeSportif(complexeSportifRepository.findById(dto.getComplexeSportifId())
                .orElseThrow(() -> new EntityNotFoundException("ComplexeSportif not found with id " + dto.getComplexeSportifId())));
        }

        // Set relations with EpreuveSportive
        if (dto.getEpreuveSportiveId() != null) {
            ticket.setEpreuveSportive(epreuveSportiveRepository.findById(dto.getEpreuveSportiveId())
                .orElseThrow(() -> new EntityNotFoundException("EpreuveSportive not found with id " + dto.getEpreuveSportiveId())));
        }

        // Set relations with Hall
        if (dto.getHallId() != null) {
            ticket.setHall(hallRepository.findById(dto.getHallId())
                .orElseThrow(() -> new EntityNotFoundException("Hall not found with id " + dto.getHallId())));
        }

        ticket.setRemainingPlaces(dto.getRemainingPlaces());
        return ticket;
    }

    public TicketDTO toDto(Ticket ticket) {
        // TODO: Implement this method or remove if not needed
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }
}


