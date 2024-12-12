package com.example.finalmodule.service;

import com.example.finalmodule.model.Category;
import com.example.finalmodule.model.Product;
import com.example.finalmodule.repository.IProductRepository;
import com.example.finalmodule.repository.ProductRepository;

import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
        private final IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<Category> getAllCategories() {
        return productRepository.getAllCategories();
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteProduct(productId);
    }
}
