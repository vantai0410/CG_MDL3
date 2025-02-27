package com.example.demo.model;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Product {
    private int product_id;
    private String product_name;
    private String product_description;
    private double product_price;
    private int product_stock;
    private String product_img;
    private LocalDateTime  product_createdDate;
    private LocalDateTime product_updateDate;
    private int categories_id;
    private String categories_name;

    public Product() {
    }

    public Product(int product_id, String product_name, String product_description, double product_price, int product_stock, String product_img, LocalDateTime product_createdDate, LocalDateTime product_updateDate, int categories_id, String categories_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_img = product_img;
        this.product_createdDate = product_createdDate;
        this.product_updateDate = product_updateDate;
        this.categories_id = categories_id;
        this.categories_name = categories_name;
    }

    public Product(String product_name, String product_description, double product_price, int product_stock, String product_img, LocalDateTime product_createdDate, LocalDateTime product_updateDate, int categories_id, String categories_name) {
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_img = product_img;
        this.product_createdDate = product_createdDate;
        this.product_updateDate = product_updateDate;
        this.categories_id = categories_id;
        this.categories_name = categories_name;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public LocalDateTime getProduct_createdDate() {
        return product_createdDate;
    }

    public void setProduct_createdDate(LocalDateTime product_createdDate) {
        this.product_createdDate = product_createdDate;
    }

    public LocalDateTime getProduct_updateDate() {
        return product_updateDate;
    }

    public void setProduct_updateDate(LocalDateTime product_updateDate) {
        this.product_updateDate = product_updateDate;
    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }

    public String getFormattedPrice() {
        NumberFormat formatPrice = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return formatPrice.format(product_price);
    }

    public String getFormattedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return product_createdDate.format(formatter);
    }

    public String getFormattedUpdateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return product_updateDate.format(formatter);
    }
}
