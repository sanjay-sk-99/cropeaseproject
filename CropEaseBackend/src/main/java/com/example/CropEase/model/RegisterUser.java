package com.example.CropEase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "register_user")
public class RegisterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String confirm_password;
    private String phone_no;
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getAddress() {
        return address;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public RegisterUser(String name, String email, String password, String phone_no, String address, String confirm_password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_no = phone_no;
        this.address = address;
        this.confirm_password = confirm_password;
    }

    public RegisterUser(){

    }
    public void setAddress(String address) {
        this.address = address;
    }


}
