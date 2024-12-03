<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 03/12/2024
  Time: 7:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach khach hang</h1>
<a href="/customer"></a>
<table>
  <tr>
    <th>id</th>
    <th>Ten</th>
    <th>sdt</th>
    <th>email</th>
    <th>dia chi</th>
  </tr>
  <c:forEach items="${customers}" var="c" varStatus="loop">
    <tr>
        <th>${loop.count}</th>
        <th>${c.name}</th>
      <th>${c.phone}</th>
      <th>${c.email}</th>
      <th>${c.address}</th>
    </tr>
  </c:forEach>
</table>
</body>
</html>
