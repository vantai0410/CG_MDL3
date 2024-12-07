package com.example.gasmanagement.repository.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetailView;

import java.util.List;

public interface IOrderRepository {
    int createOrder(Order order);
    List<OrderDetailView> getAllOrders();
    boolean deleteOrder(String orderId);
    Order getOrderbyId(String orderId);
    List<Order> getOrdersByCustomerId(int customerId);
    boolean updateOrderStatus(String orderId, String status);
}
