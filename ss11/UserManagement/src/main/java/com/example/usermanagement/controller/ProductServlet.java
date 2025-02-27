package com.example.usermanagement.controller;

import com.example.usermanagement.model.Product;
import com.example.usermanagement.service.product.IProductService;
import com.example.usermanagement.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ProductServlet", value = "/product")
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
            case "showCreateFormProduct":
                showNewFormProduct(req, resp);
                break;
            case "showEditFormProduct":
                showEditFormProduct(req, resp);
                break;
            case "showDeleteFormProduct":
                showDeleteFormProduct(req, resp);
                break;
            default:
                listProduct(req, resp);
                break;
        }
    }

    private void showDeleteFormProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("products", productService.getProductById(id));
        try{
            req.getRequestDispatcher("/WEB-INF/product/deleteProduct.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("products", productService.getAllProducts());
        try{
            req.getRequestDispatcher("/WEB-INF/product/listProduct.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showEditFormProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("product", productService.getProductById(id));
        try {
            req.getRequestDispatcher("/WEB-INF/product/editProduct.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewFormProduct(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/product/createProduct.jsp").forward(req,resp);
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
            case "createProduct":
                insertProduct(req, resp);
                break;
            case "editProduct":
                updateProduct(req, resp);
                break;
            case "deleteProduct":
                deleteProduct(req,resp);
            default:
                listProduct(req, resp);
                break;
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

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        String idStr = req.getParameter("id");
        int id = 0; // Giá trị mặc định
        if (idStr != null && !idStr.trim().isEmpty()) {
            id = Integer.parseInt(idStr);
        }
        String name = req.getParameter("name");
        Float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        int stock = Integer.parseInt(req.getParameter("stock"));
        Timestamp importDate = Timestamp.valueOf(LocalDateTime.now());
        Product product = new Product(id, name, price, description, stock, importDate);
        productService.updateProduct(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        int stock = Integer.parseInt(req.getParameter("stock"));
        Timestamp importDate = Timestamp.valueOf(req.getParameter("importDate"));
        int status = Integer.parseInt(req.getParameter("status"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setStock(stock);
        product.setImportDate(importDate);
        product.setStatus(status);

        HttpSession session = req.getSession();
        session.setAttribute("product", product);
        Product retrievedProduct = (Product) session.getAttribute("product");

        // Chuyển hướng đến trang confirmProduct.jsp và hiển thị thông tin
        req.setAttribute("MSG", "Add new Product success. Product ID is: " + retrievedProduct.getId());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/confirmProduct.jsp");
        dispatcher.forward(req,resp);
    }

    public String getServletInfo() {
        return "Servlet to add a new product.";
    }
    }

