<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/01/2025
  Time: 9:17 SA
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
    <title>Sản Phẩm</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
          integrity="sha512-..." crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- FontAwesome for icons -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<!-- Gọi sidebar -->
<jsp:include page="${pageContext.request.contextPath}/common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="${pageContext.request.contextPath}/common/toast.jsp" />

<div class="main-content" style="margin-top: 4rem">
    <div class="row">
        <!-- Main content -->
        <main class="fade-in" id="page-title">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Danh Sách Các Sản Phẩm</h1>
            </div>

            <!-- Button Thêm Người Dùng -->
            <a href="${pageContext.request.contextPath}/product?action=createProduct" class="btn btn-success btn-md mb-3">
                <i class="fas fa-plus-circle"></i> Thêm Sản Phẩm
            </a>

            <%-- Search --%>
            <form action="${pageContext.request.contextPath}/product?action=listProducts" method="get">
                <div class="input-group" style="max-width: 500px;">
                    <input type="text" class="form-control" id="searchProduct" name="searchProduct"
                           placeholder="Nhập thông tin sản phẩm"
                           value="${param.searchProduct}"
                           aria-label="Tìm sản phẩm">

                    <button class="btn btn-primary" type="submit">
                        <i class="fas fa-search"></i> Tìm kiếm
                    </button>

                    <!-- Nút quay lại nếu có tìm kiếm -->
                    <c:if test="${not empty param.searchProduct}">
                        <a href="${pageContext.request.contextPath}/product?action=listProducts"
                           class="btn btn-secondary ms-2">
                            <i class="fas fa-arrow-left"></i> Quay lại
                        </a>
                    </c:if>
                </div>
            </form>

            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Giá sản phẩm</th>
                        <th>Nhãn hàng</th>
                        <th>Ảnh</th>
                        <th>Số lượng trong kho</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${listProducts}" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${product.product_name}</td>
                            <td>${product.formattedPrice}</td>
                            <td>${product.categories_name}</td>
                            <td><img src="${product.product_img}" alt="product" style="width: 100px"></td>
                            <td>${product.product_stock}</td>
                            <td>
                                <a href="/product?action=viewProduct&product_name=${product.product_name}" class="btn btn-primary btn-sm me-1">
                                    <i class="fas fa-eye"></i> Xem
                                </a>

                                <a href="${pageContext.request.contextPath}/product?action=updateProduct&product_name=${product.product_name}" class="btn btn-secondary btn-sm me-1">
                                    <i class="fas fa-pen"></i> Sửa
                                </a>

                                <!-- Nút Xóa, hiển thị Modal -->
                                <button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
                                        data-product_name="${product.product_name}">
                                    <i class="fas fa-trash-alt"></i> Xóa
                                </button>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Xác Nhận Xóa Sản Phẩm</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xóa sản phẩm <strong id="productDisplay"></strong> không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>

                <!-- Form xóa người dùng -->
                <form id="deleteCategoryForm" action="${pageContext.request.contextPath}/product?action=deleteProduct" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="deleteProduct">
                    <input type="hidden" name="product_name" id="productToDelete">
                    <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%--Js modal--%>
<script>
    var deleteButtons = document.querySelectorAll('[data-bs-toggle="modal"]');
    deleteButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            var product_name = button.getAttribute('data-product_name');
            document.getElementById('productDisplay').textContent = product_name;
            document.getElementById('productToDelete').value = product_name;
        });
    });
</script>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>