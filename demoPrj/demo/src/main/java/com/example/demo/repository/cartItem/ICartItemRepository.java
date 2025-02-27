package com.example.demo.repository.cartItem;

import com.example.demo.model.CartItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICartItemRepository {
    // Create
    boolean addCartItem(CartItem cartItem);

    // Find
    CartItem findCartItemById(int cartItemId);
    List<CartItem> findCartItemsByCartId(int cartId);
    CartItem findCartItemByCartIdAndProductId(int cartId, int productId);

    // Update
    boolean updateCartItem(CartItem cartItem);
    boolean updateCartItemQuantityAndTotal(int cartItemId, int quantity, double cartTotal);

    // Delete
    boolean deleteCartItemById(int cartItemId);

    // Calculator
    double calculateCartItemTotal(int cartItemId);

    // Phương thức ánh xạ từ ResultSet sang đối tượng CartItem
    CartItem mapCartItem(ResultSet rs) throws SQLException;
}
