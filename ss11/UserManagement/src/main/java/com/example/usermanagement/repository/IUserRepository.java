package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    void add(User user);

}
