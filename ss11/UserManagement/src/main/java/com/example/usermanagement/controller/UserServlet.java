package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.user.IUserService;
import com.example.usermanagement.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private final IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCreateForm":
                showNewForm(req, resp);
                break;
            case "showEditForm":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteUser(req, resp);
                break;
            default:
                    listUser(req, resp);
                break;
        }
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", userService.getUserById(id));
        try {
            req.getRequestDispatcher("/WEB-INF/user/ediUser.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        try {
            resp.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("users", userService.getAllUsers());
        try {
            req.getRequestDispatcher("/WEB-INF/user/listUser.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/user/createUser.jsp").forward(req, resp);
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
        switch (action) {
            case "create":
                insertUser(req, resp);
                break;
            case "edit":
                updateUser(req, resp);
                break;
            default:
                listUser(req, resp);
                break;
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String role = req.getParameter("role");
        Boolean status = Boolean.valueOf(req.getParameter("status"));
        String password = req.getParameter("password");
        User user = new User(id, name, email, country,role, status, password);
        userService.updateUser(user);
        try {
            resp.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String role = req.getParameter("role");
        Boolean status = Boolean.valueOf(req.getParameter("status"));
        String password = req.getParameter("password");
        User newUser = new User(name, email, country,role,status,password);
        userService.addUser(newUser);
        try {
            resp.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

