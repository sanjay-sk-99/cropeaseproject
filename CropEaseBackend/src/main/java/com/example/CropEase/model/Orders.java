package com.example.CropEase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderStatus;
    private String verifyStatus;

    private Long machineId;
    private String machineName;
    private String totalPrice;
    private String regionName;
    private String machineTitle;

    private Long sellerId;
    private String sellerName;
    private String sellerPhoneNo;
    private String sellerEmail;

    private Long userId;
    private String userName;
    private String userPhoneNo;
    private String userEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMachineTitle() {
        return machineTitle;
    }

    public void setMachineTitle(String machineTitle) {
        this.machineTitle = machineTitle;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPhoneNo() {
        return sellerPhoneNo;
    }

    public void setSellerPhoneNo(String sellerPhoneNo) {
        this.sellerPhoneNo = sellerPhoneNo;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Orders() {
    }

    public Orders(Long id, String orderStatus, String verifyStatus, String userEmail, String userPhoneNo, String userName, Long userId, String sellerEmail, String sellerPhoneNo, String sellerName, Long sellerId, String machineTitle, String regionName, Long machineId, String machineName, String totalPrice) {
        this.orderStatus = orderStatus;
        this.verifyStatus = verifyStatus;
        this.userEmail = userEmail;
        this.userPhoneNo = userPhoneNo;
        this.userName = userName;
        this.userId = userId;
        this.sellerEmail = sellerEmail;
        this.sellerPhoneNo = sellerPhoneNo;
        this.sellerName = sellerName;
        this.sellerId = sellerId;
        this.machineTitle = machineTitle;
        this.regionName = regionName;
        this.machineId = machineId;
        this.machineName = machineName;
        this.totalPrice = totalPrice;
        this.id = id;
    }
}
