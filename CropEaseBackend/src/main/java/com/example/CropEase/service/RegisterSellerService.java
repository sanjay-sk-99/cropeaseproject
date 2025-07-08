package com.example.CropEase.service;

import com.example.CropEase.model.Auth;
import com.example.CropEase.model.Region;
import com.example.CropEase.model.RegisterSeller;
import com.example.CropEase.model.RegisterUser;
import com.example.CropEase.repository.RegionRepository;
import com.example.CropEase.repository.RegisterSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterSellerService {
    @Autowired
    private RegisterSellerRepository registerSellerRepository;

    @Autowired
    private RegionRepository regionRepository;

    public void registerSeller(String business_name, String owner_name, String email, String phone_no,
                               String business_address, String password, String confirm_password,
                               Long regionId) {

        if (registerSellerRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered");
        }
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found"));

        RegisterSeller seller = new RegisterSeller();
        seller.setBusiness_name(business_name);
        seller.setOwner_name(owner_name);
        seller.setEmail(email);
        seller.setPhone_no(phone_no);
        seller.setBusiness_address(business_address);
        seller.setPassword(password);
        seller.setConfirm_password(confirm_password);
        seller.setRegion(region); // Set the actual Region object

        registerSellerRepository.save(seller);
    }

    public List<RegisterSeller> getAllRegisterSeller(){
       return registerSellerRepository.findAll();
    }

    public Long validateSeller(String email, String password) {
        RegisterSeller seller = registerSellerRepository.findByEmailAndPassword(email, password);
        return (seller != null) ? seller.getId() : null;
    }

    public void updatePassword(String email, String newPassword, String newConfirmPassword) {
        RegisterSeller seller = registerSellerRepository.findByEmail(email);
        if (seller == null) {
            throw new IllegalArgumentException("Email not registered");
        }

        if (!newPassword.equals(newConfirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        seller.setPassword(newPassword);
        seller.setConfirm_password(newConfirmPassword);
        registerSellerRepository.save(seller);
    }




}
