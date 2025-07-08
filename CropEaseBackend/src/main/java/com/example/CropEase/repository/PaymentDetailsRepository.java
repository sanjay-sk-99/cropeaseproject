package com.example.CropEase.repository;

import com.example.CropEase.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {
    // If you want custom queries later, you can add here
}
