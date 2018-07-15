package com.cybrilla.cybrilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybrilla.cybrilla.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}