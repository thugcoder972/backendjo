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

import com.mysycorp.Backendjo.entity.Tarif;
import com.mysycorp.Backendjo.repository.TarifRepository;

@RestController
@RequestMapping("/api/tarifs")
public class TarifController {
    @Autowired
    private TarifRepository tarifRepository;

    // Récupérer tous les tarifs
    @GetMapping
    public List<Tarif> getAllTarifs() {
        return tarifRepository.findAll();
    }

    // Récupérer un tarif par ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarif> getTarifById(@PathVariable Long id) {
        return tarifRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouveau tarif
    @PostMapping
    public Tarif createTarif(@RequestBody Tarif tarif) {
        return tarifRepository.save(tarif);
    }

    // Mettre à jour un tarif existant
    @PutMapping("/{id}")
    public ResponseEntity<Tarif> updateTarif(@PathVariable Long id, @RequestBody Tarif tarifDetails) {
        return tarifRepository.findById(id)
                .map(tarif -> {
                    tarif.setNameTarif(tarifDetails.getNameTarif());
                    tarif.setTarif(tarifDetails.getTarif());
                    tarif.setOffreTarif(tarifDetails.getOffreTarif());
                    // On peut aussi mettre à jour d'autres relations si nécessaire
                    Tarif updatedTarif = tarifRepository.save(tarif);
                    return ResponseEntity.ok(updatedTarif);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un tarif par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTarif(@PathVariable Long id) {
        return tarifRepository.findById(id)
                .map(tarif -> {
                    tarifRepository.delete(tarif);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
