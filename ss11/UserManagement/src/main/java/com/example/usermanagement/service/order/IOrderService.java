package com.example.usermanagement.service.order;

import com.example.usermanagement.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    void placeOrder(Order order) throws SQLException;
    Order getOrderById(int id);
    List<Order> getAllOrders();
    boolean cancelOrder(int id) throws SQLException;
    boolean updateOrder(Order order) throws SQLException;
}
