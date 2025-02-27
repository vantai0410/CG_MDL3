package com.example.usermanagement.dao.productDao;

import com.example.usermanagement.dao.DBConnection;
import com.example.usermanagement.model.Product;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO Product (name, price, description , stock ,import_date) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,name,price,description,stock,import_date from product where id =?";
    private static final String UPDATE_PRODUCT_SQL = "update product set name = ?,price= ?, description =?, stock=?, import_date=? where id = ?;";
    private static final String DELETE_PRODUCT_SQL = "UPDATE product SET status = 0 WHERE id = ?";

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        DBConnection db = new DBConnection();
        Connection connection = db.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                int stock = resultSet.getInt("stock");
                Timestamp importDate = resultSet.getTimestamp("import_date");
                Product product = new Product(id, name, price, description, stock, importDate);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        DBConnection db = new DBConnection();
        Connection connection = db.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                int stock = resultSet.getInt("stock");
                Timestamp importDate = resultSet.getTimestamp("import_date");
                product = new Product(id, name, price, description, stock, importDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void addProduct(Product product) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setTimestamp(5, product.getImportDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateProduct(Product product) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setTimestamp(5, product.getImportDate());
            preparedStatement.setInt(6, product.getId());
            int affectedRows = preparedStatement.executeUpdate(); // Kiểm tra số dòng bị ảnh hưởng
            if (affectedRows > 0) {
                System.out.println("Product updated successfully: " + product);
            } else {
                System.out.println("No product updated. Check ID: " + product.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteProduct(int id) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product marked as deleted (status = 0)");
            } else {
                System.out.println("No product found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
