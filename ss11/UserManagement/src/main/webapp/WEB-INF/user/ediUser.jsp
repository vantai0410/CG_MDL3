<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4">Edit User</h2>
        <form action="/user?action=edit" method="post">
            <input type="hidden" name="id" value="${user.id}">

            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" name="name" id="name" value="${user.name}" required>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" name="email" id="email" value="${user.email}" required>
            </div>

            <div class="mb-3">
                <label for="country" class="form-label">Country:</label>
                <input type="text" class="form-control" name="country" id="country" value="${user.country}" required>
            </div>

            <div class="mb-3">
                <label for="role" class="form-label">Role:</label>
                <select class="form-select" name="role" id="role" required>
                    <option value="Admin" ${user.role == 'Admin' ? 'selected' : ''}>Admin</option>
                    <option value="User" ${user.role == 'User' ? 'selected' : ''}>User</option>
                    <option value="Moderator" ${user.role == 'Moderator' ? 'selected' : ''}>Moderator</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Status:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="status" id="status-active" value="true" ${user.status ? 'checked' : ''}>
                    <label for="status-active" class="form-check-label">Active</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="status" id="status-inactive" value="false" ${!user.status ? 'checked' : ''}>
                    <label for="status-inactive" class="form-check-label">Inactive</label>
                </div>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" name="password" id="password">
                <small class="text-muted">Leave blank if you don't want to change the password.</small>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="/user" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
