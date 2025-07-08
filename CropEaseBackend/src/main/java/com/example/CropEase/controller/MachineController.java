package com.example.CropEase.controller;

import com.example.CropEase.model.Machine;
import com.example.CropEase.model.RegisterSeller;
import com.example.CropEase.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class MachineController {

    @Autowired
    MachineService machineService;

    @GetMapping("CropEase/allMachines")
    public List<Machine> getAllMachines(){
        return machineService.getAllMachines();
    }
    @GetMapping("/CropEase/machinesBySeller")
    public ResponseEntity<List<Machine>> getMachinesBySeller(@RequestParam("sellerId") Long sellerId) {
        List<Machine> machines = machineService.getMachinesBySellerId(sellerId);
        return ResponseEntity.ok(machines);
    }

    @PostMapping("CropEase/addMachine")
    public ResponseEntity<?> addMachine(@RequestParam("name") String name,
                                        @RequestParam("title") String title,
                                        @RequestParam("description") String description,
                                        @RequestParam("machine_details") String machine_details,
                                        @RequestParam("price") String price,
                                        @RequestParam("regionName") String regionName,
                                        @RequestParam("image") MultipartFile image,
                                        @RequestParam("registerSeller") RegisterSeller registerSellerId
                                        ){

        try{
            Machine machine = machineService.addMachine(name,title,description,machine_details,price,regionName,image,registerSellerId );
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5500/SellerPages/sellerpage.html?sellerId="+registerSellerId.getId()+"&region="+regionName)
                    .build();

        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");

        }
    }

    // UPDATE machine
    @PutMapping("/CropEase/updateMachine/{id}")
    public ResponseEntity<?> updateMachine(@PathVariable Long id,
                                           @RequestParam("name") String name,
                                           @RequestParam("title") String title,
                                           @RequestParam("description") String description,
                                           @RequestParam("machine_details") String machine_details,
                                           @RequestParam("price") String price,
                                           @RequestParam("regionName") String regionName,
                                           @RequestParam(value = "image", required = false) MultipartFile image) {
        try {
            Machine updated = machineService.updateMachine(id, name, title, description, machine_details, price, regionName, image);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE machine
    @DeleteMapping("/CropEase/deleteMachine/{id}")
    public ResponseEntity<String> deleteMachine(@PathVariable Long id) {
        try {
            machineService.deleteMachine(id);
            return ResponseEntity.ok("Machine deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/CropEase/getMachine/{id}")
    public ResponseEntity<?> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.getMachineById(id);
        if (machine != null) {
            return ResponseEntity.ok(machine);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Machine not found with ID: " + id);
        }
    }
    @PutMapping("/CropEase/updateMachine")
    public ResponseEntity<?> updateMachineJson(@RequestBody Machine machine) {
        try {
            Machine updated = machineService.updateMachineFromJson(machine);

            String redirectUrl = "http://localhost:5500/SellerPages/sellerpage.html?sellerId="
                    + updated.getRegisterSeller().getId()
                    + "&region=" + updated.getRegionName();

            Map<String, Object> response = new HashMap<>();
            response.put("redirectUrl", redirectUrl);
            response.put("message", "Machine updated successfully");

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
