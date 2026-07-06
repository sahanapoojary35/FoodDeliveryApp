package com.foodapp.model;

/*
 * User Model Class
 * ----------------
 * This class represents one record from the 'users' table.
 * It is also called a POJO (Plain Old Java Object).
 */

import java.time.LocalDateTime;

public class User {

    // Variables matching the database columns

    private int userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String role;
    private LocalDateTime createdDate;

    // Default Constructor
    public User() {

    }

    // Parameterized Constructor
    public User(int userId, String name, String email, String password,
            String phoneNumber, String address, String role,
            LocalDateTime createdDate) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.createdDate = createdDate;
    }

    // Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    // toString()

    @Override
    public String toString() {
        return "User [userId=" + userId +
                ", name=" + name +
                ", email=" + email +
                ", password=" + password +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", role=" + role +
                ", createdDate=" + createdDate + "]";
    }

}
