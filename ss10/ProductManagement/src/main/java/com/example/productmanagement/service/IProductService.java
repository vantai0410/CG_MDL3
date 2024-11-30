package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addProduct(Product product);
    void updateProduct(int id, Product product);
    Product findById(int id);
    void deleteProduct(int id);
}
