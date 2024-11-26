package com.example.calculator.controller;

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
        try{
            float result;
            switch (operator) {
                case "add":
                    result = first + second;
                    break;
                case "subtract":
                    result = first - second;
                    break;
                case "multiply":
                    result = first * second;
                    break;
                case "divide":
                    if (second == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    result = first / second;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator.");
            }
            req.setAttribute("result", result);
            req.setAttribute("first", first);
            req.setAttribute("second", second);
            req.setAttribute("operator", operator);
            } catch (ArithmeticException e) {
            req.setAttribute("error", e.getMessage());
        } catch (Exception e) {
            req.setAttribute("error", "Invalid input or operator. Please try again.");
        }
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

}
