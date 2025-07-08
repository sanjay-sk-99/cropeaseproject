package com.example.CropEase.repository;

import com.example.CropEase.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine,Long> {
 List<Machine> findByRegisterSeller_Id(Long sellerId);
}
