<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05/12/2024
  Time: 8:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chỉnh sửa Đơn Hàng</title>
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
                width: 100px;
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
        <a class="navbar-brand" href="index.jsp"><i class='bx bx-home-alt-2'></i> Gas</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" href="order_list.jsp">Đơn hàng</a></li>
                <li class="nav-item"><a class="nav-link" href="create_list.jsp">Thêm đơn</a></li>
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
    <h2>Chỉnh sửa Đơn Hàng</h2>

    <form action="/order?action=edit_order" method="post">
        <input type="hidden" name="orderID" value="${order.orderID}" />

        <div class="mb-3">
            <label for="customerID" class="form-label">Mã Khách Hàng</label>
            <input type="text" class="form-control" id="customerID" name="customerID" value="${order.customerID}" readonly />
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Trạng Thái</label>
            <select class="form-select" id="status" name="status" required>
                <option value="Chờ" ${'Chờ' == order.status ? 'selected' : ''}>Chờ</option>
                <option value="Hoàn thành" ${'Hoàn thành' == order.status ? 'selected' : ''}>Hoàn thành</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="totalAmount" class="form-label">Tổng Tiền</label>
            <input type="text" class="form-control" id="totalAmount" name="totalAmount" value="${order.totalAmount}" readonly />
        </div>

        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="/order?customerId=${order.customerID}" class="btn btn-secondary">Quay lại</a>
    </form>
</div>


</body>
</html>
