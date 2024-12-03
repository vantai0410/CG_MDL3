package com.example.demostudent.controller;

import com.example.demostudent.model.Student;
import com.example.demostudent.service.IStudentService;
import com.example.demostudent.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private final IStudentService iStudentService = new StudentService();

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
                case "show-update-student":
                    showUpdateForm(req,resp);
                    break;
                    default:
                        showStudentList(req,resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("update_form.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("create_form.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showStudentList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("students", iStudentService.findAll());
        try {
            req.getRequestDispatcher("student_list.jsp").forward(req,resp);
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
            case "add-student":
                addNewStudent(req,resp);
                break;
            case "update-student":
                showUpdateForm(req,resp);
                break;
        }
    }

    private void addNewStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        boolean gender = req.getParameter("gender").equals("male");
        double score = Double.parseDouble(req.getParameter("score"));
        Student student = new Student(name, gender, score);
        iStudentService.save(student);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

