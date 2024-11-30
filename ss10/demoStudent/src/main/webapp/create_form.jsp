<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 28/11/2024
  Time: 3:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Them moi sinh vien
<form action="/student?action=add-student" method="post">
    Ten <input type="text" name="name">
    Gioi tinh <input type="radio" name="gender" value="male">Nam
    Gioi tinh <input type="radio" name="gender" value="female">Nu
    diem <input type="number" name="score">
    <input type="submit" value="them moi">
</form>
</body>
</html>
