<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/12/2024
  Time: 5:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user?action=edit" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" value="${user.name}" required>
    <br>
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" value="${user.email}" required>
    <br>
    <label for="country">Country:</label>
    <input type="text" name="country" id="country" value="${user.country}" required>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
