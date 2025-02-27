package com.example.usermanagement.service.user;

import com.example.usermanagement.model.User;
import com.example.usermanagement.dao.userDao.IUserDAO;
import com.example.usermanagement.dao.userDao.UserDAO;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();
    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public void addUser(User user) {
        userDAO.add(user);
    }
//
    @Override
    public User getUserById(int id) {
        return userDAO.findById(id);
    }
//
    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }
//
    @Override
    public void deleteUser(int id) {
        userDAO.delete(id);
    }

}
