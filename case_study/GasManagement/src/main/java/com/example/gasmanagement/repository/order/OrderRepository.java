package com.example.gasmanagement.repository.order;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.model.OrderDetail;
import com.example.gasmanagement.model.OrderDetailView;
import com.example.gasmanagement.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static final String ADD_ORDER = "INSERT INTO `Order` (OrderID, CustomerID, OrderDate, TotalAmount, Status) " + "values(?,?,?,?,?) ";
    //private static final String ADD_ORDER_DETAIL = "INSERT INTO `OrderDetail` (OrderID, GasID, Quantity, Price)" + "VALUES (?, ?, ?, ?)";
//    private static final String GET_ALL_ORDERS = "SELECT o.OrderID, o.CustomerID, o.OrderDate, o.Status, \n" +
//            "       p.GasName, od.Quantity, od.Price\n" +
//            "FROM `Order` o\n" +
//            "JOIN `OrderDetail` od ON o.OrderID = od.OrderID\n" +
//            "JOIN `Product` p ON od.GasID = p.GasID;" ;
    private  static  final String GET_ORDER = "SELECT * FROM `Order`";

    private static final String DELETE_ORDERDETAIL = "DELETE orderdetail " +
            "FROM orderdetail " +
            "JOIN `order` ON `order`.OrderID = orderdetail.OrderID " +
            "WHERE `order`.OrderID = ?";
    private static final String DELETE_ORDER = "DELETE FROM `order` WHERE OrderID = ?";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM `Order` WHERE OrderID = ?";
    private static final String GET_ORDER_BY_CUSTOMERID = "SELECT * FROM `Order` WHERE CustomerID = ?";
    private static final String UPDATE = "UPDATE `Order` SET Status = ? WHERE OrderID = ?";
    private static final String SEARCH_ORDERS = "SELECT * FROM `Order` WHERE " +
            "(? IS NULL OR OrderID = ?) AND (? IS NULL OR CustomerID = ?)";

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
    public List<Order> getAllOrder() {
        List<Order> orders = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String orderID = resultSet.getString("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                double totalAmount = resultSet.getDouble("TotalAmount");
                String status = resultSet.getString("Status");
                orders.add(new Order(orderID, customerID, orderDate.toLocalDateTime(), totalAmount, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

//    @Override
//    public int createOrderDetail(OrderDetail orderDetail) {
//        BaseRepository baseRepository = new BaseRepository();
//        Connection connection = baseRepository.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER_DETAIL);
//            preparedStatement.setString(1,orderDetail.getOrderID());
//            preparedStatement.setString(2,orderDetail.getGasID());
//            preparedStatement.setInt(3,orderDetail.getQuantity());
//            preparedStatement.setDouble(4,orderDetail.getPrice());
//            return preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }



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
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderId = resultSet.getString("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                double totalAmount = resultSet.getDouble("TotalAmount");
                String status = resultSet.getString("Status");
                return new Order(orderId, customerID, orderDate.toLocalDateTime(), totalAmount, status);
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

    @Override
    public List<Order> searchOrders(String orderID, String customerID) {
        List<Order> orders = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ORDERS);
            preparedStatement.setString(1, orderID == null || orderID.isEmpty() ? null : orderID);
            preparedStatement.setString(2, orderID == null || orderID.isEmpty() ? null : orderID);
            preparedStatement.setString(3, customerID == null || customerID.isEmpty() ? null : customerID);
            preparedStatement.setString(4, customerID == null || customerID.isEmpty() ? null : customerID);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String resultOrderID = resultSet.getString("OrderID");
                int resultCustomerID = resultSet.getInt("CustomerID");
                Timestamp orderDate = resultSet.getTimestamp("OrderDate");
                double totalAmount = resultSet.getDouble("TotalAmount");
                String status = resultSet.getString("Status");

                orders.add(new Order(resultOrderID, resultCustomerID, orderDate.toLocalDateTime(), totalAmount, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;

}
}
