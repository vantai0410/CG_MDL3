<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/01/2025
  Time: 9:17 SA
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
    <title>Thêm Sản Phẩm</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<div class="main-content" style="margin-top: 4rem">
    <form action="${pageContext.request.contextPath}/product?action=createProduct" method="post">
        <h2 class="mb-4">Thêm Sản Phẩm Mới</h2>
        <div class="mb-3">
            <label for="product_name" class="form-label">Tên sản phẩm:</label>
            <input type="text" class="form-control" id="product_name" name="product_name" value="${param.product_name}" required>
        </div>

        <div class="mb-3">
            <label for="product_price" class="form-label">Thêm giá:</label>
            <input type="number" class="form-control" id="product_price" name="product_price" value="${param.product_price}" required>
        </div>

        <div class="mb-3">
            <label for="product_stock" class="form-label">Nhập số lượng:</label>
            <input type="number" class="form-control" id="product_stock" name="product_stock" value="${param.product_stock}" required>
        </div>

        <div class="mb-3">
            <label for="categories_id" class="form-label">Lựa chọn thương hiệu:</label>
            <select class="form-select" id="categories_id" name="categories_id" required>
                <option value="" disabled selected>-- Chọn thương hiệu --</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.categories_id}">
                            ${category.categories_name}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Thêm Sản Phẩm</button>
            <a href="${pageContext.request.contextPath}/product?action=listProducts" class="btn btn-secondary">
                Quay lại
            </a>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
