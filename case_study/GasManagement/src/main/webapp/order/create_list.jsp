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
    <title>Them moi</title>
</head>
<body>
<h2>Tạo Đơn Hàng Mới</h2>
<form action="/order?action=create_order" method="post">
  <label for="orderID">Mã Đơn Hàng:</label><br>
  <input type="text" id="orderID" name="orderID" required><br><br>

  <label for="customerID">ID Khách Hàng:</label><br>
  <input type="number" id="customerID" name="customerID" required><br><br>

  <label for="totalAmount">Tổng Tiền:</label><br>
  <input type="number" step="0.01" id="totalAmount" name="totalAmount" required><br><br>

  <label for="status">Trạng Thái:</label><br>
  <select name="status" id="status">
    <option value="Pending">Chờ</option>
    <option value="Completed">Hoàn Thành</option>
  </select><br><br>

  <button type="submit">Tạo Đơn Hàng</button>
</form>
<a href="/order">Trở lại</a>
</body>
</html>
