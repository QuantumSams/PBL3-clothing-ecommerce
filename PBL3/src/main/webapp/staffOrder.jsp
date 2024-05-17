<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

  <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" href="css/custom.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Sarabun:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
      rel="stylesheet">

    <title>Quản lý thông tin cá nhân</title>
  </head>

  <body>
    <div class="wrapper">
      <div class="collapse col-xl-2 d-xl-block sidecontainer">
        <div class="sidebar">
          <div class="head">
            <div class="user-img">
              <img
                src="https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?q=80&w=2662&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                alt>
            </div>
          </div>
          <div class="nav">
            <div class="menu">
              <p class="title">Chức năng</p>
              <ul class="sidelist">
                <li class="active">
                  <a href="#">
                    <i class="bi bi-archive-fill"></i>
                    <span class="text">Đơn hàng</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <i class="bi bi-chat-square-text-fill"></i>
                    <span class="text">Chat</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <i class="bi bi-person-fill"></i>
                    <span class="text">Cá nhân</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="content">
        <nav class="navbar">
          <div class="container">
            <div class="container-fluid d-flex align-items-center justify-content-between flex-wrap gap-2">
              <nav class="d-flex align-items-center gap-2" aria-label="breadcrumb">
                <button class="navbar-toggler d-xl-none" type="button" data-toggle="collapse"
                  data-target=".sidecontainer" aria-controls="sidebar" aria-expanded="false"
                  aria-label="Toggle navigation" id="toggleSidebar">
                  <i class="bi bi-list"></i>
                </button>
                <ol class="breadcrumb m-0 p-0 bg-transparent">
                  <li class="breadcrumb-item"><a href="#" id="HeaderBreadcrumbLink">Đơn hàng</a></li>
                  <li class="breadcrumb-item active" aria-current="page" id="HeaderBreadcrumbText">Đơn hàng 01</li>
                </ol>
              </nav>

              <form class="d-flex" role="search">

                <input class="form-control me-0" type="search" placeholder="Tìm kiếm" aria-label="Search"
                  style="width: 300px;" />
              </form>
            </div>
          </div>

        </nav>
        <div class="container main">
          <div class="container one-page" id="viewProfilePage">
            <div
              class="container-fluid ps-1 pe-0 py-3 d-flex justify-content-between align-items-center flex-wrap gap-2">
              <h3 class="fw-bold">Đơn hàng 01</h3>

            </div>
            <div class="row g-lg-3">
              <div class="col-xl-8 col-sm-12">
                <div class="row m-0">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">Thông tin cá nhân</h5>
                      <dl class="row">
                        <dt class="col-sm-4">Họ và tên</dt>
                        <dd class="col-sm-8">Nguyễn Văn A</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Giới tính</dt>
                        <dd class="col-sm-8">Nam</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Số điện thoại</dt>
                        <dd class="col-sm-8">0934 123 456</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Địa chỉ</dt>
                        <dd class="col-sm-8">Thanh Khê, Đà Nẵng</dd>
                      </dl>
                      </p>
                    </div>
                  </div>
                </div>
                <div class="row m-0">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">Thành tiền</h5>
                      <dl class="row">
                        <dd class="col-sm-8">Tổng tiền hàng</dd>
                        <dd class="col-sm-2">12 000</dd>
                        <dt class="col-sm-2">VND</dt>
                      </dl>
                      <dl class="row">
                        <dd class="col-sm-8">Phí vận chuyển</dd>
                        <dd class="col-sm-2">0</dd>
                        <dt class="col-sm-2">VND</dt>
                      </dl>
                      <dl class="row">
                        <dd class="col-sm-8">Giảm giá</dd>
                        <dd class="col-sm-2">0</dd>
                        <dt class="col-sm-2">VND</dt>
                      </dl>
                      <dl class="row">
                        <dd class="col-sm-8">Thành tiền</dd>
                        <dd class="col-sm-2">12 000</dd>
                        <dt class="col-sm-2">VND</dt>
                      </dl>
                    </div>
                  </div>
                </div>
                <button type="button pb-1" class="btn btn-dark p0 w-100" id="passwordEye">Xác nhận đơn hàng
                </button>
              </div>
              <div class="col-xl-4 col-sm-12">
                <div class="row m-0">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">
                        Thông tin giao nhận
                      </h5>
                      <dl class="row">
                        <dt class="col-sm-5 row-12">Họ và tên</dt>
                        <dd class="col-sm-7 row-12">Nguyễn Văn A</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-5 row-12">SĐT giao hàng</dt>
                        <dd class="col-sm-7 row-12">0934 123 456</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-5 row-12">Địa chỉ giao hàng</dt>
                        <dd class="col-sm-7 row-12">31 Ba Đình, phường Thạch Trang, quận Hải Châu, Thành phố Đà Nẵng
                        </dd>
                      </dl>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">
                        Thông tin đơn hàng
                      </h5>
                      <dl class="row">
                        <dt class="col-sm-7 row-12">Số lượng sản phẩm</dt>
                        <dd class="col-sm-5 row-12">189</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-7 row-12">Đặt vào lúc</dt>
                        <dd class="col-sm-5 row-12">25/12/2023</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-7 row-12">Giao vào lúc</dt>
                        <dd class="col-sm-5 row-12">-
                        </dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-7 row-12">Nhân viên xác nhận</dt>
                        <dd class="col-sm-5 row-12">-
                        </dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-7 row-12">Trạng thái</dt>
                        <dd class="col-sm-5 row-12">-
                        </dd>
                      </dl>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">
                        Ghi chú đơn hàng
                      </h5>
                      Chỉ giao vào cuối tuần
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">
                        Huỷ đơn hàng
                      </h5>
                      <button type="button" class="btn btn-danger p0 w-100" id="cancelOrder"><i
                          class="bi bi-x-octagon-fill pe-1"></i>
                        Huỷ đơn hàng</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"
      integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw=="
      crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  </body>

</html>