<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 13/02/2025
  Time: 12:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4">Delete Product</h2>
        <p>Are you sure you want to delete the product <strong>${product.name}</strong>?</p>
        <form action="/product?action=deleteProduct" method="post">
            <input type="hidden" name="id" value="${product.id}">
            <button type="submit" class="btn btn-danger">Delete</button>
            <a href="/product" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

</body>
</html>
