package com.example.CropEase.service;

import com.example.CropEase.model.Region;
import com.example.CropEase.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions(){
        return regionRepository.findAll();
    }
}
