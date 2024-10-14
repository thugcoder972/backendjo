package com.mysycorp.Backendjo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mysycorp.Backendjo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
