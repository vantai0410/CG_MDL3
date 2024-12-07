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
    body {
      background-color: #f4f6f9;
      font-family: 'Arial', sans-serif;
    }

    .navbar {
      background-color: #ff4d4d;
    }

    .navbar-brand {
      font-weight: bold;
      color: white;
    }

    .navbar-nav .nav-link {
      color: white !important;
      font-weight: bold;
    }

    .container {
      margin-top: 50px;
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

    .search-form input {
      width: 200px;
    }

    .search-form button {
      background-color: #ff4d4d;
      color: white;
      border: none;
    }

    .search-form button:hover {
      background-color: black;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="Gas.html"><i class='bx bx-home-alt-2'></i> Gas</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" href="Goi_Gas.html">Gọi gas</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Sửa chữa và bảo hành</a></li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Bếp & loại khác
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="Bep_gas.html">Bếp gas</a></li>
            <li><a class="dropdown-item" href="#">Bếp điện</a></li>
            <li><a class="dropdown-item" href="#">Máy hút mùi</a></li>
          </ul>
        </li>
        <li class="nav-item"><a class="nav-link disabled">Feedback</a></li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
        <button class="btn btn-outline-dark" type="submit">Tìm kiếm</button>
      </form>
    </div>
  </div>
</nav>

<div class="container mt-5">
  <h2 class="header">Danh Sách Đơn Hàng</h2>
  <a href="/order?action=create" class="btn btn-custom mb-3">Tạo mới đơn hàng</a>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Mã Đơn Hàng</th>
      <th>ID khách hàng</th>
      <th>Ngày Đặt</th>
      <th>Trạng Thái</th>
      <th>Sản Phẩm</th>
      <th>Số Lượng</th>
      <th>Giá</th>
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
        <td>${o.productName}</td>
        <td>${o.quantity}</td>
        <td>${o.price}</td>
        <td>
          <a href="/order?action=edit&orderID=${o.orderID}" class="btn btn-outline-warning btn-sm"><i class='bx bx-edit'></i></a>
          <a href="/order?action=delete&orderID=${o.orderID}" class="btn btn-outline-danger btn-sm"><i class='bx bx-trash'></i></a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<div class="footer">
  <p>&copy; 2024 GasManagement. All Rights Reserved. <a href="privacy.html">Privacy Policy</a></p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
