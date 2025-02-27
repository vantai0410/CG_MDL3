<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!-- Kiểm tra người dùng đã đăng nhập chưa -->
<c:if test="${empty sessionScope.loggedInUser}">
  <c:redirect url="${pageContext.request.contextPath}/login" />
</c:if>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create Category</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<div class="main-content" style="margin-top: 4rem">
  <form action="${pageContext.request.contextPath}/categories?action=createCategories" method="post">
    <h2 class="mb-4">Tạo Thương Hiệu Mới</h2>
    <div class="mb-3">
      <label for="categories_name" class="form-label">Tên thương hiệu:</label>
      <input type="text" class="form-control" id="categories_name" name="categories_name" value="${param.categories_name}" required>
    </div>

    <div class="mb-3">
      <label for="categories_img" class="form-label">Logo (URL):</label>
      <input type="text" class="form-control" id="categories_img" name="categories_img" value="${param.categories_img}" required>
    </div>

    <div class="d-flex justify-content-between">
      <button type="submit" class="btn btn-primary">Thêm Thương Hiệu</button>
      <a href="${pageContext.request.contextPath}/categories?action=listCategories" class="btn btn-secondary">
        Quay lại
      </a>
    </div>
  </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>