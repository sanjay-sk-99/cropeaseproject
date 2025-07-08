package com.example.CropEase.repository;

import com.example.CropEase.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // You can add custom query methods here if needed later
    List<Orders> findByUserId(Long userId);
    List<Orders> findBySellerId(Long sellerId);
}
