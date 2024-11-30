package com.example.quanlikhachhang.respository;

import com.example.quanlikhachhang.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRespository implements ICustomerRespository{
    private static List<Customer> customerList ;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerList.add(new Customer(2, "Mary", "mary@codegym.vn", "Hanoi"));
        customerList.add(new Customer(3, "Jack", "jack@codegym.vn", "Hanoi"));
        customerList.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

}
