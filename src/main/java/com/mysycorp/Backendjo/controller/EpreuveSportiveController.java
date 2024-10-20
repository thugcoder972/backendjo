package com.mysycorp.Backendjo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysycorp.Backendjo.entity.EpreuveSportive;
import com.mysycorp.Backendjo.repository.EpreuveSportiveRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/epreuves-sportives")
public class EpreuveSportiveController {

    @Autowired
    private EpreuveSportiveRepository epreuveSportiveRepository;

    @GetMapping
    public List<EpreuveSportive> getAllEpreuves() {
        return epreuveSportiveRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpreuveSportive> getEpreuveById(@PathVariable Long id) {
        return epreuveSportiveRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createEpreuve(@Valid @RequestBody EpreuveSportive epreuveSportive, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        try {
            EpreuveSportive savedEpreuve = epreuveSportiveRepository.save(epreuveSportive);
            return ResponseEntity.ok(savedEpreuve);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEpreuve(@PathVariable Long id, @Valid @RequestBody EpreuveSportive epreuveSportiveDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        return epreuveSportiveRepository.findById(id)
                .map(epreuve -> {
                    epreuve.setNameEpreuveSportive(epreuveSportiveDetails.getNameEpreuveSportive());
                    epreuve.setTypeEpreuveSportive(epreuveSportiveDetails.getTypeEpreuveSportive());
                    epreuve.setNiveauEpreuve(epreuveSportiveDetails.getNiveauEpreuve());
                    epreuve.setImageUrl(epreuveSportiveDetails.getImageUrl());
                    epreuve.setHall(epreuveSportiveDetails.getHall());
                    epreuve.setDurationInSeconds(epreuveSportiveDetails.getDurationInSeconds()); // Mise à jour de la durée
                    EpreuveSportive updatedEpreuve = epreuveSportiveRepository.save(epreuve);
                    return ResponseEntity.ok(updatedEpreuve);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEpreuve(@PathVariable Long id) {
        return epreuveSportiveRepository.findById(id)
                .map(epreuve -> {
                    epreuveSportiveRepository.delete(epreuve);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
