
package com.mysycorp.Backendjo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysycorp.Backendjo.dto.AchatDTO;
import com.mysycorp.Backendjo.entity.Achat;
import com.mysycorp.Backendjo.entity.Ticket;
import com.mysycorp.Backendjo.entity.User;
import com.mysycorp.Backendjo.exception.ResourceNotFoundException;
import com.mysycorp.Backendjo.mapper.AchatMapper;
import com.mysycorp.Backendjo.repository.AchatRepository;
import com.mysycorp.Backendjo.repository.TicketRepository;
import com.mysycorp.Backendjo.repository.UserRepository;
import com.mysycorp.Backendjo.service.AchatService;

@RestController
@RequestMapping("/api/achats")
public class AchatController {

    @Autowired
    private AchatRepository achatRepository;

    @Autowired
    private AchatService achatService; // Votre service qui gère la logique métier

    @Autowired
    private AchatMapper achatMapper; // Votre mapper

    @Autowired
    private UserRepository userRepository; // Injection de UserRepository
    @Autowired
    private TicketRepository ticketRepository; // Injection de TicketRepository
    // Récupérer tous les achats
    @GetMapping
    public ResponseEntity<List<AchatDTO>> getAllAchats() {
        List<Achat> achats = achatService.findAll(); // Récupérer tous les achats depuis le service
        List<AchatDTO> achatDTOs = achats.stream()
                                          .map(achatMapper::toDTO) // Convertir chaque Achat en AchatDTO
                                          .collect(Collectors.toList());
        return ResponseEntity.ok(achatDTOs); // Retourner la liste des AchatDTO
    }

    // Récupérer un achat par ID
    @GetMapping("/{id}")
    public ResponseEntity<Achat> getAchatById(@PathVariable Long id) {
        return achatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouvel achat
    @PostMapping
    public ResponseEntity<Achat> createAchat(@RequestBody AchatDTO achatDTO) {
        // 1. Récupérer l'utilisateur à partir de l'ID du DTO
        User user = userRepository.findById(achatDTO.getUser())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + achatDTO.getUser()));

        // 2. Créer un nouvel achat et y assigner les propriétés du DTO
        Achat achat = new Achat();
        achat.setUser(user);
        achat.setDateAchat(achatDTO.getDateAchat());

        // 3. Associer les tickets à l'achat (si nécessaire)
        List<Ticket> tickets = achatDTO.getTickets().stream().map(ticketDTO -> {
            Ticket ticket = new Ticket();
            if (ticketDTO.getId() == null) {
                throw new IllegalArgumentException("Ticket ID must not pdd null");
            }
            ticket.setId(ticketDTO.getId()); // On suppose que les tickets existent déjà
            return ticket;
        }).collect(Collectors.toList());
        
        achat.setTickets(tickets);  // Si la relation est en Set

        // 4. Sauvegarder l'achat dans la base de données
        Achat savedAchat = achatRepository.save(achat);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAchat);
    }

    // Mettre à jour un achat existant
    @PutMapping("/{id}")
    public ResponseEntity<Achat> updateAchat(@PathVariable Long id, @RequestBody Achat achatDetails) {
        return achatRepository.findById(id)
                .map(achat -> {
                    achat.setTickets(achatDetails.getTickets());
                    achat.setUser(achatDetails.getUser());
                    Achat updatedAchat = achatRepository.save(achat);
                    return ResponseEntity.ok(updatedAchat);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un achat
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAchat(@PathVariable Long id) {
        return achatRepository.findById(id)
                .map(achat -> {
                    achatRepository.delete(achat);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
