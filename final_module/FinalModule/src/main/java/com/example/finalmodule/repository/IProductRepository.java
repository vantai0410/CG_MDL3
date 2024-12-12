package com.example.finalmodule.repository;

import com.example.finalmodule.model.Category;
import com.example.finalmodule.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    void addProduct(Product product);
    List<Category> getAllCategories();
    void deleteProduct(int productId);
}
