<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/12/2024
  Time: 8:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a class="btn btn-sm btn-success" href="/product?action=show-create-form">Thêm sản phẩm mới</a>
<table class="table table-striped">
  <thead>
  <tr>
    <th>STT</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Color</th>
    <th>Category</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${products}" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td>${product.productName}</td>
      <td>${product.price}</td>
      <td>${product.quantity}</td>
      <td>${product.color}</td>
      <td>${product.categoryName}</td>
      <td>
                  <a class="btn btn-sm btn-primary" href="edit-product?id=${product.productId}">Sửa</a>
                  <a class="btn btn-sm btn-danger" href="/product?action=delete&id=${product.productId}">Xóa</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>
