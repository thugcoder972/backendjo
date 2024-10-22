package com.mysycorp.Backendjo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.EpreuveSportive;

@Repository
public interface EpreuveSportiveRepository extends JpaRepository<EpreuveSportive, Long>{

    List<EpreuveSportive> findByTypeEpreuveSportive(String type);

}
