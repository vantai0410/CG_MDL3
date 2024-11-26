<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 26/11/2024
  Time: 4:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Result</title>
  </head>
  <body>
  <h1>Result:</h1>
  <c:choose>
    <c:when test="${not empty error}">
      <p style="color: red;">${error}</p>
    </c:when>
    <c:otherwise>
      <p>${first} ${operator} ${second} = ${result}</p>
    </c:otherwise>
  </c:choose>
  </body>
</html>
