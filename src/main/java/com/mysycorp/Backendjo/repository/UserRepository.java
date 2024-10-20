package com.mysycorp.Backendjo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysycorp.Backendjo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Object findByEmail(String email);
}
