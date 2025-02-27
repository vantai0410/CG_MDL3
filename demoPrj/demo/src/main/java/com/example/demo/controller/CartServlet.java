//package com.example.demo.controller;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//
//@WebServlet(name = "cart", urlPatterns = "/cart")
//public class CartServlet extends HttpServlet {
//    private ICartService iCartService;
//    private ICartItemService iCartItemService;
//
//    @Override
//    public void init() throws ServletException {
//        iCartService = new CartService();
//        iCartItemService = new CartItemService();
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        if (action == null) {
//            action = "listCarts";
//        }
//        switch (action) {
//            case "viewCart":
//                viewCart(req, resp);
//                break;
////            case "createUser":
////                showCreateForm(req, resp);
////                break;
////            case "updateUser":
////                showUpdateForm(req, resp);
////                break;
////            case "deleteUser":
////                deleteUser(req, resp);
////                break;
////            default:
////                listUsers(req, resp);
////                break;
//        }
//    }
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if (action == null) {
//            action = "listUsers";
//        }
////        switch (action) {
////            case "createUser":
////                createUser(req, resp);
////                break;
////            case "updateUser":
////                updateUser(req, resp);
////                break;
////            case "deleteUser":
////                deleteUser(req, resp);
////                break;
////        }
//    }
//
//    private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//
//        if (loggedInUser == null) {
//            session.setAttribute("warningMessage", "Bạn cần phải đăng nhập!");
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");
//            return;
//        }
//
//        if ("customer".equals(loggedInUser.getUserRole())) {
//            session.setAttribute("warningMessage", "Bạn không có quyền xem giỏ hàng người dùng khác!");
//            resp.sendRedirect(req.getContextPath() + "/index.jsp");
//            return;
//        }
//
//
//    }
//}
