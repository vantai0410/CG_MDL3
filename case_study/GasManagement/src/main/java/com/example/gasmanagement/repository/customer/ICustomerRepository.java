package com.example.gasmanagement.repository.customer;

import com.example.gasmanagement.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
