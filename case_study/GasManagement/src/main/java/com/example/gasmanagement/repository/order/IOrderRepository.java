package com.example.gasmanagement.repository.order;

import com.example.gasmanagement.model.Order;

import java.util.List;

public interface IOrderRepository {
    int createOrder(Order order);
    List<Order> getAllOrders();
    boolean deleteOrder(String orderId);

}
