package com.example.gasmanagement.service.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetailView;
import com.example.gasmanagement.repository.order.IOrderRepository;
import com.example.gasmanagement.repository.order.OrderRepository;

import java.util.List;

public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository = new OrderRepository();
    @Override
    public int createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    @Override
    public List<OrderDetailView> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public boolean deleteOrder(String orderId) {
        return orderRepository.deleteOrder(orderId);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.getOrderbyId(orderId);
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderRepository.getOrdersByCustomerId(customerId);
    }

    @Override
    public boolean updateOrder(String orderId, String status) {
        return orderRepository.updateOrderStatus(orderId, status);
    }
}
