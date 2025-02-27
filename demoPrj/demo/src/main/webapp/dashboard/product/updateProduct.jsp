<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/01/2025
  Time: 9:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.demo.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!-- Kiểm tra người dùng đã đăng nhập chưa -->
<c:if test="${empty sessionScope.loggedInUser}">
  <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<html>
<head>
  <title>Update Product</title>
</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<form action="${pageContext.request.contextPath}/product?action=updateProduct" method="post" style="margin-top: 4rem">
  <input type="hidden" name="product_id" value="${product.product_id}">
  <div class="mb-3">
    <label for="product_name" class="form-label">Tên Sản phẩm</label>
    <input type="text" id="product_name" name="product_name" class="form-control" value="${product_name != null ? product_name : product.product_name}">
  </div>

  <div class="mb-3">
    <label for="product_description" class="form-label">Mô Tả</label>
    <input type="text" id="product_description" name="product_description" class="form-control" value="${product_description != null ? product_description : product.product_description}">
  </div>

  <div class="mb-3">
    <label for="product_price" class="form-label">Giá</label>
    <input type="number" id="product_price" name="product_price" class="form-control" value="${product_price != null ? product_price : product.product_price}">
  </div>

  <div class="mb-3">
    <label for="product_stock" class="form-label">Số Lượng</label>
    <input type="number" id="product_stock" name="product_stock" class="form-control" value="${product_stock != null ? product_stock : product.product_stock}">
  </div>

  <div class="mb-3">
    <label for="product_img" class="form-label">Ảnh</label>
    <input type="text" id="product_img" name="product_img" class="form-control" value="${product_img != null ? product_img : product.product_img}">
  </div>

  <div class="mb-3">
    <label for="categories_id" class="form-label">Lựa chọn thương hiệu:</label>
    <select class="form-select" id="categories_id" name="categories_id" required>
      <option value="" disabled>-- Chọn thương hiệu --</option>
      <c:forEach var="category" items="${categories}">
        <option value="${category.categories_id}" ${category.categories_id == product.categories_id ? 'selected' : ''}>
            ${category.categories_name}
        </option>
      </c:forEach>
    </select>
  </div>

  <div class="d-flex justify-content-between">
    <button type="submit" class="btn btn-primary">Lưu Thay Đổi</button>
    <a href="${pageContext.request.contextPath}/product?action=listProduct" class="btn btn-secondary">
      Quay lại
    </a>
  </div>
</form>

</body>
</html>
