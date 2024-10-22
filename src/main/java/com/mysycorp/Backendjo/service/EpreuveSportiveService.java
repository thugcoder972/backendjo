package com.mysycorp.Backendjo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysycorp.Backendjo.entity.EpreuveSportive;
import com.mysycorp.Backendjo.repository.EpreuveSportiveRepository;

@Service
public class EpreuveSportiveService {
@Autowired
    private EpreuveSportiveRepository epreuveSportiveRepository;

    // Méthode pour récupérer les épreuves sportives par type
    public List<EpreuveSportive> findByTypeEpreuveSportive(String typeEpreuveSportive) {
        return epreuveSportiveRepository.findByTypeEpreuveSportive(typeEpreuveSportive);
    }

    public List<EpreuveSportive> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
