<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/12/2024
  Time: 8:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add New Product</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f8f9fa; /* Màu nền nhạt */
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column; /* Căn dọc các phần tử */
      align-items: center;
      justify-content: center;
      height: 100vh; /* Chiều cao toàn màn hình */
    }

    h1 {
      text-align: center;
      color: #343a40; /* Màu chữ đậm */
      margin-bottom: 20px;
    }

    form {
      background-color: #ffffff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Đổ bóng */
      width: 100%;
      max-width: 400px; /* Chiều rộng tối đa */
    }

    label {
      font-weight: bold;
      margin-bottom: 5px;
      display: block;
    }

    input, select, textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ced4da;
      border-radius: 4px;
      box-sizing: border-box;
    }

    button {
      width: calc(50% - 5px); /* Nút bấm chiếm 50% chiều rộng */
      margin-right: 10px;
    }

    button:last-child {
      margin-right: 0;
    }
  </style>



</head>
<body>
<h1>Add New Product</h1>
<form action="/product?action=add-product" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br>

  <label for="price">Price:</label>
  <input type="number" id="price" name="price" min="10000000" required><br>

  <label for="quantity">Quantity:</label>
  <input type="number" id="quantity" name="quantity" min="1" required><br>

  <label for="color">Color:</label>
  <select id="color" name="color" required>
    <option value="Red">Red</option>
    <option value="Blue">Blue</option>
    <option value="Black">Black</option>
    <option value="White">White</option>
    <option value="Yellow">Yellow</option>
  </select><br>

  <label for="description">Description:</label>
  <textarea id="description" name="description"></textarea><br>

  <label for="category">Category:</label>
  <select id="category" name="category" required>
    <c:forEach var="category" items="${categories}">
      <option value="${category.categoryId}">${category.categoryName}</option>
    </c:forEach>
  </select><br>

  <button class="btn btn-sm btn-success" type="submit">Create</button>
  <button type="button" onclick="window.location.href='/product'">Cancel</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>
