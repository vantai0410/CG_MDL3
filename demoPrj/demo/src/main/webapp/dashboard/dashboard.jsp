<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/01/2025
  Time: 9:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!-- Kiểm tra người dùng đã đăng nhập chưa -->
<c:if test="${empty sessionScope.loggedInUser}">
  <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard Admin</title>
  <%--  Nhúng CSS  --%>

  <%--  BOOTSTRAP --%>

</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="../common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="../common/toast.jsp" />

<div id="main-content" style="margin-top: 4rem">
  <h4>Xin chào đến với Dashboard Admin</h4>
</div>
</body>
</html>
