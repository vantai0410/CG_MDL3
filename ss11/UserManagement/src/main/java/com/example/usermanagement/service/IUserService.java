package com.example.usermanagement.service;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> searchByCountry(String country);
    List<User> sortByName();

}
