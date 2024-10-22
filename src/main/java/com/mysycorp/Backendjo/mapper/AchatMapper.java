package com.mysycorp.Backendjo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mysycorp.Backendjo.dto.AchatDTO;
import com.mysycorp.Backendjo.dto.TicketDTO;
import com.mysycorp.Backendjo.entity.Achat;
import com.mysycorp.Backendjo.entity.Ticket;
import com.mysycorp.Backendjo.entity.User;

@Component
public class AchatMapper {

    private final TicketMapper ticketMapper; // Injectez votre TicketMapper

    public AchatMapper(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    // Convertir un Achat en AchatDTO
    public AchatDTO toDTO(Achat achat) {
        AchatDTO dto = new AchatDTO();
        dto.setId(achat.getId());
        dto.setDateAchat(achat.getDateAchat());
        dto.setUserId(achat.getUser().getId());
        
        // Convertir les tickets en TicketDTO
        List<TicketDTO> ticketDTOs = achat.getTickets().stream()
                                           .map(ticketMapper::toDTO)
                                           .collect(Collectors.toList());
        dto.setTickets(ticketDTOs);
        return dto;
    }

    // Convertir un AchatDTO en Achat
    public Achat toEntity(AchatDTO achatDTO, User user) {
        Achat achat = new Achat();
        achat.setId(achatDTO.getId());
        achat.setDateAchat(achatDTO.getDateAchat());
        achat.setUser(user);
        // Vous pouvez également gérer les tickets ici si nécessaire
        return achat;
    }
}

