package com.example.calculator.controller;

import com.example.calculator.model.Calculate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float first=Float.parseFloat(req.getParameter("first"));
        float second=Float.parseFloat(req.getParameter("second"));
        String operator=req.getParameter("operator");
        char operatorChar;

        switch (operator) {
            case "add":
                operatorChar = '+';
                break;
            case "subtract":
                operatorChar = '-';
                break;
            case "multiply":
                operatorChar = '*';
                break;
            case "divide":
                operatorChar = '/';
                break;
            default:
                req.setAttribute("error", "Invalid operator.");
                req.getRequestDispatcher("/result.jsp").forward(req, resp);
                return;
        }

        try {
            float result = Calculate.calculate(first, second, operatorChar);
            req.setAttribute("result", result);
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getMessage());
        }

        req.setAttribute("first", first);
        req.setAttribute("second", second);
        req.setAttribute("operator", operator);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

}
