<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center text-primary mb-4">Danh sách sản phẩm</h1>
    <div class="text-end mb-3">
        <a href="addProductForm.jsp" class="btn btn-success">Thêm mới sản phẩm</a>
    </div>
    <table class="table table-striped table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Mô tả</th>
            <th>Nhà sản xuất</th>
            <th class="text-center" colspan="2">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="s" varStatus="loop">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.price}</td>
                <td>${s.description}</td>
                <td>${s.manufacturer}</td>
                <td class="text-center">
                    <a href="/product?action=update&id=${s.id}" class="btn btn-warning btn-sm">Sửa</a>
                </td>
                <td class="text-center">
                    <a href="/product?action=delete&id=${s.id}" class="btn btn-danger btn-sm">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
