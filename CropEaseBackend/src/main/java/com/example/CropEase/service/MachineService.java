package com.example.CropEase.service;

import com.example.CropEase.model.Machine;
import com.example.CropEase.model.RegisterSeller;
import com.example.CropEase.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MachineService {

    @Autowired
    MachineRepository machineRepository;

    public List<Machine> getAllMachines(){
        return machineRepository.findAll();
    }

    public Machine addMachine(String name, String title, String description, String machine_details, String price, String regionName , MultipartFile image, RegisterSeller registerSellerId) throws IOException {

        Machine machine = new Machine();

        machine.setName(name);
        machine.setTitle(title);
        machine.setDescription(description);
        machine.setMachine_details(machine_details);
        machine.setImage(image.getBytes());
        machine.setPrice(price);
        machine.setRegisterSeller(registerSellerId);
        machine.setRegionName(regionName);
        return machineRepository.save(machine);
    }

    public List<Machine> getMachinesBySellerId(Long sellerId) {
        return machineRepository.findByRegisterSeller_Id(sellerId);
    }


    // Update existing Machine
    public Machine updateMachine(Long id, String name, String title, String description, String machine_details,
                                 String price, String regionName, MultipartFile image) throws IOException {
        Machine existingMachine = machineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        existingMachine.setName(name);
        existingMachine.setTitle(title);
        existingMachine.setDescription(description);
        existingMachine.setMachine_details(machine_details);
        existingMachine.setPrice(price);
        existingMachine.setRegionName(regionName);

        if (image != null && !image.isEmpty()) {
            existingMachine.setImage(image.getBytes());
        }

        return machineRepository.save(existingMachine);
    }

    // Delete Machine
    public void deleteMachine(Long id) {
        if (!machineRepository.existsById(id)) {
            throw new RuntimeException("Machine not found with ID: " + id);
        }
        machineRepository.deleteById(id);
    }
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    public Machine updateMachineFromJson(Machine machine) {
        Machine existingMachine = machineRepository.findById(machine.getId())
                .orElseThrow(() -> new RuntimeException("Machine not found with ID: " + machine.getId()));

        existingMachine.setName(machine.getName());
        existingMachine.setTitle(machine.getTitle());
        existingMachine.setDescription(machine.getDescription());
        existingMachine.setMachine_details(machine.getMachine_details());
        existingMachine.setPrice(machine.getPrice());

        existingMachine.setRegisterSeller(existingMachine.getRegisterSeller());

        // ✅ Retain the existing seller
        existingMachine.setRegisterSeller(existingMachine.getRegisterSeller());

        return machineRepository.save(existingMachine);
    }


}
