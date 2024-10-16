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
import com.mysycorp.Backendjo.repository.AdministrationRepository;

@RestController
@RequestMapping("/api/administrations")
public class AdministrationController {
@Autowired
    private AdministrationRepository administrationRepository;

    @GetMapping
    public List<Administration> getAllAdministrations() {
        return administrationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administration> getAdministrationById(@PathVariable Long id) {
        return administrationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Administration createAdministration(@RequestBody Administration administration) {
        return administrationRepository.save(administration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administration> updateAdministration(@PathVariable Long id, @RequestBody Administration administrationDetails) {
        return administrationRepository.findById(id)
                .map(admin -> {
                    admin.setRole(administrationDetails.getRole());
                    admin.setUser(administrationDetails.getUser());
                    Administration updatedAdmin = administrationRepository.save(admin);
                    return ResponseEntity.ok(updatedAdmin);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdministration(@PathVariable Long id) {
        return administrationRepository.findById(id)
                .map(admin -> {
                    administrationRepository.delete(admin);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

}
}
