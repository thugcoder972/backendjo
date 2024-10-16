package com.mysycorp.Backendjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.EpreuveSportive;

@Repository
public interface EpreuveSportiveRepository extends JpaRepository<EpreuveSportive, Long>{

}
