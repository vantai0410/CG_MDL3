package com.example.gasmanagement.model;

import java.time.LocalDateTime;

public class OrderDetailView {
    private String orderID;
    private int customerID;
    private LocalDateTime orderDate;
    private String status;
    private String productName;
    private int quantity;
    private double price;

    public OrderDetailView(String orderID, int customerID, LocalDateTime orderDate, String status, String productName, int quantity, double price) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.status = status;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
