package com.example.usermanagement.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String country;
    private String role;
    private boolean status;
    private String password;

    public User() {}

    public User(int id, String name, String email, String country, String role, boolean status, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.role = role;
        this.status = status;
        this.password = password;
    }

    public User(int id, String name, String email, String country, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.role = role;
    }

    public User(String name, String email, String country, String role, boolean status, String password) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.role = role;
        this.status = status;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
