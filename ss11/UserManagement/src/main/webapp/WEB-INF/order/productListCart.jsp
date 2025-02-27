<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.usermanagement.model.Product" %>
<%@ page import="com.example.usermanagement.service.product.ProductService" %>

<%
    ProductService productService = new ProductService();
    List<Product> products = productService.getAllProducts();
    request.setAttribute("products", products);
%>

<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; }
        .product { margin: 10px; display: inline-block; width: 250px; }
        .btn { background: #28a745; color: white; padding: 5px; border: none; cursor: pointer; }
    </style>
</head>
<body>
<h1>Danh Sách Sản Phẩm</h1>


<c:forEach var="product" items="${products}">
    <div class="product">
        <h3>${product.name}</h3>
        <p>${product.price} VND</p>
        <form action="<%=request.getContextPath()%>/cart" method="post">
            <input type="hidden" name="action" value="add">
            <input type="hidden" name="productId" value="${product.id}">
            <input type="number" name="quantity" value="1" min="1">
            <button type="submit" class="btn">Thêm vào Giỏ</button>
        </form>
    </div>
</c:forEach>
</body>
</html>
