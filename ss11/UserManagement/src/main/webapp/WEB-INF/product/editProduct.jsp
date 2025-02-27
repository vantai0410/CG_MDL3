<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 13/02/2025
  Time: 10:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4">Edit Product</h2>
        <form action="/product?action=editProduct" method="post">
            <!-- Hidden input để giữ ID sản phẩm -->
            <input type="hidden" name="id" value="${product.id}">

            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" name="name" id="name" value="${product.name}" required>
            </div>

            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" step="0.01" class="form-control" name="price" id="price" value="${product.price}" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" name="description" id="description" value="${product.description}" required>
            </div>

            <div class="mb-3">
                <label for="stock" class="form-label">Stock:</label>
                <input type="number" class="form-control" name="stock" id="stock" value="${product.stock}" required>
            </div>

            <div class="mb-3">
                <label for="importDate" class="form-label">Import Date:</label>
                <input type="datetime-local" class="form-control" name="importDate" id="importDate" value="${product.importDate}" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Update</button>
                <a href="/product" class="btn btn-secondary">Cancel</a>
            </div>

        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
