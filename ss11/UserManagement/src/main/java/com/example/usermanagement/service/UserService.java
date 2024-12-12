package com.example.usermanagement.service;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.IUserRepository;
import com.example.usermanagement.repository.UserRepository;

import java.util.Collections;
import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.add(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userRepository.searchByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }
}
