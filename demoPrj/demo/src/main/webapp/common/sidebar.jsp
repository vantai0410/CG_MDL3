<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SideBar</title>

  <!-- CSS Links -->
  <link href="${pageContext.request.contextPath}/css/sidebar.css" rel="stylesheet">

<%-- BOOTSTRAP --%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

  <link href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" rel="stylesheet">
</head>
<body id="body-pd">

<!-- Header -->
<header id="header" class="header bg-light shadow-sm py-2">
  <div class="container-fluid">
    <div class="row align-items-center">
      <!-- Toggle Menu (Cột bên trái) -->
      <div class="col-3">
        <div class="header_toggle">
          <i class='bx bx-menu' id="header-toggle"></i>
        </div>
      </div>

      <!-- Search Section (Cột giữa) -->
      <div class="col-6 d-flex justify-content-center">
        <%--        <c:if test="${sessionScope.loggedInUser.userRole == 'customer'}">--%>
        <form action="${pageContext.request.contextPath}/index?action=listProducts" method="get" class="w-100">
          <div class="input-group">
            <input type="text" class="form-control" id="searchProduct" name="searchProduct"
                   placeholder="Nhập tên sản phẩm cần tìm"
                   value="${param.searchProduct}"
                   aria-label="Tìm sản phẩm">
            <button class="btn btn-primary" type="submit">
              <i class="fas fa-search"></i> Tìm kiếm
            </button>
            <!-- Nút quay lại nếu có tìm kiếm -->
            <c:if test="${not empty param.searchProduct}">
              <a href="${pageContext.request.contextPath}/index?action=listProducts" class="btn btn-secondary ms-2">
                <i class="fas fa-arrow-left"></i> Quay lại
              </a>
            </c:if>
          </div>
        </form>
        <%--        </c:if>--%>
      </div>

      <!-- User Section và Cart -->
      <div class="col-3 d-flex justify-content-end align-items-center">
        <!-- Cart -->
        <c:if test="${sessionScope.loggedInUser.userRole == 'customer'}">
          <div class="cart-info ms-3">
            <a href="${pageContext.request.contextPath}/cart" class="d-flex align-items-center">
              <i class="fas fa-shopping-cart"></i>
              <span class="badge bg-danger ms-2">${sessionScope.cartItemCount}</span>
            </a>
          </div>
        </c:if>

        <!-- User Info -->
        <c:if test="${not empty sessionScope.loggedInUser}">
          <div class="d-flex align-items-center ms-3">
            <img src="${sessionScope.loggedInUser.avatar}" alt="avatar" class="rounded-circle border" width="40px">
            <a href="${pageContext.request.contextPath}/users?action=viewUser&username=${sessionScope.loggedInUser.username}" class="ms-2 text-dark fw-semibold text-decoration-none">
                ${sessionScope.loggedInUser.fullName}
            </a>
          </div>
          <button type="button" class="btn btn-outline-primary btn-sm ms-2" data-bs-toggle="modal" data-bs-target="#logoutModal">
            <i class="fas fa-sign-out-alt me-2"></i> Đăng Xuất
          </button>
        </c:if>

        <!-- User NOT LOGIN-->
        <c:if test="${empty sessionScope.loggedInUser}">
          <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-outline-primary btn-sm me-2">Đăng Nhập</a>
          <a href="${pageContext.request.contextPath}/register.jsp" class="btn btn-outline-primary btn-sm">Đăng Ký</a>
        </c:if>
      </div>
    </div>
  </div>
</header>


<!-- Sidebar -->
<div class="l-navbar" id="nav-bar">
  <nav class="nav">
    <div>
      <!-- Logo -->
      <a href="../index.jsp" class="nav_logo">
        <img src="../resources/img/Logo.png" alt="Logo" width="30px">
        <span class="nav_logo-name">TanaShop</span>
      </a>

      <!-- Navigation -->
      <div class="nav_list">
        <c:choose>
          <c:when test="${not empty sessionScope.loggedInUser }">
            <c:if test="${sessionScope.loggedInUser.userRole == 'customer'}">
              <a href="${pageContext.request.contextPath}/index.jsp" class="nav_link">
                <i class='bx bx-home nav_icon'></i>
                <span class="nav_name">Trang Chủ</span>
              </a>
              <a href="${pageContext.request.contextPath}/index?action=listProducts" class="nav_link">
                <i class='bx bx-store nav_icon'></i>
                <span class="nav_name">Tất cả sản phẩm</span>
              </a>
              <a href="#" class="nav_link">
                <i class='bx bx-bell nav_icon'></i>
                <span class="nav_name">Thông báo</span>
              </a>
              <a href="#" class="nav_link">
                <i class='bx bx-news nav_icon'></i> <span class="nav_name">Bài viết</span>
              </a>
            </c:if>
            <c:if test="${sessionScope.loggedInUser.userRole == 'admin' || sessionScope.loggedInUser.userRole == 'manager' || sessionScope.loggedInUser.userRole == 'employee'}">
              <a href="${pageContext.request.contextPath}/dashboard" class="nav_link">
                <i class='bx bx-home nav_icon'></i>
                <span class="nav_name">Dashboard</span>
              </a>
              <a href="${pageContext.request.contextPath}/users?action=listUsers" class="nav_link">
                <i class='bx bx-user-circle nav_icon'></i>
                <span class="nav_name">Users</span>
              </a>
              <a href="${pageContext.request.contextPath}/categories?action=listCategories" class="nav_link">
                <i class='bx bx-category nav_icon'></i>
                <span class="nav_name">Category</span>
              </a>
              <a href="${pageContext.request.contextPath}/product?action=listProducts" class="nav_link">
                <i class='bx bx-package nav_icon'></i>
                <span class="nav_name">Product</span>
              </a>
              <a href="#" class="nav_link">
                <i class='bx bx-cart nav_icon'></i>
                <span class="nav_name">Cart</span>
              </a>
              <a href="${pageContext.request.contextPath}/index?action=listProducts" class="nav_link">
                <i class='bx bx-store nav_icon'></i>
                <span class="nav_name">All Product</span>
              </a>
            </c:if>
          </c:when>
          <c:otherwise>
            <a href="${pageContext.request.contextPath}/index.jsp" class="nav_link">
              <i class='bx bx-home nav_icon'></i>
              <span class="nav_name">Trang Chủ</span>
            </a>
            <a href="${pageContext.request.contextPath}/index?action=listProducts" class="nav_link">
              <i class='bx bx-store nav_icon'></i>
              <span class="nav_name">Tất cả sản phẩm</span>
            </a>
            <a href="#" class="nav_link">
              <i class='bx bx-bell nav_icon'></i>
              <span class="nav_name">Thông báo</span>
            </a>
            <a href="#" class="nav_link">
              <i class='bx bx-news nav_icon'></i> <span class="nav_name">Bài viết</span>
            </a>
          </c:otherwise>
        </c:choose>
      </div>
    </div>

    <!-- Sign Out or Dashboard -->
    <c:if test="${not empty sessionScope.loggedInUser}">
      <c:choose>
        <c:when test="${sessionScope.loggedInUser.userRole == 'customer'}">
          <a href="#" class="nav_link" data-bs-toggle="modal" data-bs-target="#logoutModal">
            <i class='bx bx-log-out nav_icon'></i>
            <span class="nav_name">Đăng Xuất</span>
          </a>
        </c:when>
        <c:otherwise>
          <a href="${pageContext.request.contextPath}/dashboard" class="nav_link">
            <i class='bx bx-tachometer nav_icon'></i>
            <span class="nav_name">Quay lại Dashboard</span>
          </a>
        </c:otherwise>
      </c:choose>
    </c:if>
  </nav>
</div>

<!-- Logout Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logoutModalLabel">Đang đăng xuất...</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Bạn có chắc chắn muốn đăng xuất khỏi tài khoản này không?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Đăng Xuất</a>
      </div>
    </div>
  </div>
</div>

<!-- JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
  document.addEventListener("DOMContentLoaded", function(event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) =>{
      const toggle = document.getElementById(toggleId),
              nav = document.getElementById(navId),
              bodypd = document.getElementById(bodyId),
              headerpd = document.getElementById(headerId)

      if(toggle && nav && bodypd && headerpd){
        toggle.addEventListener('click', ()=>{
          nav.classList.toggle('show')
          toggle.classList.toggle('bx-x')
          bodypd.classList.toggle('body-pd')
          headerpd.classList.toggle('body-pd')
        })
      }
    }

    showNavbar('header-toggle','nav-bar','body-pd','header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink(){
      if(linkColor){
        linkColor.forEach(l=> l.classList.remove('active'))
        this.classList.add('active')
      }
    }
    linkColor.forEach(l=> l.addEventListener('click', colorLink))

  });
</script>
</body>
</html>