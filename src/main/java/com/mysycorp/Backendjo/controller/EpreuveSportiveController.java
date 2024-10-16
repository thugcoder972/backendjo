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

import com.mysycorp.Backendjo.entity.EpreuveSportive;
import com.mysycorp.Backendjo.repository.EpreuveSportiveRepository;

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
    public EpreuveSportive createEpreuve(@RequestBody EpreuveSportive epreuveSportive) {
        return epreuveSportiveRepository.save(epreuveSportive);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpreuveSportive> updateEpreuve(@PathVariable Long id, @RequestBody EpreuveSportive epreuveSportiveDetails) {
        return epreuveSportiveRepository.findById(id)
                .map(epreuve -> {
                    epreuve.setSport(epreuveSportiveDetails.getSport());
                    epreuve.setDate(epreuveSportiveDetails.getDate());
                    epreuve.setHall(epreuveSportiveDetails.getHall());
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
