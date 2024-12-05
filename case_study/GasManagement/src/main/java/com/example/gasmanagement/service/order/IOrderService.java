package com.example.gasmanagement.service.order;

import com.example.gasmanagement.model.Order;

import java.util.List;

public interface IOrderService {
    int createOrder(Order order);
    List<Order> getAllOrders();
    boolean deleteOrder(String orderId);
}
