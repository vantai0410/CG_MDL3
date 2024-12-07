package com.example.gasmanagement.repository.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetailView;
import com.example.gasmanagement.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static final String ADD_ORDER = "INSERT INTO `Order` (OrderID, CustomerID, OrderDate, TotalAmount, Status) " + "values(?,?,?,?,?) ";
    private static final String GET_ALL_ORDERS = "SELECT o.OrderID, o.CustomerID, o.OrderDate, o.Status, \n" +
            "       p.GasName, od.Quantity, od.Price\n" +
            "FROM `Order` o\n" +
            "JOIN `OrderDetail` od ON o.OrderID = od.OrderID\n" +
            "JOIN `Product` p ON od.GasID = p.GasID;" ;

    private static final String DELETE_ORDERDETAIL = "DELETE orderdetail " +
            "FROM orderdetail " +
            "JOIN `order` ON `order`.OrderID = orderdetail.OrderID " +
            "WHERE `order`.OrderID = ?";
    private static final String DELETE_ORDER = "DELETE FROM `order` WHERE OrderID = ?";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM `Order` WHERE OrderID = ?";
    private static final String GET_ORDER_BY_CUSTOMERID = "SELECT * FROM `Order` WHERE CustomerID = ?";
    private static final String UPDATE = "UPDATE `Order` SET Status = ? WHERE OrderID = ?";

    //private final List<Order> orders = new ArrayList<>();
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
    public List<OrderDetailView> getAllOrders() {
        List<OrderDetailView> orders = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_ORDERS);
            while (resultSet.next()) {
                String orderID = resultSet.getString("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                String status = resultSet.getString("Status");
                String gasName = resultSet.getString("GasName");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("Price");
                OrderDetailView orderDetailView = new OrderDetailView(orderID,customerID,orderDate.toLocalDateTime(),status,gasName,quantity,price);
                orders.add(orderDetailView);
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

    @Override
    public Order getOrderbyId(String orderId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID);
            String orderID = null;
            preparedStatement.setString(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderID = resultSet.getString("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                double totalAmount = resultSet.getDouble("TotalAmount");
                String status = resultSet.getString("Status");
                return new Order(orderID, customerID, orderDate.toLocalDateTime(), totalAmount, status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_CUSTOMERID);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String orderID = resultSet.getString("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                double totalAmount = resultSet.getDouble("TotalAmount");
                String status = resultSet.getString("Status");
                Order order = new Order(orderID, customerID, orderDate.toLocalDateTime(), totalAmount, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public boolean updateOrderStatus(String orderId, String status) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, orderId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
