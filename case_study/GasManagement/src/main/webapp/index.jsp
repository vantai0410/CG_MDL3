<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gas Lộc Hiển</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f4f6f9;
      font-family: 'Arial', sans-serif;
    }

    /* CSS chung cho tất cả navbar */
    .navbar {
      background-color: #ff4d4d; /* Màu nền đỏ */
      border-bottom: 2px solid #e74c3c; /* Viền dưới để nổi bật */
    }

    .navbar-brand {
      font-weight: bold;
      color: white;
      font-size: 1.3rem; /* Kích thước chữ */
    }

    .navbar-nav .nav-link {
      color: white !important;
      font-weight: bold;
      font-size: 1rem; /* Đồng nhất kích thước chữ */
    }

    .navbar-nav .nav-link:hover {
      color: #e74c3c !important; /* Hiệu ứng hover */
    }

    .navbar-toggler-icon {
      background-color: white; /* Đổi màu icon toggle */
      border-radius: 50%; /* Icon toggle tròn */
    }

    .search-form {
      display: flex;
      justify-content: flex-end;
      align-items: center;
    }

    .search-form input {
      width: 200px;
      border: 2px solid #e74c3c; /* Viền đỏ */
      border-radius: 5px; /* Bo góc */
      padding: 5px;
    }

    .search-form button {
      background-color: #ff4d4d;
      color: white;
      border: none;
      border-radius: 5px;
      padding: 5px 10px;
      margin-left: 5px;
    }

    .search-form button:hover {
      background-color: #e74c3c;
      color: black;
    }


    .carousel-control-prev-icon,
    .carousel-control-next-icon {
      background-color: black; /* Đổi màu nền để mũi tên nổi bật hơn */
      border-radius: 50%; /* Tạo nút hình tròn */
    }

    .carousel-control-prev,
    .carousel-control-next {
      width: 5%; /* Đảm bảo nút đủ lớn để nhìn thấy và nhấp vào */
    }

    .card-body {
      text-align: center;
    }

    .card-title {
      font-size: 1.2rem;
      font-weight: bold;
    }

    .card-text {
      color: #ff4d4d;
      font-size: 1.1rem;
    }

    h3 {
      text-align: center;
      margin-top: 30px;
      font-size: 1.5rem;
      color: #333;
    }

    .carousel-item img {
      width: 100%;
      height: auto;
      border-radius: 8px;
    }

    .back-link {
      display: block;
      text-align: center;
      margin-top: 20px;
      font-size: 16px;
    }

    .back-link a {
      color: #ff4d4d;
      text-decoration: none;
    }

    .back-link a:hover {
      text-decoration: underline;
    }

    .card:hover {
      border: 2px solid red;
      box-shadow: 0 0 10px rgba(255, 0, 0, 0.5);
      transition: all 0.3s ease-in-out;
    }
  </style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class='bx bx-home-alt-2'></i> Gas</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" href="/order">Đơn hàng</a></li>
        <li class="nav-item"><a class="nav-link" href="/order/create_list.jsp">Thêm đơn</a></li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Sản phẩm
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="">Gas</a></li>
            <li><a class="dropdown-item" href="#">Bếp gas</a></li>
            <li><a class="dropdown-item" href="#">Máy hút mùi</a></li>
          </ul>
        </li>
        <li class="nav-item"><a class="nav-link disabled"></a></li>
      </ul>
      <form action="/order" method="GET" class="search-form">
        <input
                class="form-control me-2"
                type="text"
                name="orderID"
                placeholder="Mã Đơn Hàng"
                value="${param.orderID}">

        <input
                class="form-control me-2"
                type="text"
                name="customerID"
                placeholder="Mã Khách Hàng"
                value="${param.customerID}">
        <input type="hidden" name="action" value="search">
        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
      </form>


    </div>
  </div>
</nav>
<h3>SẢN PHẨM GAS ĐANG BÁN CHẠY</h3>
<div id="gasCarousel" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="row">
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-20.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Petrolimex</h5>
              <p class="card-text"><b>500.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-16.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Bình Sơn</h5>
              <p class="card-text"><b>450.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-23.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Saigon Petro</h5>
              <p class="card-text"><b>520.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-19.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Shell</h5>
              <p class="card-text"><b>510.000 ₫</b></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="carousel-item">
      <div class="row">
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-18.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas PV Gas</h5>
              <p class="card-text"><b>530.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-21.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Gasco</h5>
              <p class="card-text"><b>490.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-22.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Dầu khí</h5>
              <p class="card-text"><b>550.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-17.jpg" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Gas Miền Bắc</h5>
              <p class="card-text"><b>470.000 ₫</b></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#gasCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#gasCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
<h3 style="margin-top: 10px">SẢN PHẨM BẾP GAS ĐANG BÁN CHẠY</h3>
<div id="bepCarousel" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="row">
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BepGas_Rinnai-04.jpg" class="card-img-top" >
            <div class="card-body">
              <h5 class="card-title">Bếp Rinnai RV-375(G)N</h5>
              <p class="card-text"><b>997.500 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BepGas_Rinnai--05.jpg" class="card-img-top">
            <div class="card-body">
              <h5 class="card-title">Bếp Rinnai RV-370(GM)N</h5>
              <p class="card-text"><b>807.500 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BepGas_Rinnai--01.jpg" class="card-img-top" >
            <div class="card-body">
              <h5 class="card-title">Bếp gas âm Rinnai RV-2BG</h5>
              <p class="card-text"><b>3.710.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/Frame_Window_Bep02-01.jpg" class="card-img-top" >
            <div class="card-body">
              <h5 class="card-title">Bếp khè Windo 168TW</h5>
              <p class="card-text"><b>685.000 ₫</b></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="carousel-item">
      <div class="row">
        <div class="col-md-4">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/Frame_Window_Bep02-01.jpg" class="card-img-top">
            <div class="card-body">
              <h5 class="card-title">Bếp khè Windo 168TW</h5>
              <p class="card-text"><b>685.000 ₫</b></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#bepCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#bepCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
