package com.example.CropEase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register {
    @Id
    private int seller_id;
    private String name;
    private String email;
    private String password;
    private String confirm_password;
    private String upi;
    private int account_no;
    private String ifsc_code;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.name = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public Register() {
    }

    public Register( String name, String email, String password, String confirm_password, String upi, int account_no, String ifsc_code) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.upi = upi;
        this.account_no = account_no;
        this.ifsc_code = ifsc_code;
    }

}
