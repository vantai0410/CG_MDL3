package com.example.usermanagement.service.order;

import com.example.usermanagement.dao.orderDao.OrderDAO;
import com.example.usermanagement.model.Order;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class OrderService implements IOrderService {
    private final OrderDAO orderDao;

    public OrderService() {
        this.orderDao = new OrderDAO();
    }
    @Override
    public void placeOrder(Order order) throws SQLException {
        orderDao.insertOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.selectAllOrders();
    }

    @Override
    public boolean cancelOrder(int id) throws SQLException {
        return orderDao.deleteOrder(id);
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return orderDao.updateOrder(order);
    }
}
