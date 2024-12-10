<%@ page import="com.example.gasmanagement.model.Order" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Danh Sách Đơn Hàng</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
  <style>
    /* Ẩn modal mặc định */
    .confirm-modal {
      display: none;
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      justify-content: center;
      align-items: center;
      z-index: 9999;
      background: rgba(0, 0, 0, 0.7); /* Màu nền mờ */
    }

    /* Hiển thị modal khi checkbox được chọn */
    .confirm-checkbox:checked + .confirm-modal {
      display: flex;
    }

    /* Nội dung modal */
    .modal-content {
      background: #fff;
      border-radius: 8px;
      padding: 20px;
      width: 300px;
      text-align: center;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    /* Nút hủy */
    .btn-secondary {
      background-color: #bdc3c7;
      color: #2c3e50;
      border: none;
    }

    .btn-secondary:hover {
      background-color: #95a5a6;
    }

    /* Nút xác nhận */
    .btn-danger {
      background-color: #e74c3c;
      color: white;
      border: none;
    }

    .btn-danger:hover {
      background-color: #c0392b;
    }



    body {
      background-color: #f4f6f9;
      font-family: 'Arial', sans-serif;
    }


    .navbar {
      background-color: #ff4d4d; /* Màu nền đỏ */
      border-bottom: 2px solid #e74c3c; /* Viền dưới để nổi bật */
    }

    .navbar-brand {
      font-weight: bold;
      color: white;
      font-size: 1.3rem; /* Kích thước chữ */
    }

    .navbar-nav .nav-link {
      color: white !important;
      font-weight: bold;
      font-size: 1rem; /* Đồng nhất kích thước chữ */
    }

    .navbar-nav .nav-link:hover {
      color: #e74c3c !important; /* Hiệu ứng hover */
    }

    .navbar-toggler-icon {
      background-color: white; /* Đổi màu icon toggle */
      border-radius: 50%; /* Icon toggle tròn */
    }margin-top: 50px;
    }

    .step {
      text-align: center;
      background-color: #fff;
      padding: 15px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .step img {
      width: 50px;
      margin-bottom: 10px;
    }

    .table thead {
      background-color: #ff4d4d;
      color: white;
    }

    .table tbody tr:hover {
      background-color: #f1f1f1;
    }

    .btn-custom {
      background-color: #ff4d4d;
      color: white;
      border-radius: 5px;
      padding: 8px 15px;
      text-decoration: none;
    }

    .btn-custom:hover {
      background-color: #e64a47;
    }

    .header {
      text-align: center;
      margin-bottom: 30px;
      font-size: 24px;
    }

    .footer {
      text-align: center;
      margin-top: 50px;
      font-size: 14px;
      color: #777;
    }

    .footer a {
      text-decoration: none;
      color: #ff4d4d;
    }

    .footer a:hover {
      text-decoration: underline;
    }
    .search-form {
      display: flex;
      justify-content: flex-end;
      align-items: center;
      margin-right: 50px;
    }

    .search-form {
      display: flex;
      justify-content: flex-end;
      align-items: center;
    }

    .search-form input {
      width: 200px;
      border: 2px solid #e74c3c; /* Viền đỏ */
      border-radius: 5px; /* Bo góc */
      padding: 5px;
    }

    .search-form button {
      background-color: #ff4d4d;
      color: white;
      border: none;
      border-radius: 5px;
      padding: 5px 10px;
      margin-left: 5px;
    }

    .search-form button:hover {
      background-color: #e74c3c;
      color: black;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class='bx bx-home-alt-2'></i> Gas</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" href="/order/order_list.jsp">Đơn hàng</a></li>
        <li class="nav-item"><a class="nav-link" href="/order/create_list.jsp">Thêm đơn</a></li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Sản phẩm
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="">Gas</a></li>
            <li><a class="dropdown-item" href="#">Bếp gas</a></li>
            <li><a class="dropdown-item" href="#">Máy hút mùi</a></li>
          </ul>
        </li>
        <li class="nav-item"><a class="nav-link disabled">Feedback</a></li>
      </ul>
      <form action="/order" method="GET" class="search-form">
        <input
                class="form-control me-2"
                type="text"
                name="orderID"
                placeholder="Mã Đơn Hàng"
                value="${param.orderID}">

        <input
                class="form-control me-2"
                type="text"
                name="customerID"
                placeholder="Mã Khách Hàng"
                value="${param.customerID}">
        <input type="hidden" name="action" value="search">
        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
      </form>


    </div>
  </div>
</nav>

<div class="container mt-5">
  <div class="row">
    <div class="col-md-3 step">
      <img src="https://www.gas24h.com.vn/themes/gas/ecommerce/images/icon-1.png" >
      <p><strong>Bước 1:</strong></p>
      <p>Đặt hàng trên website</p>
    </div>
    <div class="col-md-3 step">
      <img src="https://www.gas24h.com.vn/themes/gas/ecommerce/images/icon-2.png" >
      <p><strong>Bước 2:</strong></p>
      <p>Nhân viên liên hệ xác nhận</p>
    </div>
    <div class="col-md-3 step">
      <img src="https://www.gas24h.com.vn/themes/gas/ecommerce/images/icon-3.png" >
      <p><strong>Bước 3:</strong></p>
      <p>Giao Gas: 15 phút<br>Sản phẩm khác: 24 giờ</p>
    </div>
    <div class="col-md-3 step">
      <img src="https://www.gas24h.com.vn/themes/gas/ecommerce/images/icon-4.png" >
      <p><strong>Bước 4:</strong></p>
      <p>Hoàn thành đơn hàng</p>
    </div>
  </div>
</div>
<div class="container mt-5">
  <a href="/order?action=create" class="btn btn-custom mb-3">Tạo mới đơn hàng</a>



  <h2 class="header">Danh Sách Đơn Hàng</h2>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Mã Đơn Hàng</th>
      <th>ID khách hàng</th>
      <th>Ngày Đặt</th>
      <th>Trạng Thái</th>
      <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
  <c:forEach items="${orders}" var="o">
    <tr>
      <td>${o.orderID}</td>
      <td>${o.customerID}</td>
      <td>${o.orderDate}</td>
      <td>${o.status}</td>
      <td>
        <a href="/order?action=edit&orderID=${o.orderID}" class="btn btn-outline-warning btn-sm">
          <i class='bx bx-edit'></i> Sửa
        </a>

        <a href="#" class="btn btn-outline-danger btn-sm" onclick="document.getElementById('modal-${o.orderID}').style.display='flex';">
          <i class='bx bx-trash'></i> Xóa
        </a>
        <div id="modal-${o.orderID}" class="confirm-modal" style="display: none;">
          <div class="modal-content">
            <p>Bạn có chắc chắn muốn xóa?</p>
            <a href="/order?action=delete&orderID=${o.orderID}" class="btn btn-danger">Xác nhận</a>
            <button class="btn btn-secondary" onclick="document.getElementById('modal-${o.orderID}').style.display='none';">Hủy</button>
          </div>
        </div>

      </td>
    </tr>
  </c:forEach>
  <c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
        ${error}
    </div>
  </c:if>

    </tbody>

  </table>
</div>

<div class="footer">
  <p>&copy; 2024 GasManagement. All Rights Reserved.</p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
