package com.example.demo.repository.user;

import com.example.demo.model.User;
import com.example.demo.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    // Các câu truy vấn SQL
    private static final String INSERT_USER = "INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM Users";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM Users WHERE userID = ?";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM Users WHERE username = ? AND password = ?";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM Users WHERE username = ?";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM Users WHERE email = ?";
    private static final String SEARCH_USERS = "SELECT * FROM Users WHERE 1=1 " +
            "AND (username LIKE ? OR fullName LIKE ? OR email LIKE ? OR phone LIKE ? OR address LIKE ? OR userRole LIKE ? OR userStatus LIKE ?)";
    private static final String UPDATE_USER = "UPDATE Users SET username = ?, password = ?, fullName = ?, email = ?, phone = ?, address = ?, avatar = ?, userCreatedDate = ?, userUpdatedDate = ?, userStatus = ?, userRole = ? WHERE userID = ?";
    private static final String DELETE_USER_BY_USERNAME = "DELETE FROM Users WHERE username = ?";
    @Override
    public void addUser(User user) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getAvatar());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(user.getUserCreatedDate()));
            preparedStatement.setTimestamp(9, Timestamp.valueOf(user.getUserUpdatedDate()));
            preparedStatement.setString(10, user.getUserStatus());
            preparedStatement.setString(11, user.getUserRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public Optional<User> findUserByID(int userID) {
            BaseRepository baseRepository = new BaseRepository();
            Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return Optional.empty();
        }

    @Override
    public List<User> findAllUsers() {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(mapUser(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();

        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<User> searchUsers(String searchKeyword) {
        List<User> users = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS);
            String searchPattern = "%" + searchKeyword + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);
            preparedStatement.setString(3, searchPattern);
            preparedStatement.setString(4, searchPattern);
            preparedStatement.setString(5, searchPattern);
            preparedStatement.setString(6, searchPattern);
            preparedStatement.setString(7, searchPattern);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(mapUser(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getAvatar());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(user.getUserCreatedDate()));
            preparedStatement.setTimestamp(9, Timestamp.valueOf(user.getUserUpdatedDate()));
            preparedStatement.setString(10, user.getUserStatus());
            preparedStatement.setString(11, user.getUserRole());
            preparedStatement.setInt(12, user.getUserID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_USERNAME);

            preparedStatement.setString(1, username);
            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User mapUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("userID"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fullName"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getString("avatar"),
                rs.getTimestamp("userCreatedDate").toLocalDateTime(),
                rs.getTimestamp("userUpdatedDate").toLocalDateTime(),
                rs.getString("userStatus"),
                rs.getString("userRole")
        );
    }
}
