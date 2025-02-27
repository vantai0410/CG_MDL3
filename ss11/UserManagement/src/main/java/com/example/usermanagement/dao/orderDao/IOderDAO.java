package com.example.usermanagement.dao.orderDao;

import com.example.usermanagement.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOderDAO {
    void insertOrder(Order order) throws SQLException;
    Order getOrderById(int id);
    List<Order> selectAllOrders();
    boolean deleteOrder(int id) throws SQLException;
    boolean updateOrder(Order order) throws SQLException;
}
