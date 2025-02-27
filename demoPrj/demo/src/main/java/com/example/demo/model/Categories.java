package com.example.demo.model;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Categories {
    private int categories_id;
    private String categories_name;
    private String categories_img;
    private LocalDateTime categories_createdDate;
    private LocalDateTime categories_updatedDate;

    public Categories() {
    }
    public Categories(int categories_id, String categories_name, String categories_img, LocalDateTime categories_createdDate, LocalDateTime categories_updatedDate) {
        this.categories_id = categories_id;
        this.categories_name = categories_name;
        this.categories_img = categories_img;
        this.categories_createdDate = categories_createdDate;
        this.categories_updatedDate = categories_updatedDate;
    }

    public Categories(String categories_name, String categories_img, LocalDateTime categories_createdDate, LocalDateTime categories_updatedDate) {
        this.categories_name = categories_name;
        this.categories_img = categories_img;
        this.categories_createdDate = categories_createdDate;
        this.categories_updatedDate = categories_updatedDate;
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

    public String getCategories_img() {
        return categories_img;
    }

    public void setCategories_img(String categories_img) {
        this.categories_img = categories_img;
    }

    public LocalDateTime getCategories_createdDate() {
        return categories_createdDate;
    }

    public void setCategories_createdDate(LocalDateTime categories_createdDate) {
        this.categories_createdDate = categories_createdDate;
    }

    public LocalDateTime getCategories_updatedDate() {
        return categories_updatedDate;
    }

    public void setCategories_updatedDate(LocalDateTime categories_updatedDate) {
        this.categories_updatedDate = categories_updatedDate;
    }


    public String getFormattedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return categories_createdDate.format(formatter);
    }

    public String getFormattedUpdateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return categories_updatedDate.format(formatter);
    }
}
