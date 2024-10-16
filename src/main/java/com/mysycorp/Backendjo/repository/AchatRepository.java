package com.mysycorp.Backendjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.Achat;

@Repository
public interface AchatRepository extends JpaRepository<Achat, Long>{

}
