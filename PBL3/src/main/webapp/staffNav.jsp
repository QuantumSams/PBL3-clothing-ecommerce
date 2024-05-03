<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

  <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />

    <title>Hello, world!</title>
  </head>

  <body>
    <nav class="navbar bg-light bg-body-tertiary">
      <div class="container">
        <div class="container-fluid d-flex align-items-center">
          <nav aria-label="breadcrumb">
            <ol class="breadcrumb m-0 p-0 bg-transparent">
              <li class="breadcrumb-item"><a href="#">Cá nhân</a></li>
              <li class="breadcrumb-item active" aria-current="page">Cá nhân</li>
            </ol>
          </nav>
          <form class="d-flex" role="search">
            <input class="form-control me-0" type="search" placeholder="Search" aria-label="Search" />
          </form>
        </div>
      </div>

    </nav>
    <div class="container p-3">
      <div class="container-fluid p-0 pb-4 d-flex align-items-center justify-content-between">
        <h3 class="fw-bold">Quản lý thông tin cá nhân</h3>
        <button class="btn btn-dark">
          <i class="bi bi-pencil-square"></i>
          Chỉnh sửa thông tin
        </button>
      </div>

      <div class="row justify-content-center">
        <div class="col-lg-8 col-sm-12">
          <div class="row-100">
            <div class="card mb-4">
              <div class="card-body">
                <h4 class="card-title pb-1">Thông tin cá nhân</h5>
                  <dl class="row pb-1">
                    <dt class="col-sm-7">Họ và tên</dt>
                    <dd class="col-sm-5">Nguyễn Văn A</dd>
                  </dl>
                  <dl class="row pb-1">
                    <dt class="col-sm-7">Giới tính</dt>
                    <dd class="col-sm-5">Nam</dd>
                  </dl>
                  <dl class="row pb-1">
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
          <div class="row-100 row-cols">
            <div class="card mb-4">
              <div class="card-body">
                <h4 class="card-title pb-1">Thông tin tài khoản</h5>
                  <dl class="row pb-1">
                    <dt class="col-sm-7">Tài khoản</dt>
                    <dd class="col-sm-5">nguyenvana@123</dd>
                  </dl>
                  <dl class="row align-items-center">
                    <dt class="col-sm-7">Mật khẩu</dt>
                    <dd class="col-sm-5 d-flex justify-content-between align-items-center">
                      password
                      <button type="button" class="btn btn-dark"><i class="bi bi-eye-fill"></i></button>
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
              <h4 class="card-title">Ảnh chân dung</h4>
              <img
                src="https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?q=80&w=2662&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                class="img-fluid">
            </div>
          </div>
        </div>
      </div>

    </div>
  </body>

</html>