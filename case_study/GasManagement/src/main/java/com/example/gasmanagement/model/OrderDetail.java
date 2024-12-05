package com.example.gasmanagement.model;

public class OrderDetail {
    private String orderDetailID;
    private String orderID;
    private String gasID;
    private int quantity;
    private double price;

    public OrderDetail(String orderDetailID, String orderID, String gasID, int quantity, double price) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.gasID = gasID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getGasID() {
        return gasID;
    }

    public void setGasID(String gasID) {
        this.gasID = gasID;
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
