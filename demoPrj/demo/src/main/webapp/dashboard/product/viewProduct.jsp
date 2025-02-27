<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/01/2025
  Time: 9:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!-- Kiểm tra người dùng đã đăng nhập chưa -->
<c:if test="${empty sessionScope.loggedInUser}">
  <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi tiết sản phẩm</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .card-table th {
      background-color: #f8f9fa;
      font-weight: bold;
    }
    .card-table td {
      font-size: 1.1rem;
    }
    .img-avatar {
      max-width: 100px;
    }
  </style>
</head>
<body>

<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<div id="main-content" style="margin-top: 4rem">
  <div class="container">
    <%-- Hiển thị chi tiết sản phẩm --%>
    <c:if test="${not empty product}">
      <div class="card">
        <div class="card-header">
          <h4>Chi tiết sản phẩm: ${product.product_name}</h4>
        </div>
        <div class="card-body">
          <table class="table table-bordered table-striped card-table">
            <tr>
              <th>Tên sản phẩm</th>
              <td>${product.product_name}</td>
            </tr>
            <tr>
              <th>Mô tả</th>
              <td>${product.product_description}</td>
            </tr>
            <tr>
              <th>Giá tiền</th>
              <td>${product.formattedPrice}</td>
            </tr>
            <tr>
              <th>Số lượng</th>
              <td>${product.product_stock}</td>
            </tr>
            <tr>
              <th>Ảnh</th>
              <td><img src="${product.product_img}" alt="imgProduct" class="img-avatar" /></td>
            </tr>
            <tr>
              <th>Ngày tạo</th>
              <td>${product.formattedCreatedDate}</td>
            </tr>
            <tr>
              <th>Ngày cập nhật</th>
              <td>${product.formattedUpdateDate}</td>
            </tr>
            <tr>
              <th>Thương hiệu</th>
              <td>${product.categories_name}</td>
            </tr>
          </table>
        </div>
        <div class="card-footer d-flex justify-content-between">
          <a href="${pageContext.request.contextPath}/product?action=listProducts" class="btn btn-secondary">
            <i class="fas fa-arrow-left"></i> Quay lại
          </a>
          <a href="${pageContext.request.contextPath}/product?action=updateProduct&product_name=${product.product_name}" class="btn btn-warning">
            <i class="fas fa-edit"></i> Sửa sản phẩm
          </a>
        </div>
      </div>
    </c:if>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
