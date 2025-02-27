package com.example.usermanagement.dao.orderDao;

import com.example.usermanagement.dao.DBConnection;
import com.example.usermanagement.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDAO implements IOderDAO {
    private static final String INSERT_ORDER = "INSERT INTO Orders (user_id, total_price, status) VALUES (?, ?, ?)";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM Orders WHERE id = ?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM Orders";
    private static final String DELETE_ORDER = "DELETE FROM Orders WHERE id = ?";
    private static final String UPDATE_ORDER = "UPDATE Orders SET user_id = ?, total_price = ?, status = ? WHERE id = ?";

    private DBConnection dbConnection;

    public OrderDAO() {
        dbConnection = new DBConnection();
    }

    @Override
    public void insertOrder(Order order) throws SQLException {
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, order.getUserId());
            stmt.setBigDecimal(2, order.getTotalPrice()); // Dùng BigDecimal thay vì double
            stmt.setString(3, order.getStatus());
            stmt.executeUpdate();

            // Lấy ID tự động tăng
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            }
        }
    }

    @Override
    public Order getOrderById(int id) {
        Order order = null;
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt("id"), rs.getInt("user_id"),
                        rs.getBigDecimal("total_price"), rs.getString("status"),
                        rs.getTimestamp("order_date")); // Lấy order_date
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_ORDERS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id"), rs.getInt("user_id"),
                        rs.getBigDecimal("total_price"), rs.getString("status"),
                        rs.getTimestamp("order_date"))); // Lấy order_date
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean deleteOrder(int id) throws SQLException {
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER)) {
            stmt.setInt(1, order.getUserId());
            stmt.setBigDecimal(2, order.getTotalPrice());
            stmt.setString(3, order.getStatus());
            stmt.setInt(4, order.getId());
            return stmt.executeUpdate() > 0;
        }
    }
    }

