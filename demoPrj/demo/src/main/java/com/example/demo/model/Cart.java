package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cart {
    private int cartId;
    private LocalDateTime cartCreate;
    private LocalDateTime cartUpdate;
    private double totalAmount;
    private int userID;
    public Cart() {
    }

    public Cart(int cartId, LocalDateTime cartCreate, LocalDateTime cartUpdate, double totalAmount, int userID) {
        this.cartId = cartId;
        this.cartCreate = cartCreate;
        this.cartUpdate = cartUpdate;
        this.totalAmount = totalAmount;
        this.userID = userID;
    }

    public Cart(LocalDateTime cartCreate, LocalDateTime cartUpdate, double totalAmount, int userID) {
        this.cartCreate = cartCreate;
        this.cartUpdate = cartUpdate;
        this.totalAmount = totalAmount;
        this.userID = userID;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public LocalDateTime getCartCreate() {
        return cartCreate;
    }

    public void setCartCreate(LocalDateTime cartCreate) {
        this.cartCreate = cartCreate;
    }

    public LocalDateTime getCartUpdate() {
        return cartUpdate;
    }

    public void setCartUpdate(LocalDateTime cartUpdate) {
        this.cartUpdate = cartUpdate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getFormattedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return cartCreate.format(formatter);
    }

    public String getFormattedUpdateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return cartUpdate.format(formatter);
    }
}
