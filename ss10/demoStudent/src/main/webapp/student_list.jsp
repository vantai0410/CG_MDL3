<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 28/11/2024
  Time: 2:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Danh sách sinh viên</h1>
<%--  <a href="/student"></a>--%>
  <a href="/student?action=show-create-form">Them moi sinh vien</a>
  <table>
    <tr>
      <th>STT</th>
      <th>Ten</th>
      <th>Gioi tinh</th>
      <th>Diem</th>
    </tr>
      <c:forEach items="${students}" var="s" varStatus="loop">
        <tr>
          <td>${loop.count}</td>
          <td>${s.name}</td>
          <td>${s.gender}</td>
          <td>${s.score}</td>
       </tr>

      </c:forEach>

  </table>
  </body>
</html>
