package com.example.demo.repository.cartItem;

import com.example.demo.model.CartItem;
import com.example.demo.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartItemRepo implements ICartItemRepository{
    // Các câu truy vấn SQL
    private static final String INSERT_CART_ITEM = "INSERT INTO CartItem (quantity, cartPrice, cartTotal, cartId, product_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_CART_ITEM_BY_ID = "SELECT * FROM CartItem WHERE cartItemId = ?";
    private static final String SELECT_CART_ITEMS_BY_CART_ID = "SELECT * FROM CartItem WHERE cartId = ?";
    private static final String SELECT_CART_ITEM_BY_CART_ID_AND_PRODUCT_ID = "SELECT * FROM CartItem WHERE cartId = ? AND product_id = ?";
    private static final String UPDATE_CART_ITEM = "UPDATE CartItem SET quantity = ?, cartPrice = ?, cartTotal = ? WHERE cartItemId = ?";
    private static final String UPDATE_CART_ITEM_QUANTITY_AND_TOTAL = "UPDATE CartItem SET quantity = ?, cartTotal = ? WHERE cartItemId = ?";
    private static final String DELETE_CART_ITEM = "DELETE FROM CartItem WHERE cartItemId = ?";
    private static final String TOTAL_CART = "";

    // Create và Update
    @Override
    public boolean addCartItem(CartItem cartItem) {
        CartItem checkCartItem = findCartItemByCartIdAndProductId(cartItem.getCartId(), cartItem.getProductId());

        if (checkCartItem != null) {
            int newQuantity = checkCartItem.getQuantity() + cartItem.getQuantity();
            double newCartTotal = cartItem.getCartPrice() * newQuantity;

            return updateCartItemQuantityAndTotal(checkCartItem.getCartItemId(), newQuantity, newCartTotal);
        } else {
            return insertNewCartItem(cartItem);
        }
    }

    // Create
    private boolean insertNewCartItem(CartItem cartItem) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_ITEM);

            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setDouble(2, cartItem.getCartPrice());
            preparedStatement.setDouble(3, cartItem.getCartTotal());
            preparedStatement.setInt(4, cartItem.getCartId());
            preparedStatement.setInt(5, cartItem.getProductId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Find theo cartItemId
    @Override
    public CartItem findCartItemById(int cartItemId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ITEM_BY_ID);

            preparedStatement.setInt(1, cartItemId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return mapCartItem(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Find theo cartId
    @Override
    public List<CartItem> findCartItemsByCartId(int cartId) {
        List<CartItem> cartItems = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ITEMS_BY_CART_ID);

            preparedStatement.setInt(1, cartId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                cartItems.add(mapCartItem(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartItems;
    }

    // Find theo cartId và productId
    @Override
    public CartItem findCartItemByCartIdAndProductId(int cartId, int productId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ITEM_BY_CART_ID_AND_PRODUCT_ID);

            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return mapCartItem(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Update
    @Override
    public boolean updateCartItem(CartItem cartItem) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ITEM);

            double cartTotal = cartItem.getCartPrice() * cartItem.getQuantity();

            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setDouble(2, cartItem.getCartPrice());
            preparedStatement.setDouble(3, cartTotal);
            preparedStatement.setInt(4, cartItem.getCartItemId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Update quantity+total
    @Override
    public boolean updateCartItemQuantityAndTotal(int cartItemId, int quantity, double cartTotal) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ITEM_QUANTITY_AND_TOTAL);

            preparedStatement.setInt(1, quantity);
            preparedStatement.setDouble(2, cartTotal);
            preparedStatement.setInt(3, cartItemId);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    @Override
    public boolean deleteCartItemById(int cartItemId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_ITEM);

            preparedStatement.setInt(1, cartItemId);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Calculator Tổng Cart
    @Override
    public double calculateCartItemTotal(int cartItemId) {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        try {
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT cartPrice, quantity FROM CartItem WHERE cartItemId = ?");

            preparedStatement.setInt(1, cartItemId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double cartPrice = rs.getDouble("cartPrice");
                int quantity = rs.getInt("quantity");
                return cartPrice * quantity;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    // Phương thức ánh xạ từ ResultSet sang đối tượng CartItem
    @Override
    public CartItem mapCartItem(ResultSet rs) throws SQLException {
        return new CartItem(
                rs.getInt("cartItemId"),
                rs.getInt("quantity"),
                rs.getDouble("cartPrice"),
                rs.getDouble("cartTotal"),
                rs.getInt("cartId"),
                rs.getInt("product_id")
        );
    }
}
