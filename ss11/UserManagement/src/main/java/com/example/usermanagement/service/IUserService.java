package com.example.usermanagement.service;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void addUser(User user);
}
