package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Sản phẩm A", 1000.0, "Mô tả sản phẩm A", "Nhà sản xuất A"));
        products.add(new Product(2, "Sản phẩm B", 2000.0, "Mô tả sản phẩm B", "Nhà sản xuất B"));
        products.add(new Product(3, "Sản phẩm C", 3000.0, "Mô tả sản phẩm C", "Nhà sản xuất C"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        int index = findById(id).getId();
        products.set(index - 1, product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
        }

    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void searchProduct(String name, Product product) {

    }
}
