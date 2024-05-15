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
      <div class="sidecontainer">
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
          <div class="container p-0">
            <div class="container-fluid d-flex align-items-center justify-content-between">
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb m-0 p-0 bg-transparent">
                  <li class="breadcrumb-item"><a href="#">Cá nhân</a></li>
                  <li class="breadcrumb-item active" aria-current="page">Cá nhân</li>
                </ol>
              </nav>

              <form class="d-flex" role="search">

                <input class="form-control me-0" type="search" placeholder="Tìm kiếm" aria-label="Search"
                  style="width: 300px;" />
              </form>
            </div>
          </div>

        </nav>
        <main class="container">
          <div class="container-fluid ps-1 pe-0 py-3 d-flex justify-content-between align-items-center">
            <h3 class="fw-bold">Quản lý thông tin cá nhân</h3>
            <button class="btn btn-dark p0" id="editButton">
              <i class="bi bi-pencil-square"></i>
              Chỉnh sửa thông tin
            </button>

            <div class="d-flex gap-2" id="editGroup">
              <button class="btn btn-dark">
                Lưu thông tin
              </button>
              <button class="btn btn-outline-dark">
                Huỷ
              </button>
            </div>
          </div>
          <div class="row g-lg-3">
            <div class="col-lg-8 col-sm-12">
              <div class="row m-0">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title fw-bold">Thông tin cá nhân</h5>
                    <dl class="row">
                      <dt class="col-sm-7">Họ và tên</dt>
                      <dd class="col-sm-5">Nguyễn Văn A</dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-7">Giới tính</dt>
                      <dd class="col-sm-5">Nam</dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-7">Số điện thoại</dt>
                      <dd class="col-sm-5">0934 123 456</dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-7">Địa chỉ</dt>
                      <dd class="col-sm-5">Thanh Khê, Đà Nẵng</dd>
                    </dl>
                    </p>
                  </div>
                </div>
              </div>
              <div class="row m-0">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title fw-bold">Thông tin tài khoản</h5>
                    <dl class="row">
                      <dt class="col-sm-7">Tài khoản</dt>
                      <dd class="col-sm-5"><input class="form-control" type="text" value="nguyenvana@123" readonly></dd>
                    </dl>
                    <dl class="row align-items-center">
                      <dt class="col-sm-7">Mật khẩu</dt>
                      <dd class="col-sm-5 d-flex 
                                                    justify-content-between
                                                    align-items-center">
                        <input class="form-control me-2" type="password" value="123456" readonly id="passwordField">
                        <button type="button" class="btn btn-dark p0" id="passwordEye"><i
                            class="bi bi-eye-fill"></i></button>
                      </dd>
                    </dl>
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-sm-12">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title fw-bold">Ảnh chân dung</h5>
                  <img
                    src="https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?q=80&w=2662&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                    class="img-fluid">
                </div>
              </div>
            </div>
          </div>
        </main>
      </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"
      integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw=="
      crossorigin="anonymous"></script>
    <script src="sidebar.js"></script>
  </body>

</html>