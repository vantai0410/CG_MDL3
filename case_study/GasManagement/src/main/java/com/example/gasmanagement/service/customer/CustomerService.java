package com.example.gasmanagement.service.customer;

import com.example.gasmanagement.model.Customer;
import com.example.gasmanagement.repository.customer.CustomerRepository;
import com.example.gasmanagement.repository.customer.ICustomerRepository;

import java.util.Collections;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
