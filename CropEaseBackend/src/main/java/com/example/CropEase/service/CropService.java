package com.example.CropEase.service;

import com.example.CropEase.model.Auth;
import com.example.CropEase.model.Machine;
import com.example.CropEase.model.Register;
import com.example.CropEase.repository.AuthRepo;
import com.example.CropEase.repository.MachineRepository;
import com.example.CropEase.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CropService {

    @Autowired
    RegisterRepo registerRepo;

    public List<Register> availableUser() {
        return registerRepo.findAll();
    }

    public void registerSeller(String name, String email, String password, String confirm_password, String upi, int account_no, String ifsc_code){
        Register register = new Register(name, email, password, confirm_password, upi, account_no, ifsc_code);

        registerRepo.save(register);
    }

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAllMachines(){
        return machineRepository.findAll();
    }

    public Machine getMachineById(Long id){
        return machineRepository.findById(id).orElse(null);
    }

    public Machine saveMachine(String name, MultipartFile imageFile) throws IOException{
        Machine machine = new Machine();

        machine.setName(name);
        machine.setImage(imageFile.getBytes());
        return machineRepository.save(machine);

    }

    @Autowired
    private AuthRepo authRepo;
    public List<Auth> getAllSellers() { return authRepo.findAll();}

    public void addSellers(String email, String password) {
            Auth auth = new Auth(email, password);
            authRepo.save(auth);
    }

    public boolean validateSeller(String email, String password) {
        Auth seller = authRepo.findByEmailAndPassword(email, password);
        return seller != null;
    }


}
