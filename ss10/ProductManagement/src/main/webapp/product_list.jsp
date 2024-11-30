<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 28/11/2024
  Time: 8:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach san pham</h1>
<a href="addProductForm.jsp">Them moi san pham</a>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>description</th>
        <th>manufacturer</th>
        <th colspan="3">Action</th>
    </tr>
    <c:forEach items="${products}" var="s" varStatus="loop">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.price}</td>
            <td>${s.description}</td>
            <td>${s.manufacturer}</td>
            <td>
                <a href="/product?action=update&id=${s.id}">Edit</a>
            </td>
            <td>
                <a href="/product?action=delete&id=${s.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
