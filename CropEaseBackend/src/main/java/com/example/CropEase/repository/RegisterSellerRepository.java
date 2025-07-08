package com.example.CropEase.repository;

import com.example.CropEase.model.Auth;
import com.example.CropEase.model.RegisterSeller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterSellerRepository extends JpaRepository<RegisterSeller,Long> {
    RegisterSeller findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    RegisterSeller findByEmail(String email);
}
