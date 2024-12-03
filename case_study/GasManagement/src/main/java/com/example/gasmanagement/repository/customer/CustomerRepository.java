package com.example.gasmanagement.repository.customer;

import com.example.gasmanagement.model.Customer;
import com.example.gasmanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static final String FIND_ALL_CUSTOMERS = "select * from customer";
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_CUSTOMERS);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer( name, phone, email, address);
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
