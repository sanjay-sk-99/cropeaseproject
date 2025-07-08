package com.example.CropEase.repository;

import com.example.CropEase.model.RegisterSeller;
import com.example.CropEase.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    Optional<RegisterUser> findByEmail(String email);
}
