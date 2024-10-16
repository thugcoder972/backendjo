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

import com.mysycorp.Backendjo.entity.ComplexeSportif;
import com.mysycorp.Backendjo.repository.ComplexeSportifRepository;

@RestController
@RequestMapping("/api/complexes-sportifs")
public class ComplexeSportifController {
@Autowired
    private ComplexeSportifRepository complexeSportifRepository;

    @GetMapping
    public List<ComplexeSportif> getAllComplexes() {
        return complexeSportifRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplexeSportif> getComplexeById(@PathVariable Long id) {
        return complexeSportifRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComplexeSportif createComplexe(@RequestBody ComplexeSportif complexeSportif) {
        return complexeSportifRepository.save(complexeSportif);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplexeSportif> updateComplexe(@PathVariable Long id, @RequestBody ComplexeSportif complexeSportifDetails) {
        return complexeSportifRepository.findById(id)
                .map(complexe -> {
                    complexe.setName(complexeSportifDetails.getName());
                    complexe.setLocation(complexeSportifDetails.getLocation());
                    ComplexeSportif updatedComplexe = complexeSportifRepository.save(complexe);
                    return ResponseEntity.ok(updatedComplexe);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteComplexe(@PathVariable Long id) {
        return complexeSportifRepository.findById(id)
                .map(complexe -> {
                    complexeSportifRepository.delete(complexe);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }  
}
