package com.example.gasmanagement.service.product;

import com.example.gasmanagement.model.Product;

import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductService productService = new ProductService();
    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
