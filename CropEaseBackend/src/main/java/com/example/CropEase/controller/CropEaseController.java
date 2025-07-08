package com.example.CropEase.controller;

import com.example.CropEase.model.Auth;
import com.example.CropEase.model.Machine;
import com.example.CropEase.model.Register;
import com.example.CropEase.repository.MachineRepository;
import com.example.CropEase.service.CropService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.cert.CertPathBuilder;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
public class CropEaseController {

    @Autowired
    CropService cropService;

    @GetMapping("CropEase/all_seller_details")
    public List<Register> availableUser(){
        return cropService.availableUser();
    }

    @PostMapping("CropEase/register")
    public String registerSeller(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password,
                                 @RequestParam("upi") String upi,
                                 @RequestParam("account_no") int account_no,
                                 @RequestParam("ifsc_code") String ifsc_code){
        cropService.registerSeller(name, email, password, confirm_password, upi, account_no, ifsc_code);

        return "Hi "+ name + " Your Account register Successfully";
    }



    @PostMapping("CropEase/upload")
    public ResponseEntity<?> uploadMachine(
            @RequestParam("name") String name,
            @RequestParam("image")MultipartFile image
    ){
        try{
            Machine machine = cropService.saveMachine(name, image);
                return ResponseEntity.status(HttpStatus.FOUND)
                        .header("Location", "http://localhost:5501/machineListingPage.html")
                        .build();

        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");

        }
    }


    @GetMapping("CropEase/machines")
    public List<Machine> getAllMachines(){
        return cropService.getAllMachines();

    }

    @GetMapping("CropEase/machines/{id}")
    public ResponseEntity<byte[]> getMachineImage(@PathVariable Long id) {
        Machine machine = cropService.getMachineById(id);
        if (machine != null && machine.getImage() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(machine.getImage());

        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("CropEase/auth")
    public ResponseEntity<Void> addSellers(@RequestParam("email") String email, @RequestParam("password") String password) throws IOException {
        cropService.addSellers(email, password);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5501/ListAllusers.html")
                .build();


    }

    @GetMapping("CropEase/auth")
    public List<Auth> getAllSellers(){
        return cropService.getAllSellers();
    }

    @PostMapping("CropEase/login")
    public ResponseEntity<Void> loginSeller(@RequestParam("email") String email,
                                            @RequestParam("password") String password) {

        boolean isValid = cropService.validateSeller(email, password);

        if (isValid) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/index.html")
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/index.html?error=true")
                    .build();
        }
    }

}
