package com.example.gasmanagement.controller;

import com.example.gasmanagement.model.Order;
import com.example.gasmanagement.service.order.IOrderService;
import com.example.gasmanagement.service.order.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteOrder(req, resp);
                break;
            default:
                listOrders(req, resp);
                break;
        }
    }

    private void listOrders(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("orders", orderService.getAllOrders());
        try {
            req.getRequestDispatcher("/order/order_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) {
        String orderID = req.getParameter("orderID");
        if (orderID != null && !orderID.trim().isEmpty()){
            orderService.deleteOrder(orderID);
        }
        try {
            resp.sendRedirect("/order/order_list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/order/create_list.jsp").forward(req,resp);
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
            action = "";
        }
        try {
            switch (action) {
                case "create_order":
                    insertOrder(req, resp);
                    break;
                case "edit_order":
                    updateOrder(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateOrder(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void insertOrder(HttpServletRequest req, HttpServletResponse resp) {
        String orderID = req.getParameter("orderID");
        int customerID = Integer.parseInt(req.getParameter("customerID"));
        float totalAmount = Float.parseFloat(req.getParameter("totalAmount"));
        String status = req.getParameter("status");
        Order order = new Order(orderID, customerID, LocalDateTime.now(), totalAmount, status);
        orderService.createOrder(order);
        try {
            resp.sendRedirect("/order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
