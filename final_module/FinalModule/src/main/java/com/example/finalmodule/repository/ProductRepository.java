package com.example.finalmodule.repository;

import com.example.finalmodule.model.Category;
import com.example.finalmodule.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCTS =
            "SELECT p.product_id, p.product_name, p.price, p.quantity, p.color, c.category_name AS categoryName " +
                    "FROM Product p " +
                    "JOIN Category c ON p.category_id = c.category_id";


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository(); // tao ket noi
        Connection conn = baseRepository.getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String categoryName = resultSet.getString("categoryName");
                Product product = new Product(productId, productName, price, quantity, color, categoryName);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void addProduct(Product product) {
        String query = "INSERT INTO Product (product_name, price, quantity, color, description, category_id) VALUES (?, ?, ?, ?, ?, ?)";
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        String query = "SELECT category_id, category_name FROM Category";
        List<Category> categories = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void deleteProduct(int productId) {
        String query = "DELETE FROM Product WHERE product_id = ?";
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting product with ID " + productId);
        }
    }
}
