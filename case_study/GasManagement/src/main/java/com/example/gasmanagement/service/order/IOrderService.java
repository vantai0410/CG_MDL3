package com.example.gasmanagement.service.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetailView;

import java.util.List;

public interface IOrderService {
    int createOrder(Order order);
    List<OrderDetailView> getAllOrders();
    boolean deleteOrder(String orderId);
    Order getOrderById(String orderId);
    List<Order> getOrdersByCustomerId(int customerId);
    boolean updateOrder(String orderId, String status);
}
