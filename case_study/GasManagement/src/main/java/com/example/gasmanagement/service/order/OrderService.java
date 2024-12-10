package com.example.gasmanagement.service.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetail;
import com.example.gasmanagement.model.OrderDetailView;
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
        return orderRepository.getAllOrder();
    }

//    @Override
//    public int createOrderDetail(OrderDetail orderDetail) {
//        return orderRepository.createOrderDetail(orderDetail);
//    }




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

    @Override
    public List<Order> searchOrders(String orderID, String customerID) {
        return orderRepository.searchOrders(orderID, customerID);
    }
}
