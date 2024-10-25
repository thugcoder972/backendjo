package com.mysycorp.Backendjo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.Achat;

@Repository
public interface AchatRepository extends JpaRepository<Achat, Long>{
// Rechercher tous les achats par un utilisateur donné
List<Achat> findByUser_Id(Long userId);

// Rechercher tous les achats dans une plage de dates
List<Achat> findByDateAchatBetween(LocalDateTime startDate, LocalDateTime endDate);

// Rechercher tous les achats par nombre de tickets
List<Achat> findByNombreTickets(int nombreTickets);

// Rechercher tous les achats par prix total
List<Achat> findByPrixTotalGreaterThanEqual(double prixTotal);
}
