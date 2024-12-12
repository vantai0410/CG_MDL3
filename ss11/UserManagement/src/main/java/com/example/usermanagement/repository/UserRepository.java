package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_BY_COUNTRY_SQL = "SELECT * FROM users WHERE country LIKE ?;";
    private static final String SORT_BY_NAME_SQL = "SELECT * FROM users ORDER BY name ASC;";
    @Override
    public List<User> findAll() {
        List<User> users =new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository(); // tao ket noi
        Connection conn = baseRepository.getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void add(User user) {
        BaseRepository baseRepository = new BaseRepository(); // tao ket noi
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void update(User user) {
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> users = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SEARCH_BY_COUNTRY_SQL);
            preparedStatement.setString(1, "%" + country + "%"); // Tìm kiếm với từ khóa gần đúng
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String countryName = rs.getString("country");
                users.add(new User(id, name, email, countryName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> sortByName() {
        List<User> users = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SORT_BY_NAME_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}

