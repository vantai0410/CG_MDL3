<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.example.usermanagement.model.CartItem" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.text.DecimalFormat" %>
<%
  DecimalFormat formatter = new DecimalFormat("#,###,###.00 VND");
%>
<html>
<head>
  <title>Giỏ Hàng</title>
  <style>
    body { font-family: Arial, sans-serif; text-align: center; }
    table { width: 70%; margin: 20px auto; border-collapse: collapse; }
    td, th { padding: 10px; border: 1px solid #ddd; }
    button { background: #dc3545; color: white; padding: 5px; border: none; cursor: pointer; }
  </style>
</head>
<body>
<h1>Giỏ Hàng</h1>
<a href="<%=request.getContextPath()%>/cart?action=viewProducts">Xem Danh Sách Sản Phẩm</a>
<c:if test="${empty cart}">
  <p>Giỏ hàng trống!</p>
</c:if>

<c:if test="${not empty cart}">
  <form action="<%=request.getContextPath()%>/cart" method="post">
    <table>
      <tr>
        <th>ID</th>
        <th>Sản phẩm</th>
        <th>Số lượng</th>
        <th>Giá</th>
        <th>Thao tác</th>
      </tr>
      <c:forEach var="entry" items="${cart}">
        <tr>
          <td>${entry.value.productId}</td>
          <td>${entry.value.productName}</td>
          <td>
            <input type="number" name="quantity" value="${entry.value.quantity}" min="1">
          </td>
          <td><fmt:formatNumber value="${entry.value.price}" type="currency" currencySymbol="VND" /></td>
          <td>
            <button type="submit" name="action" value="update">Cập nhật</button>
            <a href="<%=request.getContextPath()%>/cart?action=remove&productId=${entry.value.productId}">
              <button type="button">Xóa</button>
            </a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </form>
  <h3>Tổng tiền: <fmt:formatNumber value="${cartTotal}" type="currency" currencySymbol="VND" minFractionDigits="2" maxFractionDigits="2"/></h3>
  <form action="<%=request.getContextPath()%>/cart" method="post">
    <input type="hidden" name="action" value="checkout">
    <button type="submit">Thanh toán</button>
  </form>
</c:if>
</body>
</html>
