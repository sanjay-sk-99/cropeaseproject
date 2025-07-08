package com.example.CropEase.repository;

import com.example.CropEase.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Auth,Long> {
    Auth findByEmailAndPassword(String email, String password);
}
