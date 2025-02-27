<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 14/01/2025
  Time: 8:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
  <title>Giỏ Hàng</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- CSS -->
  <style>
    .cart-table th, .cart-table td {
      text-align: center;
    }
    .total-price {
      font-size: 1.5rem;
      font-weight: bold;
    }
  </style>
</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<div class="main-content" style="margin-top: 4rem;">
  <h2 class="mb-4">Giỏ Hàng Của Bạn</h2>

  <!-- Giỏ hàng -->
  <table class="table table-bordered cart-table">
    <thead>
    <tr>
      <th>STT</th>
      <th>Sản phẩm</th>
      <th>Giá</th>
      <th>Số lượng</th>
      <th>Tổng tiền</th>
      <th>Hành động</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="cartItem" items="${cartItems}" varStatus="loop">
      <tr>
        <td>${loop.count}</td>
        <td>${cartItem.productName}</td>
        <td>${cartItem.cartPrice}</td>
        <td>
          <form action="updateQuantity" method="POST">
            <input type="number" name="quantity" value="${cartItem.quantity}" min="1" class="form-control" style="width: 80px;" />
            <input type="hidden" name="cartItemId" value="${cartItem.cartItemId}" />
            <button type="submit" class="btn btn-success btn-sm mt-2">Cập nhật</button>
          </form>
        </td>
        <td>${cartItem.cartTotal}</td>
        <td>
          <form action="removeItem" method="POST">
            <input type="hidden" name="cartItemId" value="${cartItem.cartItemId}" />
            <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <!-- Tổng tiền -->
  <div class="row">
    <div class="col-12 text-right total-price">
      Tổng cộng: ${totalAmount}
    </div>
  </div>

  <!-- Nút thanh toán -->
  <div class="text-right mt-4">
    <a href="checkout" class="btn btn-primary">Thanh toán</a>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"></script>

</body>
</html>
