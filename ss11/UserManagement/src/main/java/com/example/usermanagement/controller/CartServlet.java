package com.example.usermanagement.controller;

import com.example.usermanagement.model.CartItem;
import com.example.usermanagement.model.Order;
import com.example.usermanagement.model.Product;
import com.example.usermanagement.service.order.EmailService;
import com.example.usermanagement.service.order.OrderService;
import com.example.usermanagement.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "view"; // Mặc định hiển thị giỏ hàng
        }

        switch (action) {
            case "view":
                viewCart(req, resp);
                break;
            case "viewProducts":
                viewProducts(req, resp);
                break;
            case "remove":
                removeFromCart(req, resp);
                break;
            default:
                resp.sendRedirect("error.jsp");
                break;
        }
    }

    private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        BigDecimal totalPrice = BigDecimal.ZERO;
        ;
        if (cart != null) {
            for (CartItem item : cart.values()) {
                totalPrice = totalPrice.add(item.getSubtotal());

            }
        }

        req.setAttribute("cartTotal", String.format("%,.2f VND", totalPrice)); // Định dạng số tiền
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    private void viewProducts(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products = productService.getAllProducts();

        // Gửi danh sách sản phẩm tới `productListCart.jsp`
        req.setAttribute("products", products);
        try {
            req.getRequestDispatcher("/WEB-INF/order/productListCart.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "add"; // Mặc định là thêm vào giỏ hàng
        }

        switch (action) {
            case "add":
                addToCart(req, resp);
                break;
            case "update":
                updateCart(req, resp);
                break;
            case "checkout":
                checkout(req, resp);
                break;
            default:
                resp.sendRedirect("error.jsp");
                break;
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new java.util.HashMap<>();
            session.setAttribute("cart", cart);
        }

        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Product product = productService.getProductById(productId);
        if (product != null) {
            CartItem item = cart.get(productId);
            if (item != null) {
                // Nếu sản phẩm đã có trong giỏ, cập nhật số lượng
                item.setQuantity(item.getQuantity() + quantity);
            } else {
                // Nếu chưa có sản phẩm, thêm mới vào giỏ
                item = new CartItem(productId, product.getName(), quantity, BigDecimal.valueOf(product.getPrice()));
                cart.put(productId, item);
            }
        }

        resp.sendRedirect("/cart.jsp");
    }

    private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            if (quantity > 0) {
                CartItem item = cart.get(productId);
                if (item != null) {
                    item.setQuantity(quantity);
                }
            } else {
                removeFromCart(req, resp);
            }
        }

        resp.sendRedirect("cart.jsp");
    }

    private void removeFromCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            cart.remove(productId);
        }

        resp.sendRedirect("cart.jsp");
    }

    private void checkout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        int userId = 1; // Giả sử user đã đăng nhập
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (CartItem item : cart.values()) {
            totalPrice = totalPrice.add(item.getSubtotal());
        }

        Order order = new Order(userId, totalPrice, "Pending");
        try {
            orderService.placeOrder(order);
            session.removeAttribute("cart"); // Xóa giỏ hàng sau khi thanh toán

            // Lấy email người dùng (giả sử có trong session)
            String userEmail = (String) session.getAttribute("userEmail");
            if (userEmail == null) {
                userEmail = "bahunglecanh@gmail.com"; // Giá trị mặc định nếu không có email
            }

            // Gửi email xác nhận đơn hàng
            EmailService emailService = new EmailService();
            String subject = "Xác nhận đơn hàng";
            String body = "Cảm ơn bạn đã đặt hàng!\nTổng tiền: " + totalPrice + " VND\nChúng tôi sẽ xử lý đơn hàng sớm nhất.";
            emailService.sendOrderConfirmation(userEmail, subject, body);

            // Chuyển hướng đến trang thành công
            resp.sendRedirect(req.getContextPath() + "/cart?action=success");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                req.getRequestDispatcher("/WEB-INF/order/error.jsp").forward(req, resp);
            } catch (ServletException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
