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

    <title>Đơn hàng</title>
  </head>

  <body>
    <div class="wrapper">
      <div class="collapse col-lg-2 d-lg-block sidecontainer">
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
                  <li class="breadcrumb-item active" aria-current="page" id="HeaderBreadcrumbText"></li>
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
              <h3 class="fw-bold">
                Danh sách đơn hàng</h3>
            </div>
            <div class="container orderTable p-0">
              <div class="container searchHeader">
                <form class="d-flex" role="search">
                  <input class="form-control" id="tableSearchBox" type="search"
                    placeholder="Tìm kiếm mã đơn hàng trong danh sách" aria-label="Search"
                    style="width: 450px; height: 40px; " />
                </form>
              </div>
              <div class="tableData p-0 table-responsive">
                <table class="table table-hover">

                  <colgroup>
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 15%;">
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 25%;">
                  </colgroup>
                  <thead>
                    <tr class="table-light">
                      <th scope="col">Mã đơn</th>
                      <th scope="col">Giá trị đơn</th>
                      <th scope="col">Tên khách hàng</th>
                      <th scope="col">Thời điểm đặt</th>
                      <th scope="col">Trạng thái</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>
                        <div class="d-flex justify-content-between">
                          <span>1000000</span>
                          <span><b>VND</b></span>
                        </div>
                      </td>
                      <td>Nguyễn Văn A</td>
                      <td>15/10/2023</td>
                      <td>
                        <div class="status status-waiting">Chờ xác nhận</div>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">1</th>
                      <td>
                        <div class="d-flex justify-content-between">
                          <span>1000000</span>
                          <span><b>VND</b></span>
                        </div>
                      </td>
                      <td>Nguyễn Văn A</td>
                      <td>15/10/2023</td>
                      <td>
                        <div class="status status-waiting">Chờ xác nhận</div>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">1</th>
                      <td>
                        <div class="d-flex justify-content-between">
                          <span>1000000</span>
                          <span><b>VND</b></span>
                        </div>
                      </td>
                      <td>Nguyễn Văn A</td>
                      <td>15/10/2023</td>
                      <td>
                        <div class="status status-waiting">Chờ xác nhận</div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"
      integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw=="
      crossorigin="anonymous"></script>

    <script src="navigation.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"></script>

  </body>

</html>