<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 21/11/2024
  Time: 8:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Customer</title>
</head>
<body>
<h1>Danh sach khach hang</h1>
<table>
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${customers}" var="c" >
    <tr>
      <td>${c.name}</td>
      <td>${c.dob}</td>
      <td>${c.address}</td>
      <td><img src="${c.image}" width="100px" height="100px"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

