package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void addProduct(Product product);
    void updateProduct(int id, Product product);
    Product findById(int id);
    void deleteProduct(int id);
    Product findByName(String name);
    void searchProduct(String name,Product product);
}
