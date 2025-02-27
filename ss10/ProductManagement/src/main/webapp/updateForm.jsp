<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Cập nhật sản phẩm</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
  <h1 class="text-center text-primary mb-4">Cập nhật sản phẩm</h1>
  <form action="/product?action=updateProductForm" method="post" class="needs-validation" novalidate>
    <!-- ID (ẩn) -->
    <input type="hidden" name="id" value="${product.id}">

    <div class="mb-3">
      <label for="name" class="form-label">Tên sản phẩm:</label>
      <input type="text" class="form-control" id="name" name="name" value="${product.name}" placeholder="Nhập tên sản phẩm" required>
      <div class="invalid-feedback">Vui lòng nhập tên sản phẩm.</div>
    </div>

    <div class="mb-3">
      <label for="price" class="form-label">Giá sản phẩm:</label>
      <input type="number" class="form-control" id="price" name="price" value="${product.price}" placeholder="Nhập giá sản phẩm" required>
      <div class="invalid-feedback">Vui lòng nhập giá sản phẩm.</div>
    </div>

    <div class="mb-3">
      <label for="description" class="form-label">Mô tả:</label>
      <input type="text" class="form-control" id="description" name="description" value="${product.description}" placeholder="Nhập mô tả" required>
      <div class="invalid-feedback">Vui lòng nhập mô tả sản phẩm.</div>
    </div>

    <div class="mb-3">
      <label for="manufacturer" class="form-label">Nhà sản xuất:</label>
      <input type="text" class="form-control" id="manufacturer" name="manufacturer" value="${product.manufacturer}" placeholder="Nhập nhà sản xuất" required>
      <div class="invalid-feedback">Vui lòng nhập nhà sản xuất.</div>
    </div>

    <button type="submit" class="btn btn-primary w-100">Cập nhật sản phẩm</button>
  </form>
</div>

<script>
  // Script Bootstrap Validation
  (function () {
    'use strict';
    const forms = document.querySelectorAll('.needs-validation');
    Array.prototype.slice.call(forms).forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  })();
</script>

</body>
</html>
