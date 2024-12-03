package com.example.usermanagement.controller;

import com.example.usermanagement.service.IUserService;
import com.example.usermanagement.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private  final IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    //showEditForm(req, resp);
                    break;
                case "delete":
                    //deleteUser(req, resp);
                    break;
                default:
                    listUser(req, resp);
                    break;
            }
        }

//    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
//    }
//
//    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
//    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("users", userService.getAllUsers());
        try {
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("create_form.jsp").forward(req,resp);
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
