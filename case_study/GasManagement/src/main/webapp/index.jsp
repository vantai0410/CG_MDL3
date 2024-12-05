<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<title>Gas Lộc Hiển</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<style>
  /*.navbar-nav .nav-link {*/
  /*    font-weight: bold;*/
  /*    color: white;*/
  /*}*/
  /*.navbar-brand {*/
  /*    font-weight: bold;*/
  /*    color: white;*/
  /*}*/
  /*.nav-link active {*/
  /*    font-weight: bold;*/
  /*    color: white;*/
  /*}*/
  .navbar-nav .nav-link {
    font-weight: bold;
    color: white !important;
  }
  .navbar-brand {
    color: white;
    font-weight: bold;
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
  h5{
    text-align: center;
  }
  p{
    color: red;
    text-align: center;
  }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-danger">
  <div class="container-fluid">
    <a class="navbar-brand" href="Gas.html"><i class='bx bx-home-alt-2'></i>Gas</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Goi_Gas.html">Gọi gas</a>

        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Sửa chữa và bảo hành</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Bếp & loại khác
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="Bep_gas.html" >Bếp gas</a></li>
            <li><a class="dropdown-item" href="#">Bếp điện</a></li>
            <li><a class="dropdown-item" href="#">Máy hút mùi</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Feedback</a>
        </li>
      </ul>
      <form style="margin-right: 50px">
        <button class="btn btn-outline-dark" onclick='addToCart("+ i +")'><i class='bx bx-cart-add'></i></button>
      </form>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-dark" type="submit">Search</button>
      </form>

    </div>
  </div>
</nav>

<h3 style="margin-top: 10px">SẢN PHẨM GAS ĐANG BÁN CHẠY</h3>
<div id="gasCarousel" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="row">
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-20.jpg" class="card-img-top" >
            <div class="card-body">
              <h5 class="card-title">Gas Petrolimex</h5>
              <p class="card-text"><b>500.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-17.jpg" class="card-img-top">
            <div class="card-body">
              <h5 class="card-title">Gas Petrodana 12kg</h5>
              <p class="card-text"><b>480.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-11.jpg" class="card-img-top" >
            <div class="card-body">
              <h5 class="card-title">Gas Gia Đình đỏ 12kg</h5>
              <p class="card-text"><b>502.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card">
            <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-21.jpg" class="card-img-top" >
            <div class="card-body">
              <h5 class="card-title">Gas Siam tím 12kg</h5>
              <p class="card-text"><b>502.000 ₫</b></p>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="row">
            <div class="col-md-3">
              <div class="card">
                <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/BinhGas_new-18.jpg" class="card-img-top">
                <div class="card-body">
                  <h5 class="card-title">Gas Thái Lan</h5>
                  <p class="card-text"><b>490.000 ₫</b></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#gasCarousel" data-bs-slide="prev"><i class='bx bx-right-arrow-alt' ></i>
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
              <h5 class="card-title">
                Bếp Rinnai RV-375(G)N</h5>
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
              <h5 class="card-title">
                Bếp gas âm Rinnai RV-2BG</h5>
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
        <div class="carousel-item">
          <div class="row">
            <div class="col-md-4">
              <div class="card">
                <img src="https://ecom.viettechsmart.com:5020/Media/Images/0/Frame_Window_Bep02-01.jpg" class="card-img-top">
                <div class="card-body">
                  <h5 class="card-title">Bếp khò Windo 168TW</h5>
                  <p class="card-text"><b>685.000 ₫</b></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev"><i class='bx bx-right-arrow-alt' ></i>
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<br/>
<a href="/order">Hello Servlet</a>
</body>
</html>