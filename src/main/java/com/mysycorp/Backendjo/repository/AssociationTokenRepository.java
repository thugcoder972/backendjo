package com.mysycorp.Backendjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.AssociationToken;

@Repository
public interface AssociationTokenRepository extends JpaRepository<AssociationToken, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}
