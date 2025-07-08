package com.example.CropEase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String region_name;

    @OneToMany(mappedBy = "region")
    @JsonIgnore  // Or @JsonManagedReference / @JsonBackReference
    private List<RegisterSeller> sellers;

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public Region(long id, String region_name) {
        this.id = id;
        this.region_name = region_name;
    }
    public Region(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
