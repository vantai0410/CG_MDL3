package com.example.quanlikhachhang.respository;

import com.example.quanlikhachhang.model.Customer;

import java.util.List;

public interface ICustomerRespository {
    List<Customer> findAll();
}
