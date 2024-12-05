<%@ page import="com.example.gasmanagement.model.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05/12/2024
  Time: 8:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sach Don Hang</title>
</head>
<body>
<h2>Danh sách Đơn Hàng</h2>
<a href="/order?action=create">Tạo mới đơn hàng</a>
<table border="1">
  <thead>
  <tr>
    <th>Mã Đơn Hàng</th>
    <th>ID Khách Hàng</th>
    <th>Ngày Đặt Hàng</th>
    <th>Tổng Tiền</th>
    <th>Trạng Thái</th>
    <th>Thao Tác</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${orders}" var="o">
  <tr>
    <td>${o.orderID}</td>
    <td>${o.customerID}</td>
    <td>${o.orderDate}</td>
    <td>${o.totalAmount}</td>
    <td>${o.status}</td>
    <td>
<%--      <a href="/order?action=edit&orderID=${}">Sửa</a> |--%>
      <a href="/order?action=delete&orderID=${o.orderID}">Xóa</a>
    </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
