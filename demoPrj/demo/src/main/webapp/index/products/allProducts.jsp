<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 14/01/2025
  Time: 8:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tất cả sản phẩm</title>

  <!-- BOOTSTRAP -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />


<div class="main-content" style="margin-top: 4rem;">
  <h2 class="text-center mb-4">Tất Cả Sản Phẩm</h2>
  <div class="row">
    <c:forEach var="product" items="${listProducts}">
      <div class="col-md-4 mb-4">
        <div class="card shadow-sm border-light">
          <img src="${product.product_img}" class="card-img-top" alt="${product.product_name}">
          <div class="card-body">
            <h5 class="card-title">${product.product_name}</h5>
            <p class="card-text">${product.product_description}</p>
            <div class="d-flex justify-content-between align-items-center">
              <p class="card-text mb-0"><strong>${product.formattedPrice}</strong> VND</p>

              <small class="text-muted">Còn lại: ${product.product_stock} sản phẩm</small>
            </div>
            <div class="d-flex justify-content-between align-items-center mt-3">
              <!-- Link xem chi tiết sản phẩm -->
              <a href="${pageContext.request.contextPath}/productDetail?productId=${product.product_id}" class="btn btn-info btn-sm">Xem Chi Tiết</a>

              <!-- Form thêm vào giỏ hàng -->
              <form action="${pageContext.request.contextPath}/addToCart" method="post" class="d-flex">
                <input type="hidden" name="productId" value="${product.product_id}">
                <button type="submit" class="btn btn-success btn-sm">Thêm vào giỏ</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
