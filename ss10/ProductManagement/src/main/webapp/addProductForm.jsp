<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 28/11/2024
  Time: 8:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Themm san pham</h1>
<form action="/product?action=addProductForm" method="post">
    <ul>
        <li>
            <p>Enter id:</p>
            <input type="text" name="id" placeholder="Enter id">
        </li>
        <li>
            <p>Enter name:</p>
            <input type="text" name="name" placeholder="Enter name">
        </li>
        <li>
            <p>Enter price:</p>
            <input type="number" name="price" placeholder="Enter price">
        </li>
        <li>
            <p>Enter description:</p>
            <input type="text" name="description" placeholder="Enter description">
        </li>
        <li>
            <p>Enter manufacturer:</p>
            <input type="text" name="manufacturer" placeholder="Enter manufacturer">
        </li>
        <li>
            <button name="submit">Thêm sản phẩm</button>
        </li>

    </ul>
</form>
</body>
</html>
