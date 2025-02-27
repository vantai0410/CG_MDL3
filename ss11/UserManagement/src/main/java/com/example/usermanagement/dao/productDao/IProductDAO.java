package com.example.usermanagement.dao.productDao;

import com.example.usermanagement.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
