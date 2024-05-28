<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta Name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="chucuahang.css">
            <link rel="stylesheet" href="css/custom.min.css">
            <title>Document</title>

            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link
                href="https://fonts.googleapis.com/css2?family=Sarabun:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
                rel="stylesheet">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        </head>
        <div class="wrapper">
            <div class="collapse col-lg-2 d-lg-block sidecontainer p-0">
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
                                <li class="productSidebar">
                                    <a href="#">
                                        <i class="bi bi-archive-fill"></i>
                                        <span class="text me-3">Sản phẩm</span>
                                        <i class="bi bi-caret-down-fill"></i>
                                    </a>
                                    <ul class="list-group submenu ms-3">
                                        <li class="pt-1" id="productList">
                                            <a data-toggle="list" href="#san-pham" class="ps-3">Danh sách
                                                SP</a>
                                        </li>
                                        <li>
                                            <a href="#" id="categoryList" class="ps-3">Danh mục</a>
                                        </li>
                                    </ul>
                                </li>
                                <li id="inventorySidebar">
                                    <a data-toggle="list" href="#kho-hang">
                                        <i class="bi bi-box-fill"></i>
                                        <span class="text">Kho hàng</span>
                                    </a>
                                </li>
                                <li id="incomeSidebar">
                                    <a data-toggle="list" href="#doanh-thu">
                                        <i class="bi bi-pie-chart-fill"></i>
                                        <span class="text">Doanh thu</span>
                                    </a>
                                </li>
                                <li id="staffSidebar">
                                    <a data-toggle="list" href="#nhan-vien">
                                        <i class="bi bi-people-fill"></i>
                                        <span class="text">Nhân viên</span>
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
                                <button class="navbar-toggler d-lg-none" type="button" aria-controls="sidebar"
                                    aria-expanded="false" data-bs-toggle="collapse" data-bs-target=".sidecontainer"
                                    aria-label="Toggle navigation" id="toggleSidebar">
                                    <i class="bi bi-list"></i>
                                </button>
                                <ol class="breadcrumb m-0 p-0 bg-transparent">
                                    <li class="breadcrumb-item" id="HeaderBreadcrumbParentText"></li>
                                    <li class="breadcrumb-item active" aria-current="page" id="HeaderBreadcrumbText">
                                    </li>
                                </ol>
                            </nav>

                            <form class="d-flex" role="search">

                                <input class="form-control me-0" type="search" placeholder="Tìm kiếm"
                                    aria-label="Search" style="width: 300px;" />
                            </form>
                        </div>
                    </div>

                </nav>

                <div class="container main">
                    <div class="container one-page">
                        <div id="san-pham">
                            <div class="mainform">
                                <div class="header1">
                                    <h3>Sản phẩm</h3>
                                    <form action="add_product" method="GET">
                                        <button class="add">
                                            <i class="fa-solid fa-plus"></i>
                                            Thêm sản phẩm
                                        </button>
                                    </form>
                                </div>
                                <div class="inforItem">
                                    <div class="header1">
                                        <div class="search">
                                            <div class="input">
                                                <span class="iconSearch"><i
                                                        class="fa-solid fa-magnifying-glass fa-rotate-90"
                                                        style="color:white;"></i></span>
                                                <input id="search" class="inputSearch" type="text"
                                                    placeholder="Tìm kiếm sản phẩm trong danh sách">
                                            </div>
                                            <button class="buttonSearch" id="button_search">Search</button>
                                        </div>
                                        <div class="Count">
                                            <h5 style="color: white;">Tổng số sản phẩm: 900</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="bodyInfor">
                                    <table class="content-table">
                                        <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Số lượng</th>
                                                <th>Giá bán</th>
                                                <th>Đối tượng</th>
                                                <th>Danh mục</th>
                                                <th>Nhãn hàng</th>
                                            </tr>
                                        </thead>
                                        <tbody id="san_pham">
                                            <c:forEach var="item" items="${san_pham}">
                                                <tr>
                                                    <td><img src="${item.anh_san_pham[0]}" width="50px"
                                                            alt="">${item.ten_san_pham}</td>
                                                    <td>100</td>
                                                    <td>100.000 VNĐ</td>
                                                    <td>Nam</td>
                                                    <td>${item.danh_muc_san_pham}</td>
                                                    <td>${item.ten_nhan_hang}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div id="kho-hang">
                            <div class="mainform">
                                <div class="header1">
                                    <h3>Kho hàng</h3>
                                </div>
                                <div class="inforItem">
                                    <div class="header">
                                        <div class="search">
                                            <div class="input">
                                                <span class="iconSearch"><i
                                                        class="fa-solid fa-magnifying-glass fa-rotate-90"
                                                        style="color:white;"></i></span>
                                                <input class="inputSearch" type="text"
                                                    placeholder="Tìm kiếm sản phẩm trong danh sách">
                                            </div>
                                            <button class="buttonSearch">Search</button>
                                        </div>
                                        <div class="Count">
                                            <h5 style="color: white;">Tổng số sản phẩm: 900</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="bodyInfor">
                                    <table class="content-table">
                                        <thead>
                                            <tr>
                                                <th>Ảnh</th>
                                                <th>Tên sản phẩm</th>
                                                <th>Size</th>
                                                <th>Màu</th>
                                                <th>Sẵn hàng</th>
                                                <th>Đã bán</th>
                                                <th>Cập nhật lần cuối</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg"
                                                        width="50px" alt="">
                                                </td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>XL</td>
                                                <td>Đỏ</td>
                                                <td>100</td>
                                                <td>99</td>
                                                <td>22/04/2024</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div id="doanh-thu">
                        </div>
                        <div id="nhan-vien">
                            <div class="mainform">
                                <div class="header1">
                                    <h3>Nhân viên</h3>
                                </div>
                                <div class="inforItem">
                                    <div class="header">
                                        <div class="search">
                                            <div class="input">
                                                <span class="iconSearch"><i
                                                        class="fa-solid fa-magnifying-glass fa-rotate-90"
                                                        style="color:white;"></i></span>
                                                <input id='search_nhan_vien' class="inputSearch" type="text"
                                                    placeholder="Tìm kiếm nhân viên trong danh sách">
                                            </div>
                                            <button id='button_search_nhan_vien' class="buttonSearch">Search</button>
                                        </div>
                                        <div class="Count">
                                            <h5 style="color: white;">Tổng số nhân viên: 10</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="bodyInfor">
                                    <table class="content-table">
                                        <thead>
                                            <tr>
                                                <th>Ảnh đại diện</th>
                                                <th>Họ tên</th>
                                                <th>Giới tính</th>
                                                <th>Số điện thoại</th>
                                                <th>Chi tiết</th>
                                            </tr>
                                        </thead>
                                        <tbody id="nhan_vien">
                                            <c:forEach var='item' items='${nhan_vien}'>
                                                <tr>
                                                    <form action='thong_tin_nhan_vien' method='get'>
                                                        <td><img src="${item.anh_dai_dien}" width="50px" alt=""></td>
                                                        <td>${item.ho_ten}</td>
                                                        <td>
                                                            <c:if test="${item.gioi_tinh == true}">
                                                                Nam
                                                            </c:if>
                                                            <c:if test="${item.gioi_tinh != true}">
                                                                Nữ
                                                            </c:if>
                                                        </td>
                                                        <td>${item.so_dien_thoai}</td>
                                                        <input type="hidden" name='id' value="${item.id_nguoi_dung}">
                                                        <td><button class="buttonSearch">Chi tiết</button></td>
                                                    </form>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./chucuahang.js"></script>
        <script src="navigation.js"></script>
        </body>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

        </html>