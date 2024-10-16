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

import com.mysycorp.Backendjo.entity.Hall;
import com.mysycorp.Backendjo.repository.HallRepository;

@RestController
@RequestMapping("/api/halls")
public class HallController {
@Autowired
    private HallRepository hallRepository;

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable Long id) {
        return hallRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return hallRepository.save(hall);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hall> updateHall(@PathVariable Long id, @RequestBody Hall hallDetails) {
        return hallRepository.findById(id)
                .map(hall -> {
                    hall.setName(hallDetails.getName());
                    hall.setComplexeSportif(hallDetails.getComplexeSportif());
                    Hall updatedHall = hallRepository.save(hall);
                    return ResponseEntity.ok(updatedHall);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHall(@PathVariable Long id) {
        return hallRepository.findById(id)
                .map(hall -> {
                    hallRepository.delete(hall);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
