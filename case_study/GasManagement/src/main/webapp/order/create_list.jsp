<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05/12/2024
  Time: 8:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tao don hang moi</title>
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
      max-width: 600px;
      padding: 20px;
      background-color: white;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

    label {
      font-weight: bold;
    }

    input, select {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border-radius: 5px;
      border: 1px solid #ccc;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #ff4d4d;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 16px;
    }

    button:hover {
      background-color: #e64a47;
    }

    .back-link {
      display: block;
      text-align: center;
      margin-top: 20px;
      font-size: 16px;
    }

    .back-link a {
      color: #ff4d4d;
      text-decoration: none;
    }

    .back-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
<div class="container-fluid">
  <a class="navbar-brand" href="/index.jsp"><i class='bx bx-home-alt-2'></i> Gas</a>
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
  </div>
</div>
</nav>

<div class="container">
  <h2>Tạo Đơn Hàng Mới</h2>
  <form action="/order?action=create_order" method="post">
    <label for="orderID">Mã Đơn Hàng:</label><br>
    <input type="text" id="orderID" name="orderID" required><br>

    <label for="customerID">ID Khách Hàng:</label><br>
    <input type="number" id="customerID" name="customerID" required><br>

    <label for="totalAmount">Tổng Tiền:</label><br>
    <input type="number" step="0.01" id="totalAmount" name="totalAmount" required><br>

    <label for="status">Trạng Thái:</label><br>
    <select name="status" id="status">
      <option value="Pending">Chờ</option>
      <option value="Completed">Hoàn Thành</option>
    </select><br><br>

    <button type="submit">Tạo Đơn Hàng</button>
  </form>

  <div class="back-link">
    <a href="/order">Trở lại</a>
  </div>
</div>
</body>
</html>
