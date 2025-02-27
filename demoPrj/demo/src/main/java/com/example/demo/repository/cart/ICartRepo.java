package com.example.demo.repository.cart;

import com.example.demo.model.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ICartRepo {
    // Create
    void addCart(Cart cart);

    // Find
    List<Cart> findAllCart();
    Optional<Cart> findCartById(int cartId);
    List<Cart> searchCart(String searchKeyword);

    // Update
    void updateCart(Cart cart);

    // Delete
    boolean deleteCartById(int cartId);

    // Phương thức ánh xạ từ ResultSet sang đối tượng Cart
    Cart mapCart(ResultSet rs) throws SQLException;
}
