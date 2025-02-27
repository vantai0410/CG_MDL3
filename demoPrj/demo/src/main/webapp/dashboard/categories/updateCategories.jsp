<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/01/2025
  Time: 8:31 SA
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
  <title>Update Category</title>
</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<form action="${pageContext.request.contextPath}/categories?action=updateCategories" method="post" style="margin-top: 4rem">
  <div class="mb-3">
    <label for="categories_name" class="form-label">Tên thương hiệu</label>
    <input type="hidden" name="categories_id" value="${categories_id != null ? categories_id : categories.categories_id}">
    <input type="text" id="categories_name" name="categories_name" class="form-control" value="${categories_name != null ? categories_name : categories.categories_name}">
  </div>

  <div class="mb-3">
    <label for="categories_img" class="form-label">Logo (URL)</label>
    <input type="text" id="categories_img" name="categories_img" class="form-control" value="${categories_img != null ? categories_img : categories.categories_img}">
  </div>


  <div class="d-flex justify-content-between">
    <button type="submit" class="btn btn-primary">Lưu Thay Đổi</button>
    <a href="${pageContext.request.contextPath}/categories?action=listCategories" class="btn btn-secondary">
      Quay lại
    </a>
  </div>
</form>

</body>
</html>