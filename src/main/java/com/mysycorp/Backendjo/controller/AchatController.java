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

import com.mysycorp.Backendjo.entity.Achat;
import com.mysycorp.Backendjo.repository.AchatRepository;


@RestController
@RequestMapping("/api/achats")
public class AchatController {
@Autowired
    private AchatRepository achatRepository;

    @GetMapping
    public List<Achat> getAllAchats() {

        return achatRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Achat> getAchatById(@PathVariable Long id) {
        return achatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Achat createAchat(@RequestBody Achat achat) {
        return achatRepository.save(achat);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAchat(@PathVariable Long id) {
        return achatRepository.findById(id)
                .map(achat -> {
                    achatRepository.delete(achat);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }    

}
