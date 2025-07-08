package com.example.CropEase.controller;

import com.example.CropEase.model.RegisterUser;
import com.example.CropEase.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5500") // Allow frontend to connect
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser user) {
        try {
            registerUserService.registerUser(user);
            return ResponseEntity.ok().body("{\"message\": \"Registration successful\"}");
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegisterUser user) {
        try {
            RegisterUser loggedInUser = registerUserService.login(user.getEmail(), user.getPassword());
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("userId", loggedInUser.getId());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    @PostMapping("/CropEase/userForgotPassword")
    public ResponseEntity<Void> forgotPassword(@RequestParam String email,
                                               @RequestParam String newPassword,
                                               @RequestParam String newConfirmPassword) {
        try {
            registerUserService.updatePassword(email, newPassword, newConfirmPassword);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/UserPages/userLogin.html?successMessage=Password updated successfully!")
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    //===========  need to changes comman error page ============
                    .header("Location", "http://localhost:5500/SellerPages/userRegister.html?error="+e.getMessage())
                    .build();
        }
    }

    @GetMapping("/CropEase/getUser/{userId}")
    public ResponseEntity<RegisterUser> getUserById(@PathVariable Long userId) {
        RegisterUser user = registerUserService.getUserById(userId);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
