package com.user.userapplication.service;

import com.user.userapplication.data.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserCredentials, UUID> {

    Optional<UserCredentials> findByUsername(String username);

    void deleteById(UUID id);
}