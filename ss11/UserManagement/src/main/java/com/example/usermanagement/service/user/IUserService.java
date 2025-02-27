package com.example.usermanagement.service.user;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
