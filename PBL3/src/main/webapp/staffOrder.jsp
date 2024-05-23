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
              <img src="img/management_logo.png" alt>
            </div>
          </div>
          <div class="nav">
            <div class="menu">
              <p class="title">Chức năng</p>
              <ul class="sidelist">
                <li class="active">
                  <a href="staffOrderList.jsp">
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
                  <a href="staffNav.jsp">
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
                <button class="navbar-toggler d-lg-none" type="button" aria-controls="sidebar" aria-expanded="false"
                  data-bs-toggle="collapse" data-bs-target=".sidecontainer" aria-label="Toggle navigation"
                  id="toggleSidebar">
                  <i class="bi bi-list"></i>
                </button>
                <ol class="breadcrumb m-0 p-0 bg-transparent">
                  <li class="breadcrumb-item"><a href="staffOrderList.jsp" id="HeaderBreadcrumbLink">Đơn hàng</a></li>
                  <li class="breadcrumb-item active" aria-current="page" id="orderHeadingTitle">Đơn hàng 01</li>
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
            <div class="container-fluid ps-1 pe-0 py-3 d-flex align-items-center flex-wrap gap-2">
              <button type="button" class="btn btn-primary btn-sm rounded-circle" id="backButton">
                <i class="bi bi-caret-left-fill"></i>
              </button>
              <h3 class="fw-bold m-0" id="orderTitle"></h3>
            </div>
            <div class="row g-lg-3">
              <div class="col-xl-8 col-sm-12">
                <div class="row m-0">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">Danh sách sản phẩm</h5>

                      <table class="table table-hover w-100">
                        <colgroup>
                          <col span="1" style="width: 5%;">
                          <col span="1" style="width: 40%;">
                          <col span="1" style="width: 20%;">
                          <col span="1" style="width: 30%;">
                          <col span="1" style="width: 5%;">
                        </colgroup>
                        <thead>
                          <tr class="table-primary">
                            <th scope="col">STT</th>
                            <th scope="col">Sản phẩm</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Thành tiền</th>
                            <th><button type="button" class="btn btn-disabled p0" id="passwordEye"></button></th>
                          </tr>
                        </thead>
                        <tbody>

                          <!-- Thêm dữ liệu vào bảng tại đây <-->
                          <!--
                    <c:forEach var="item" items="${list_san_pham_mua}">
                    <tr>
                      <th scope="row">{item.index}</th>
                      <td>
                        <div class="d-flex gap-1">
                          ${item.key.ten_san_pham}
                        </div>
                        <div class="status status-accent">${item.key.kich_thuoc_san_pham.ten_size}/${item.key.mau_sac_san_pham.ten_mau}</div>
                        </div>
                      </td>
                      <td>{item.value}</td>
                      <td>
                        <span class="me-5">
                          {item.key.gia_ban_san_pham}
                        </span>
                        <span>
                          VND
                        </span>
                      </td>
                      <td><button type="button" class="btn btn-outline-danger p-1" id="removeProduct">
                          <i class="bi bi-trash3-fill"></i></button>
                        </button>
                      </td>
                    </tr>
                        <-->

                          <!-- Ví dụ 1 hàng dữ liệu-->
                          <tr>
                            <th scope="row">1</th>
                            <td>
                              <div class="d-flex gap-1">
                                Áo thun dáng rộng tay lỡ
                              </div>
                              <div class="status status-accent">S/Xanh biển</div>
                    </div>
                    </td>
                    <td>1</td>
                    <td>
                      <span class="me-5">
                        15 000
                      </span>
                      <span>
                        VND
                      </span>
                    </td>
                    <td><button type="button" class="btn btn-outline-danger p-1" id="removeProduct">
                        <i class="bi bi-trash3-fill"></i></button>
                      </button>

                    </td>
                    </tr>
                    <!-- Hết ví dụ-->
                    </tbody>
                    </table>
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
                      <dd class="col-sm-2" id="orderValueSum"></dd>
                      <dt class="col-sm-2">VND</dt>
                    </dl>
                    <dl class="row">
                      <dd class="col-sm-8">Phí vận chuyển</dd>
                      <dd class="col-sm-2" id="orderValueShippingFee"></dd>
                      <dt class="col-sm-2">VND</dt>
                    </dl>
                    <dl class="row">
                      <dd class="col-sm-8">Giảm giá</dd>
                      <dd class="col-sm-2" id="orderValueDiscount"></dd>
                      <dt class="col-sm-2">VND</dt>
                    </dl>
                    <dl class="row">
                      <dd class="col-sm-8">Thành tiền</dd>
                      <dd class="col-sm-2" id="orderValueTotal"></dd>
                      <dt class="col-sm-2">VND</dt>
                    </dl>
                  </div>
                </div>
              </div>
              <button type="button pb-1" class="btn btn-dark m-0 w-100" id="confirmOrderModalTrigger"
                data-bs-toggle="modal" data-bs-target="#confirmOrderModal">Xác nhận đơn hàng</button>

              <div class="modal fade" id="confirmOrderModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận đơn hàng</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      Bạn muốn thật sự xác nhận đơn hàng?
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-primary" id="orderConfirmButton">Xác nhận</button>
                      <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Huỷ</button>
                    </div>
                  </div>
                </div>
              </div>
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
                      <dd class="col-sm-7 row-12" id="shippingInfoName"></dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-5 row-12">SĐT giao hàng</dt>
                      <dd class="col-sm-7 row-12" id="shippingInfoPhoneNum"></dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-5 row-12">Địa chỉ giao hàng</dt>
                      <dd class="col-sm-7 row-12" id="shippingInfoAddress">
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
                      <dt class="col-sm-5 row-12">Số lượng sản phẩm</dt>
                      <dd class="col-sm-7 row-12" id="orderInfoQuantity"></dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-5 row-12">Đặt vào lúc</dt>
                      <dd class="col-sm-7 row-12" id="orderInfoPlacingDate"></dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-5 row-12">Giao vào lúc</dt>
                      <dd class="col-sm-7 row-12" id="orderInfoShippingDate">
                      </dd>
                    </dl>
                    <dl class="row">
                      <dt class="col-sm-5 row-12">Nhân viên xác nhận</dt>
                      <dd class="col-sm-7 row-12" id="orderInfoEmployee">
                      </dd>
                    </dl>
                    <dl class="row align-items-center">
                      <dt class="col-sm-5 row-12">Trạng thái</dt>
                      <dd class="col-sm-7 row-12">
                        <div id="orderInfoStatus"></div>
                      </dd>
                    </dl>
                  </div>
                </div>
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title fw-bold">
                      Ghi chú đơn hàng
                    </h5>
                    <p id="orderNote"></p>

                  </div>
                </div>
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title fw-bold">
                      Huỷ đơn hàng
                    </h5>
                    <button type="button" class="btn btn-danger p0 w-100" id="cancelOrderModalTrigger"
                      data-bs-toggle="modal" data-bs-target="#cancelOrderModal"><i
                        class="bi bi-x-octagon-fill pe-1"></i>
                      Huỷ đơn hàng</button>

                    <div class="modal fade" id="cancelOrderModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                      aria-hidden="true">
                      <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Huỷ đơn hàng</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                            Bạn muốn thật sự huỷ đơn hàng?
                            <h5>Hành động này không thể hoàn tác!</h5>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-danger" id="orderCancelButton">Huỷ đơn
                              hàng</button>
                            <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Hoàn
                              tác</button>
                          </div>
                        </div>
                      </div>
                    </div>


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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"></script>
    <script src="navigation.js"></script>
    <script src="staffOrder.js"></script>
    <script src="orderStatus.js"></script>
    <script src="staffOrderAction.js"></script>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  </body>

</html>