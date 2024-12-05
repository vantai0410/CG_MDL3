package com.example.gasmanagement.model;

public class Product {
    private String gasID;
    private String gasName;
    private double price;
    private double weight;
    private String gasType;
    private int stockQuantity;

    public Product(String gasID, String gasName, double price, double weight, String gasType, int stockQuantity) {
        this.gasID = gasID;
        this.gasName = gasName;
        this.price = price;
        this.weight = weight;
        this.gasType = gasType;
        this.stockQuantity = stockQuantity;
    }

    public String getGasID() {
        return gasID;
    }

    public void setGasID(String gasID) {
        this.gasID = gasID;
    }

    public String getGasName() {
        return gasName;
    }

    public void setGasName(String gasName) {
        this.gasName = gasName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
