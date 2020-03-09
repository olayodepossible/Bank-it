package com.possible.bankapp.repositories;

import com.possible.bankapp.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findById(UUID id);
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
    boolean existsByEmail(String email);
    User findByEmailVerificationToken(String token);
}
