package com.example.finalmodule.service;

import com.example.finalmodule.model.Category;
import com.example.finalmodule.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    List<Category> getAllCategories();
    void deleteProduct(int productId);
}
