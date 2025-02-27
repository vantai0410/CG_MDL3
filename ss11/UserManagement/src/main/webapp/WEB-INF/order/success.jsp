<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Đặt hàng thành công</title>
</head>
<body>
<h1>Đơn hàng của bạn đã được ghi nhận!</h1>
<p>Cảm ơn bạn đã mua sắm.</p>
<a href="<%=request.getContextPath()%>/cart?action=viewProducts">Tiếp tục mua sắm</a>
</body>
</html>
