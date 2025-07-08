package com.example.CropEase.controller;

import com.example.CropEase.model.Region;
import com.example.CropEase.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(value = "http://localhost:5500")
@RestController

public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping("/regions")
    public List<Region> getAllRegions(){
        return regionService.getAllRegions();
    }
}
