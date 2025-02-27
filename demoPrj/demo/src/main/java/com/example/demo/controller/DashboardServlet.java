package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.user.IUserService;
import com.example.demo.service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "dashboard", urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {
    private IUserService iUserService;

    @Override
    public void init() throws ServletException {
        iUserService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền truy cập vào Dashboard Admin!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        session.setAttribute("successMessage", "Đăng nhập thành công");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard/dashboard.jsp");
        dispatcher.forward(req, resp);

    }
}
