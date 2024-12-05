package com.example.gasmanagement.repository.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.repository.BaseRepository;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static final String ADD_ORDER = "INSERT INTO `Order` (OrderID, CustomerID, OrderDate, TotalAmount, Status) " +"values(?,?,?,?,?) ";
    private static final String GET_ALL_ORDERS = "SELECT * FROM `Order`";
    private static final String DELETE_ORDERDETAIL = "DELETE orderdetail " +
                                                    "FROM orderdetail " +
                                        "JOIN `order` ON `order`.OrderID = orderdetail.OrderID " +
                                        "WHERE `order`.OrderID = ?";
    private static final String DELETE_ORDER = "DELETE FROM `order` WHERE OrderID = ?";
    @Override
    public int createOrder(Order order) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setString(1, order.getOrderID());
            preparedStatement.setInt(2, order.getCustomerID());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(order.getOrderDate()));
            preparedStatement.setDouble(4, order.getTotalAmount());
            preparedStatement.setString(5, order.getStatus());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_ORDERS);
            while(resultSet.next()){
                String orderID = resultSet.getString("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                double totalAmount = resultSet.getDouble("TotalAmount");
                String status = resultSet.getString("Status");
                Order order = new Order(orderID,customerID, orderDate.toLocalDateTime(),totalAmount,status);
                orders.add(order);
            }
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public boolean deleteOrder(String orderId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDERDETAIL);
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
