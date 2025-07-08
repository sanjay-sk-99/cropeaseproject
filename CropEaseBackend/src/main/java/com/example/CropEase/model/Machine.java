package com.example.CropEase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String machine_details;
    private String description;
    private String price;
    private String regionName;


    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private RegisterSeller registerSeller;


    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMachine_details() {
        return machine_details;
    }

    public void setMachine_details(String machine_details) {
        this.machine_details = machine_details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public RegisterSeller getRegisterSeller() {
        return registerSeller;
    }

    public void setRegisterSeller(RegisterSeller registerSeller) {
        this.registerSeller = registerSeller;
    }
    public Machine(Long id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Machine(){

    }

    public Machine(String name, String title, String machine_details, String description, String price, byte[] image, RegisterSeller registerSeller) {
        this.name = name;
        this.title = title;
        this.machine_details = machine_details;
        this.description = description;
        this.price = price;
        this.image = image;
        this.registerSeller = registerSeller;
    }
}
