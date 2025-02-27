<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 13/02/2025
  Time: 9:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pr" class="com.example.usermanagement.model.Product" scope="session" />

<html>
<head>
  <title>Add New Produtc</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
  <div class="card shadow p-4">
    <h2 class="text-center mb-4">Add New Product</h2>
    <form action="/product?action=createProduct" method="post">

      <div class="mb-3">
        <label for="name" class="form-label">Product Name:</label>
        <input type="text" class="form-control" name="name" id="name" required>
      </div>

      <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type=number class="form-control" name="price" id="price" required>
      </div>

      <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" name="description" id="description" required>
      </div>

      <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="number" class="form-control" name="stock" id="stock" required>
      </div>

      <div class="mb-3">
        <label for="importDate" class="form-label">Import Date</label>
        <input type="datetime-local" class="form-control" name="importDate" id="importDate" required>
      </div>
        <ul>
            <li>Product ID: ${product.id}</li>
            <li>Product Name: ${product.name}</li>
            <li>Product Price: ${product.price}</li>
            <li>Product Description: ${product.description}</li>
            <li>Product Stock: ${product.stock}</li>
            <li>Product Import Date: ${product.importDate}</li>
            <li>Product Status: ${product.status}</li>
        </ul>


      <div class="text-center">
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/product" class="btn btn-secondary">Cancel</a>
      </div>

    </form>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
