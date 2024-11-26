<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculate" method="post">
    First operand: <input type="number" name="first" required>
    <br><br>
    Operator: <select name="operator" style="margin-left: 40px">
                    <option value="add">Addition</option>
                    <option value="subtract">Subtraction</option>
                    <option value="multiply">Multiplication</option>
                    <option value="divide">Division</option>
            </select>
    <br><br>
    Second operand: <input type="number" name="second" required>
    <br><br>
    <button style="background-color: orange" type="submit">Calculate</button>
</form>
</body>
</html>