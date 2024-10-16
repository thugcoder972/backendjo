package com.mysycorp.Backendjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.Tarif;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long> {

}
