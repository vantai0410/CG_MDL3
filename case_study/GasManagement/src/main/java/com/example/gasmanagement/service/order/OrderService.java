package com.example.gasmanagement.service.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.repository.order.IOrderRepository;
import com.example.gasmanagement.repository.order.OrderRepository;

import java.util.Collections;
import java.util.List;

public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository = new OrderRepository();
    @Override
    public int createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public boolean deleteOrder(String orderId) {
        return orderRepository.deleteOrder(orderId);
    }
}
