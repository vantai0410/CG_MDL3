package com.example.gasmanagement.controller;

import com.example.gasmanagement.model.Customer;
import com.example.gasmanagement.service.customer.CustomerService;
import com.example.gasmanagement.service.customer.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private static ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show-create-form":
                //showCreateForm(req,resp);
                break;
            case "show-update-student":
                //showUpdateForm(req,resp);
                break;
            default:
                showCustomerList(req,resp);
        }
    }

    private void showCustomerList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("customers", customerService.getAll());
        try {
            req.getRequestDispatcher("customer_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
