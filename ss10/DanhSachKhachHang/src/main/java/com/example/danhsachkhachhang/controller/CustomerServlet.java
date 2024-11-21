package com.example.danhsachkhachhang.controller;

import com.example.danhsachkhachhang.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    private static final List<Customer> customers ;
    static {
        customers = new ArrayList<>();
        customers.add(new Customer("Mai Van Hoan", "1983-08-20", "Ha Noi", "https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg"));
        customers.add(new Customer("Nguyen Van Nam", "1983-08-20", "Ha Noi", "https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg"));
        customers.add(new Customer("Nguyen Thai Hoa", "1983-08-20", "Ha Noi", "https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg"));
        customers.add(new Customer("Tran Dang Khoa", "1983-08-20", "Ha Noi", "https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg"));
        customers.add(new Customer("Nguyen Dinh Thi", "1983-08-20", "Ha Noi", "https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/customer.jsp").forward(req, resp);
    }
}
