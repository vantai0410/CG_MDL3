package com.example.gasmanagement.repository.product;

import com.example.gasmanagement.model.Product;
import com.example.gasmanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String FIND_ALL_PRODUCTS_SQL = "select * from product";
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_PRODUCTS_SQL);
            while (resultSet.next()) {
                String gasID = resultSet.getString("gasID");
                String gasName = resultSet.getString("gasName");
                double price = resultSet.getDouble("price");
                double weight = resultSet.getDouble("weight");
                String gasType = resultSet.getString("gasType");
                int stockQuantity = resultSet.getInt("stockQuantity");
                Product product = new Product(gasID, gasName, price, weight, gasType, stockQuantity);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
        }

    }
