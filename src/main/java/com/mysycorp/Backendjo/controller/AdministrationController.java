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

import com.mysycorp.Backendjo.entity.Administration;
import com.mysycorp.Backendjo.entity.User;
import com.mysycorp.Backendjo.repository.AdministrationRepository;
import com.mysycorp.Backendjo.repository.UserRepository;

@RestController
@RequestMapping("/api/administrations")
public class AdministrationController {

    @Autowired
    private AdministrationRepository administrationRepository;

    @Autowired
    private UserRepository userRepository;

    // Récupérer toutes les administrations
    @GetMapping
    public List<Administration> getAllAdministrations() {
        return administrationRepository.findAll();
    }

    // Récupérer une administration par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Administration> getAdministrationById(@PathVariable Long id) {
        return administrationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer une nouvelle administration
    @PostMapping
    public ResponseEntity<Administration> createAdministration(@RequestBody Administration administration) {
        // Vérifier si l'utilisateur existe
        User user = administration.getUser();
        if (user != null && userRepository.existsById(user.getId())) {
            return ResponseEntity.ok(administrationRepository.save(administration));
        } else {
            return ResponseEntity.badRequest().build(); // Retourner une erreur si l'utilisateur n'existe pas
        }
    }

    // Mettre à jour une administration existante
    @PutMapping("/{id}")
    public ResponseEntity<Administration> updateAdministration(
            @PathVariable Long id,
            @RequestBody Administration administrationDetails) {
        return (ResponseEntity<Administration>) administrationRepository.findById(id)
                .map(admin -> {
                    admin.setRole(administrationDetails.getRole());

                    // Mise à jour de l'utilisateur associé
                    User userDetails = administrationDetails.getUser();
                    if (userDetails != null && userRepository.existsById(userDetails.getId())) {
                        admin.setUser(userDetails);
                    } else {
                        return ResponseEntity.badRequest().build(); // Retourner une erreur si l'utilisateur est invalide
                    }

                    Administration updatedAdmin = administrationRepository.save(admin);
                    return ResponseEntity.ok(updatedAdmin);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une administration
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdministration(@PathVariable Long id) {
        return administrationRepository.findById(id)
                .map(admin -> {
                    administrationRepository.delete(admin);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

