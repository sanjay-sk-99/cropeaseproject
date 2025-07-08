package com.example.CropEase.controller;

import com.example.CropEase.model.RegisterSeller;
import com.example.CropEase.repository.RegisterSellerRepository;
import com.example.CropEase.service.RegisterSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:5500")
@RestController
public class RegisterSellerController {

    @Autowired
    RegisterSellerService registerSellerService;

    @Autowired
    private RegisterSellerRepository registerSellerRepository;
    @PostMapping("/registerSeller")
    public ResponseEntity<String> registerSeller(@RequestParam String business_name,
                                                 @RequestParam String owner_name,
                                                 @RequestParam String email,
                                                 @RequestParam String phone_no,
                                                 @RequestParam String business_address,
                                                 @RequestParam String password,
                                                 @RequestParam String confirm_password,
                                                 @RequestParam Long regionId) {
        try {
            registerSellerService.registerSeller(business_name, owner_name, email, phone_no,
                    business_address, password, confirm_password, regionId);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/SellerPages/sellerLogin.html")
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/SellerPages/sellerreg.html?error=duplicate")
                    .build();
        }
    }

    @GetMapping("/registerSeller")
    public List<RegisterSeller> getAllRegisterSeller(){
      return   registerSellerService.getAllRegisterSeller();
    }


    @PostMapping("CropEase/SellerLogin")
    public ResponseEntity<Void> loginSeller(@RequestParam("email") String email,
                                            @RequestParam("password") String password) {

        Long sellerId = registerSellerService.validateSeller(email, password);



        if (sellerId != null) {
            // Fetch the full seller object
            RegisterSeller seller = registerSellerRepository.findById(sellerId).orElse(null);

            if (seller != null && seller.getRegion() != null) {
                String regionName = seller.getRegion().getRegion_name();
                System.out.println("Seller's Region: " + regionName);

                // Optionally, pass region name as a query param if needed
                return ResponseEntity.status(HttpStatus.FOUND)
                        .header("Location", "http://localhost:5500/SellerPages/sellerpage.html?sellerId=" + sellerId + "&region=" + regionName)
                        .build();
            }

            // Fallback if no region is set
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/SellerPages/sellerpage.html?sellerId=" + sellerId)
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/SellerPages/sellerLogin.html?error=true")
                    .build();
        }
    }

    @PostMapping("/CropEase/forgotPassword")
    public ResponseEntity<Void> forgotPassword(@RequestParam String email,
                                                 @RequestParam String newPassword,
                                                 @RequestParam String newConfirmPassword) {
        try {
            registerSellerService.updatePassword(email, newPassword, newConfirmPassword);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/SellerPages/sellerLogin.html?successMessage=Password updated successfully!")
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    //===========  need to changes comman error page ============
                    .header("Location", "http://localhost:5500/SellerPages/sellerLogin.html?error="+e.getMessage())
                    .build();
        }
    }

    @GetMapping("/CropEase/getSeller/{sellerId}")
    public ResponseEntity<RegisterSeller> getSellerById(@PathVariable Long sellerId) {
        RegisterSeller seller = registerSellerRepository.findById(sellerId).orElse(null);

        if (seller != null) {
            return ResponseEntity.ok(seller);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
