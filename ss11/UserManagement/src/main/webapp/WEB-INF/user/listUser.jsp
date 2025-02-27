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
        <h1 class="text-center mb-4">User Management</h1>

        <div class="d-flex justify-content-between mb-3">
            <h2>List of Users</h2>
            <a href="/user?action=showCreateForm" class="btn btn-success">Add New User</a>
        </div>
        <div class="col-md-12 text-end">
            <form action="/user" method="get">
                <button name="action" value="sortByName" class="btn btn-secondary">Sort by Name</button>
            </form>
        </div>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td><c:out value="${user.role}"/></td>
                    <td>
                        <a href="/user?action=showEditForm&id=${user.id}" class="btn btn-warning btn-sm"
                           onclick="return confirm('Are you sure you want to edit this user?');">Edit</a>
                        <a href="/user?action=delete&id=${user.id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
