package com.example.demo.model;

public class CartItem {
    private int cartItemId;
    private int quantity;
    private double cartPrice;
    private double  cartTotal;
    private int cartId;
    private int productId;

    public CartItem() {
    }

    public CartItem(int cartItemId, int quantity, double cartPrice, double cartTotal, int cartId, int productId) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.cartPrice = cartPrice;
        this.cartTotal = cartTotal;
        this.cartId = cartId;
        this.productId = productId;
    }


    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
