package com.example.CropEase.service;

import com.example.CropEase.model.RegisterSeller;
import com.example.CropEase.model.RegisterUser;
import com.example.CropEase.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUserService {

    @Autowired
    private RegisterUserRepository registerUserRepository;

    public RegisterUser registerUser(RegisterUser user) {
        // Check if user already exists
        Optional<RegisterUser> existingUser = registerUserRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with this email.");
        }
        return registerUserRepository.save(user);
    }

    public RegisterUser login(String email, String password) {
        Optional<RegisterUser> user = registerUserRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid email or password.");
        }
    }

    public void updatePassword(String email, String newPassword, String newConfirmPassword) {
        if (!newPassword.equals(newConfirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        Optional<RegisterUser> userOpt = registerUserRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("No user found with that email.");
        }

        RegisterUser user = userOpt.get();
        user.setPassword(newPassword);  // Consider hashing in real apps!
        user.setConfirm_password(newConfirmPassword);
        registerUserRepository.save(user);
    }

    public RegisterUser getUserById(Long id) {
        return registerUserRepository.findById(id).orElse(null);
    }



}
