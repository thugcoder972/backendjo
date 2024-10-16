package com.mysycorp.Backendjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.ComplexeSportif;

@Repository
public interface ComplexeSportifRepository extends JpaRepository<ComplexeSportif, Long>{

}
