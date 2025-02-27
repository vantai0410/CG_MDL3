package com.example.demo.repository.product;

import com.example.demo.model.Product;
import com.example.demo.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements IProductRepository {
    // Các câu truy vấn SQL
    private static final String INSERT_PRODUCTS = "INSERT INTO Products (product_name, product_description, product_price, product_stock, product_img, product_createdDate, product_updateDate, categories_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_PRODUCTS = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, p.product_stock, p.product_img, p.product_createdDate, p.product_updateDate, c.categories_id, c.categories_name " +
            "FROM Products p " +
            "JOIN Categories c ON p.categories_id = c.categories_id";

    private static final String SELECT_PRODUCT_BY_ID = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, p.product_stock, p.product_img, p.product_createdDate, p.product_updateDate, c.categories_id, c.categories_name " +
            "FROM Products p " +
            "JOIN Categories c ON p.categories_id = c.categories_id " +
            "WHERE p.product_id = ?";

    private static final String SELECT_PRODUCT_BY_NAME = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, p.product_stock, p.product_img, p.product_createdDate, p.product_updateDate, c.categories_id, c.categories_name " +
            "FROM Products p " +
            "JOIN Categories c ON p.categories_id = c.categories_id " +
            "WHERE p.product_name = ?";

    private static final String SEARCH_PRODUCT = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, p.product_stock, p.product_img, p.product_createdDate, p.product_updateDate, \n" +
            "       c.categories_id, c.categories_name\n" +
            "FROM Products p\n" +
            "JOIN Categories c ON p.categories_id = c.categories_id\n" +
            "WHERE 1=1\n" +
            "  AND (p.product_name LIKE ? OR p.product_price LIKE ? OR p.product_stock LIKE ? OR c.categories_name LIKE ?)\n";

    private static final String UPDATE_PRODUCTS = "UPDATE Products SET product_name = ?, product_description = ?, product_price = ?, product_stock = ?, product_img = ?, product_createdDate = ?, product_updateDate = ?, categories_id = ? WHERE product_id = ?";

    private static final String DELETE_PRODUCTS_BY_ID = "DELETE FROM Products WHERE product_id = ?";

    private static final String DELETE_PRODUCTS_BY_NAME = "DELETE FROM Products WHERE product_name = ?";
    @Override
    public void addProduct(Product product) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS);
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setString(2, product.getProduct_description());
            preparedStatement.setDouble(3, product.getProduct_price());
            preparedStatement.setInt(4, product.getProduct_stock());
            preparedStatement.setString(5, product.getProduct_img());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(product.getProduct_createdDate()));
            preparedStatement.setTimestamp(7, Timestamp.valueOf(product.getProduct_updateDate()));
            preparedStatement.setInt(8, product.getCategories_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;

    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(mapProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
        }

        @Override
    public Optional<Product> findProductById(int product_id) {
            BaseRepository baseRepository = new BaseRepository();
            Connection connection = baseRepository.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
                preparedStatement.setInt(1, product_id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    return Optional.of(mapProduct(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return Optional.empty();
        }

            @Override
    public Optional<Product> findProductByName(String product_name) {
                BaseRepository baseRepository = new BaseRepository();
                Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1,product_name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
                return Optional.empty();
    }

    @Override
    public List<Product> searchProduct(String searchKeyword) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        List<Product> products = new ArrayList<>();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
            String searchPattern = "%" + searchKeyword + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);
            preparedStatement.setString(3, searchPattern);
            preparedStatement.setString(4, searchPattern);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(mapProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS);
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setString(2, product.getProduct_description());
            preparedStatement.setDouble(3, product.getProduct_price());
            preparedStatement.setInt(4, product.getProduct_stock());
            preparedStatement.setString(5, product.getProduct_img());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(product.getProduct_createdDate()));
            preparedStatement.setTimestamp(7, Timestamp.valueOf(product.getProduct_updateDate()));
            preparedStatement.setInt(8, product.getCategories_id());
            preparedStatement.setInt(9, product.getProduct_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteProductById(int product_id) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTS_BY_ID);
            preparedStatement.setInt(1, product_id);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteProductByName(String product_name) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTS_BY_NAME);
            preparedStatement.setString(1, product_name);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product mapProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getString("product_description"),
                rs.getDouble("product_price"),
                rs.getInt("product_stock"),
                rs.getString("product_img"),
                rs.getTimestamp("product_createdDate").toLocalDateTime(),
                rs.getTimestamp("product_updateDate").toLocalDateTime(),
                rs.getInt("categories_id"),
                rs.getString("categories_name")
        );
    }
}
