package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    void add(User user);
    User findById(int id);
    void update(User user);
    void delete(int id);
    List<User> searchByCountry(String country);
    List<User> sortByName();

}
