<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 30/11/2024
  Time: 6:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Product</h1>
<form action="/product?action=updateProductForm" method="post">
  <input type="hidden" name="id" value="${product.id}">
  <ul>
    <li>
      <p>Enter name:</p>
      <input type="text" name="name" value="${product.name}" placeholder="Enter name">
    </li>
    <li>
      <p>Enter price:</p>
      <input type="number" name="price" value="${product.price}" placeholder="Enter price">
    </li>
    <li>
      <p>Enter description:</p>
      <input type="text" name="description" value="${product.description}" placeholder="Enter description">
    </li>
    <li>
      <p>Enter manufacturer:</p>
      <input type="text" name="manufacturer" value="${product.manufacturer}" placeholder="Enter manufacturer">
    </li>
    <li>
      <button type="submit">Update Product</button>
    </li>
  </ul>
</form>
</body>
</html>
