package com.example.demo.repository.cart;

import com.example.demo.model.Cart;
import com.example.demo.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartRepo implements ICartRepo {
    // Các câu truy vấn SQL
    private static final String INSERT_CART = "INSERT INTO Cart (cartCreate, cartUpdate, totalAmount, userID) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_CARTS = "SELECT * FROM Cart";
    private static final String SELECT_CART_BY_ID = "SELECT * FROM Cart WHERE cartId = ?";
    private static final String SEARCH_CART = "SELECT c.cartId, c.cartCreate, c.cartUpdate, c.totalAmount, c.userID \n" +
            "FROM Cart c \n" +
            "JOIN Users u ON c.userID = u.userID \n" +
            "WHERE c.cartId LIKE ? OR c.userID LIKE ? OR u.username LIKE ? OR u.fullName LIKE ?";
    private static final String UPDATE_CART = "UPDATE Cart SET cartCreate = ?, cartUpdate = ?, totalAmount = ?, userID = ? WHERE cartId = ?";
    private static final String DELETE_CART_BY_ID = "DELETE FROM Cart WHERE cartId = ?";

    // Create
    @Override
    public void addCart(Cart cart) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(cart.getCartCreate()));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(cart.getCartUpdate()));
            preparedStatement.setDouble(3, cart.getTotalAmount());
            preparedStatement.setInt(4, cart.getUserID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /// Find
    @Override
    public List<Cart> findAllCart() {
        List<Cart> carts = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                carts.add(mapCart(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }

    @Override
    public Optional<Cart> findCartById(int cartId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID);

            preparedStatement.setInt(1, cartId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapCart(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Cart> searchCart(String searchKeyword) {
        List<Cart> carts = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CART);
            String searchPattern = "%" + searchKeyword + "%";
            preparedStatement.setString(1, searchPattern); // cartId
            preparedStatement.setString(2, searchPattern); // userID
            preparedStatement.setString(3, searchPattern); // username
            preparedStatement.setString(4, searchPattern); // fullName
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                carts.add(mapCart(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }

    // Update
    @Override
    public void updateCart(Cart cart) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(cart.getCartCreate()));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(cart.getCartUpdate()));
            preparedStatement.setDouble(3, (cart.getTotalAmount()));
            preparedStatement.setInt(4, cart.getUserID());
            preparedStatement.setInt(5, cart.getCartId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /// Delete
    public boolean deleteCartById(int cartId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_BY_ID);

            preparedStatement.setInt(1, cartId);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cart mapCart(ResultSet rs) throws SQLException {
        return new Cart(
                rs.getInt("cartId"),
                rs.getTimestamp("cartCreate").toLocalDateTime(),
                rs.getTimestamp("cartUpdate").toLocalDateTime(),
                rs.getDouble("totalAmount"),
                rs.getInt("userID")
        );
    }
}
