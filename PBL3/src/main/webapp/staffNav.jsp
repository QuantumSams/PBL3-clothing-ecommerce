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
                <li>
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
                <li class="active">
                  <a href="staffNav.jsp">
                    <i class=" bi bi-person-fill"></i>
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
                  <li class="breadcrumb-item"><a href="staffNav.jsp" id="HeaderBreadcrumbLink">Cá nhân</a></li>
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
              <h3 class="fw-bold">Quản lý thông tin cá nhân</h3>
              <div class="d-flex gap-2" id="editGroup">
                <button class="btn btn-dark p0" id="editButton">
                  <i class="bi bi-pencil-square"></i>
                  Chỉnh sửa thông tin
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
                        <dt class="col-sm-4">Họ và tên</dt>
                        <dd class="col-sm-8" id="viewProfilePageName">${acc.ho_ten}</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Giới tính</dt>
                        <dd class="col-sm-8" id="viewProfilePageGender">${acc.ho_ten}</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Số điện thoại</dt>
                        <dd class="col-sm-8" id="viewProfilePagePhoneNum">${acc.so_dien_thoai}</dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Địa chỉ</dt>
                        <dd class="col-sm-8" id="viewProfilePageAddress">${acc.dia_chi}</dd>
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
                        <dt class="col-sm-4">Tài khoản</dt>
                        <dd class="col-sm-8">
                          <input class="form-control" id="viewProfilePageAccount" readonly>
                        </dd>
                      </dl>
                      <dl class="row align-items-center">
                        <dt class="col-sm-4">Mật khẩu</dt>
                        <dd class="col-sm-8 d-flex 
                                                                justify-content-between
                                                                align-items-center">
                          <input class="form-control me-2" id="viewProfilePagePassword" type="password" readonly>
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
                    <h5 class="card-title fw-bold">
                      Ảnh chân dung
                    </h5>
                    <img class="img-fluid" id="viewProfilePageImage" src="${acc.anh_dai_dien}">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="container one-page" id="editProfilePage">
            <div
              class="container-fluid ps-1 pe-0 py-3 d-flex justify-content-between align-items-center flex-wrap gap-2">
              <h3 class="fw-bold">Chỉnh sửa thông tin</h3>
              <div class="d-flex gap-2" id="EditProfleButtonGroup">
                <button class="btn btn-dark data" data-bs-toggle="modal" data-bs-target="#saveModal">
                  Lưu thông tin
                </button>
                <button class="btn btn-outline-dark" id="cancelButton">
                  Huỷ
                </button>
              </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="saveModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Lưu thông tin</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <p>Bạn có thật sự muốn lưu thông tin?</p>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="saveButton">Lưu</button>
                    <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Huỷ</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="row g-lg-3">
              <div class="col-lg-8 col-sm-12">
                <div class="row m-0">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="card-title fw-bold">Thông tin cá nhân</h5>
                      <dl class="row">
                        <dt class="col-sm-4">Họ và tên</dt>
                        <dd class="col-sm-8">
                          <input class="form-control" id="EditProfileNameField" type="text">
                        </dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Giới tính</dt>
                        <dd class="col-sm-8">
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                              id="EditProfileGenderRadioMale">
                            <label class="form-check-label" for="flexRadioDefault1">
                              Nam
                            </label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                              id="EditProfileGenderRadioFemale" checked>
                            <label class="form-check-label" for="flexRadioDefault2">
                              Nữ
                            </label>
                          </div>
                        </dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Số điện thoại</dt>
                        <dd class="col-sm-8"><input class="form-control" id="EditProfilePhoneField" type="text">
                        </dd>
                      </dl>
                      <dl class="row">
                        <dt class="col-sm-4">Địa chỉ</dt>
                        <dd class="col-sm-8">
                          <textarea class="form-control" id="EditProfileAddressField" rows="3">31 Ba Đình, phường Hoà Cường Nam, quận Hải Châu, Đà Nẵng

                          </textarea>
                        </dd>
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
                        <dt class="col-sm-4">Tài khoản</dt>
                        <dd class="col-sm-8"><input class="form-control" id="EditProfileUsernameField" type="text">
                        </dd>
                      </dl>
                      <dl class="row align-items-center">
                        <dt class="col-sm-4">Mật khẩu</dt>
                        <dd class="col-sm-8 d-flex 
                                                                justify-content-between
                                                                align-items-center">
                          <input class="form-control me-2" type="password" id="EditProfilePasswordField">
                          <button type="button" class="btn btn-dark p0" id="EditProfilePasswordFieldEyeButton"><i
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
                    <h5 class="card-title fw-bold">
                      <div class="d-flex justify-content-between align-items-center flex-wrap gap-2"
                        id="EditProfileImageUpload">
                        Ảnh chân dung
                        <button class="btn btn-dark p0" id="EditProfileImageUploadButton">
                          <i class="bi bi-cloud-arrow-up-fill"></i>
                          Tải ảnh lên
                        </button>
                      </div>
                    </h5>
                    <img
                      
                      class="img-fluid" id="EditProfileImageUploadShow">
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
    <script src="navigation.js"></script>
    <script src="staffNav.js"></script>
    <script src="staffNav_editPage.js"></script>
    <script src="staffNav_navigation.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"></script>

  </body>

</html>