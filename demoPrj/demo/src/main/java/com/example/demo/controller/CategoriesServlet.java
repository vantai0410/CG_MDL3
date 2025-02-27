package com.example.demo.controller;

import com.example.demo.model.Categories;
import com.example.demo.model.User;
import com.example.demo.service.categories.CategoriesService;
import com.example.demo.service.categories.ICategoriesService;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "categories", urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
    private IUserService iUserService;
    private ICategoriesService iCategoriesService;

    @Override
    public void init() {
        iUserService = new UserService();
        iCategoriesService = new CategoriesService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "listCategories";
        }
        switch (action) {
            case "createCategories":
                showCreateForm(req, resp);
                break;
            case "updateCategories":
                showUpdateForm(req, resp);
                break;
            case "deleteCategories":
                deleteCategories(req, resp);
                break;
            default:
                listCategories(req, resp);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listCategories";
        }
        switch (action) {
            case "createCategories":
                createCategories(req, resp);
                break;
            case "updateCategories":
                updateCategories(req, resp);
                break;
            case "deleteCategories":
                deleteCategories(req, resp);
                break;
        }
    }

    private void listCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("warningMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền truy cập vào trang này!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        String searchKeyword = req.getParameter("searchCategoryName");
        List<Categories> listCategories;

        if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
            listCategories = iCategoriesService.searchCategories(searchKeyword.trim());

            if (listCategories.isEmpty()) {
                session.setAttribute("errorMessage", "Không tìm thấy!");
            }
        } else {
            listCategories = iCategoriesService.findAllCategories();
        }

        req.setAttribute("listCategories", listCategories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard/categories/listCategories.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền tạo danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        if ("employee".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền tạo danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }
        req.getRequestDispatcher(req.getContextPath() + "/dashboard/categories/createCategories.jsp").forward(req, resp);
    }

    private void createCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        String categories_name = req.getParameter("categories_name");
        String categories_img = req.getParameter("categories_img");

        Optional<Categories> checkCategories = iCategoriesService.findCategoriesByName(categories_name);
        if (checkCategories.isPresent()) {
            session.setAttribute("errorMessage", "Thương hiệu này đã tồn tại");
            req.setAttribute("categories_name", categories_name);
            req.setAttribute("categories_img", categories_img);
            req.getRequestDispatcher("/dashboard/categories/createCategories.jsp").forward(req, resp);
            return;
        }

        Categories newCategories = new Categories();
        newCategories.setCategories_name(categories_name);
        newCategories.setCategories_img(categories_img);
        newCategories.setCategories_createdDate(LocalDateTime.now());
        newCategories.setCategories_updatedDate(LocalDateTime.now());

        try {
            iCategoriesService.addCategories(newCategories);
            session.setAttribute("successMessage", "Tạo danh mục mới thành công");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Đã xảy ra lỗi khi tạo danh mục sản phẩm");
            req.getRequestDispatcher("/dashboard/categories/listCategories.jsp").forward(req, resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String categories_name = req.getParameter("categories_name");

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền cập nhật danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        if ("employee".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền cập nhật danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        Optional<Categories> categoriesToUpdate = iCategoriesService.findCategoriesByName(categories_name);
        if (categoriesToUpdate.isPresent()) {
            session.setAttribute("errorMessage", "Thương hiệu không tồn tại");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        Categories categories = categoriesToUpdate.get();
        req.setAttribute("categories_name", categories.getCategories_name());
        req.setAttribute("categories_img", categories.getCategories_img());

        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/dashboard/categories/updateCategories.jsp").forward(req, resp);
    }

    private void updateCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        String categories_name = req.getParameter("categories_name");
        String categories_img = req.getParameter("categories_img");
        int categories_id = Integer.parseInt(req.getParameter("categories_id"));

        Optional<Categories> categoriesToUpdate = iCategoriesService.findCategoriesById(categories_id);
        if (!categoriesToUpdate.isPresent()) {
            session.setAttribute("errorMessage", "Thương hiệu không tồn tại");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        Optional<Categories> checkCategories = iCategoriesService.findCategoriesByName(categories_name);
        if ( !checkCategories.isPresent()) {
            session.setAttribute("errorMessage", "Thương hiệu này đã tồn tại");
            req.setAttribute("categories_id", categories_id);
            req.setAttribute("categories_name", categories_name);
            req.setAttribute("categories_img", categories_img);
            req.getRequestDispatcher("/dashboard/categories/updateCategories.jsp").forward(req, resp);
            return;
        }

        Categories newCategories = categoriesToUpdate.get();
        newCategories.setCategories_name(categories_name);
        newCategories.setCategories_img(categories_img);
        newCategories.setCategories_updatedDate(LocalDateTime.now());

        try {
            iCategoriesService.updateCategories(newCategories);
            session.setAttribute("successMessage", "Chỉnh sửa thương hiệu thành công");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Xảy ra lỗi khi cập nhật thương hiệu");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        }
    }

    private void deleteCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền xoá danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        if ("employee".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền xoá danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        String categories_name = req.getParameter("categories_name");
        Optional<Categories> categoriesToDelete = iCategoriesService.findCategoriesByName(categories_name);
        if (!categoriesToDelete.isPresent()) {
            session.setAttribute("errorMessage", "Thương hiệu không tồn tại");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        Categories categories = categoriesToDelete.get();

        try {
            boolean success = iCategoriesService.deleteCategoriesByName(categories_name);
            if (success) {
                session.setAttribute("successMessage", "Xóa thương hiệu thành công!");
            } else {
                session.setAttribute("errorMessage", "Không thể xóa thương hiệu!");
            }
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Đã xảy ra lỗi trong quá trình xóa thương hiệu!");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        }
    }
}
