package com.example.usermanagement.dao.userDao;

import com.example.usermanagement.model.Order;
import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> findAll();
    void add(User user);
    User findById(int id);
    void update(User user);
    void delete(int id);
}
