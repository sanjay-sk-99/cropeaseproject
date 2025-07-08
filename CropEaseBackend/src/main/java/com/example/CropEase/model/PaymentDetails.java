package com.example.CropEase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long selleId;
    private Long machineId;
    private String region;
    private String machineTitle;
    private String machineDetails;
    private String machineDescription;
    private String totalPrice;

    private LocalDate fromDate;
    private LocalDate toDate;
    private int hours; // number of hours (assuming it’s a number)

    // Getters and Setters (you can generate them automatically)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSelleId() {
        return selleId;
    }

    public void setSelleId(Long selleId) {
        this.selleId = selleId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMachineTitle() {
        return machineTitle;
    }

    public void setMachineTitle(String machineTitle) {
        this.machineTitle = machineTitle;
    }

    public String getMachineDetails() {
        return machineDetails;
    }

    public void setMachineDetails(String machineDetails) {
        this.machineDetails = machineDetails;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public PaymentDetails(String region, Long userId, Long selleId, Long machineId, String machineTitle, String machineDetails, String machineDescription, String totalPrice, LocalDate toDate, LocalDate fromDate, int hours) {
        this.region = region;
        this.userId = userId;
        this.selleId = selleId;
        this.machineId = machineId;
        this.machineTitle = machineTitle;
        this.machineDetails = machineDetails;
        this.machineDescription = machineDescription;
        this.totalPrice = totalPrice;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.hours = hours;
    }
    public PaymentDetails(){

    }
}
