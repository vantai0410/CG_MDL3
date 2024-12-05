package com.example.gasmanagement.repository.product;

import com.example.gasmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
}
