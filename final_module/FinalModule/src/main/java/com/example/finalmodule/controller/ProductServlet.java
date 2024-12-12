package com.example.finalmodule.controller;

import com.example.finalmodule.model.Product;
import com.example.finalmodule.service.IProductService;
import com.example.finalmodule.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show-create-form":
                showCreateForm(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            default:
                showProductList(req,resp);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("categories", productService.getAllCategories());
        try {
            req.getRequestDispatcher("create_form.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("products", productService.getAllProducts());
        try {
            req.getRequestDispatcher("product_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-product":
                addNewProduct(req,resp);
                break;
            case "update-student":
                //showUpdateForm(req,resp);
                break;
        }
    }

    private void addNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String priceParam = req.getParameter("price");
        String quantityParam = req.getParameter("quantity");
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        String categoryParam = req.getParameter("category");

        String errorMessage = null;
        if (name == null || name.trim().isEmpty()) {
            errorMessage = "Name is required.";
        } else if (priceParam == null || priceParam.isEmpty() || Double.parseDouble(priceParam) < 10000000) {
            errorMessage = "Price must be greater than 10,000,000.";
        } else if (quantityParam == null || quantityParam.isEmpty() || Integer.parseInt(quantityParam) <= 0) {
            errorMessage = "Quantity must be a positive number.";
        } else if (color == null || color.isEmpty()) {
            errorMessage = "Color is required.";
        }

        if (errorMessage != null) {
            req.setAttribute("error", errorMessage);
            try {
                req.getRequestDispatcher("create_form.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        double price = Double.parseDouble(priceParam);
        int quantity = Integer.parseInt(quantityParam);
        int categoryId = Integer.parseInt(categoryParam);

        Product product = new Product(name, price, quantity, color, description, categoryId);

        productService.addProduct(product);

        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
