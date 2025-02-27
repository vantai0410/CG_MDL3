<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/02/2025
  Time: 10:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="row">
    <div class="col-md-6">
      <form action="/user" method="get" class="d-flex">
        <input type="text" name="country" id="country" class="form-control me-2" placeholder="Search by Country">
        <button type="submit" class="btn btn-primary">Search</button>
      </form>
    </div>

    <div class="card shadow p-4">
      <h1 class="text-center mb-4">Product Management</h1>

      <div class="d-flex justify-content-between mb-3">
        <h2>List of Users</h2>
        <a href="/product?action=showCreateFormProduct" class="btn btn-success">Add New Product</a>
      </div>
      <c:set var="pageSize" value="5"/>
      <c:set var="currentPage" value="${param.page != null ? param.page : 1}"/>
      <c:set var="start" value="${(currentPage - 1) * pageSize}"/>
      <c:set var="end" value="${start + pageSize}"/>
      <c:set var="totalProducts" value="${products.size()}"/>
      <c:set var="totalPages" value="${Math.ceil(totalProducts / pageSize)}"/>
      <div class="col-md-12 text-end">
        <form action="/product" method="get">
          <button name="action" value="sortByName" class="btn btn-secondary">Sort by Name</button>
        </form>
      </div>

      <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Price</th>
          <th>Description</th>
          <th>Stock</th>
          <th>Date</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}" varStatus="status">
          <c:if test="${status.index >= start && status.index < end}">
          <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.stock}"/></td>
            <td><c:out value="${product.importDate}"/></td>
            <td>
              <a href="/product?action=showEditFormProduct&id=${product.id}" class="btn btn-warning btn-sm"
                 onclick="return confirm('Are you sure you want to edit this user?');">Edit</a>
              <a href="/product?action=showDeleteFormProduct&id=${product.id}" class="btn btn-danger btn-sm">Delete</a>
            </td>
          </tr>
          </c:if>
        </c:forEach>
        </tbody>
      </table>
      <!-- Phân trang -->
      <nav>
        <ul class="pagination justify-content-center">
          <c:if test="${currentPage > 1}">
            <li class="page-item">
              <a class="page-link" href="product?page=${currentPage - 1}">Previous</a>
            </li>
          </c:if>

          <c:forEach var="i" begin="1" end="${totalPages}">
            <li class="page-item ${i == currentPage ? 'active' : ''}">
              <a class="page-link" href="product?page=${i}">${i}</a>
            </li>
          </c:forEach>

          <c:if test="${currentPage < totalPages}">
            <li class="page-item">
              <a class="page-link" href="product?page=${currentPage + 1}">Next</a>
            </li>
          </c:if>
        </ul>
      </nav>

    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
