package com.example.usermanagement.service.product;

import com.example.usermanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    Product getProductById(int id);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
