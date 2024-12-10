package com.example.gasmanagement.repository.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetail;
import com.example.gasmanagement.model.OrderDetailView;

import java.util.List;

public interface IOrderRepository {
    int createOrder(Order order);
    //int createOrderDetail(OrderDetail orderDetail);
    List<Order> getAllOrder();
    boolean deleteOrder(String orderId);
    Order getOrderbyId(String orderId);
    List<Order> getOrdersByCustomerId(int customerId);
    boolean updateOrderStatus(String orderId, String status);
    List<Order> searchOrders(String orderID, String customerID);
}
