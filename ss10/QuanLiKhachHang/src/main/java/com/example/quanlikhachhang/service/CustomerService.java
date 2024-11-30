package com.example.quanlikhachhang.service;

import com.example.quanlikhachhang.model.Customer;
import com.example.quanlikhachhang.respository.ICustomerRespository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRespository iCustomerRespository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRespository.findAll();
    }
}
