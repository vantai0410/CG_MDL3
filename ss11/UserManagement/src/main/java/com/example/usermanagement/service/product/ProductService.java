package com.example.usermanagement.service.product;

import com.example.usermanagement.dao.productDao.IProductDAO;
import com.example.usermanagement.dao.productDao.ProductDAO;
import com.example.usermanagement.model.Product;

import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    IProductDAO productDAO = new ProductDAO();
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {

    }
}
