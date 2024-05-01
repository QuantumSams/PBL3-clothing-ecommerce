<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta Name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="chucuahang.css">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<div class="card ">
    <div class="form" style="display: flex;">
        <div class=" col-md-2 pt-0">
            <img src="386644391_1615327005662931_6147334074894597765_n.jpg" alt="" width="200">
            <p style = "margin-top: 20px;">Chức năng</p>
            <div class="list-group list-group-flush account-settings-links">
                <a class="list-group-item list-group-item-action active" data-toggle="list"
                href="#san-pham"><i class="fa-brands fa-product-hunt"></i>Sản phẩm</a>
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#kho-hang"><i class="fa-solid fa-box"></i>Kho hàng</a>
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#doanh-thu"><i class="fa-solid fa-money-check"></i>Doanh thu</a>
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#nhan-vien"><i class="fa-solid fa-user"></i>Nhân viên</a>
            </div>
        </div>
        <div class = "infor col-md-10 pt-0">
            <div class="tab-content">
                <div class = "tab-pane fade active show" id = "san-pham">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Sản phẩm</h3>
                        	<form action="add_product" method="GET">
	                            <button class = "add">
	                                <i class="fa-solid fa-plus"></i>
	                                Thêm sản phẩm
	                            </button>
                            </form>
                        </div>
                        <div class = "inforItem">
                            <div class="header1">
                                <div class="search">
                                    <div class="input">
                                        <span class="iconSearch"><i class="fa-solid fa-magnifying-glass fa-rotate-90" style="color:white;"></i></span>
                                        <input id="search" class = "inputSearch" type="text" placeholder="Tìm kiếm sản phẩm trong danh sách">
                                    </div>
                                    <button class="buttonSearch" id="button_search">Search</button>
                                </div>
                                <div class="Count">
                                    <h5 style ="color: white;">Tổng số sản phẩm: 900</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
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
                                        	<td><img src="${item.anh_san_pham[0]}" width="50px" alt="">${item.ten_san_pham}</td>
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
                <div class="tab-pane fade" id="kho-hang">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Kho hàng</h3>
                        </div>
                        <div class = "inforItem">
                            <div class="header">
                                <div class="search">
                                    <div class="input">
                                        <span class="iconSearch"><i class="fa-solid fa-magnifying-glass fa-rotate-90" style="color:white;"></i></span>
                                        <input class = "inputSearch" type="text" placeholder="Tìm kiếm sản phẩm trong danh sách">
                                    </div>
                                    <button class = "buttonSearch">Search</button>
                                </div>
                                <div class="Count">
                                    <h5 style ="color: white;">Tổng số sản phẩm: 900</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Sẵn hàng</th>
                                        <th>Đã bán</th>
                                        <th>Cập nhật lần cuối</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div> 
                <div class="tab-pane fade" id="doanh-thu">

                </div> 
                <div class="tab-pane fade" id="nhan-vien">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Nhân viên</h3>
                        </div>
                        <div class = "inforItem">
                            <div class="header">
                                <div class="search">
                                    <div class="input">
                                        <span class="iconSearch"><i class="fa-solid fa-magnifying-glass fa-rotate-90" style="color:white;"></i></span>
                                        <input id='search_nhan_vien' class = "inputSearch" type="text" placeholder="Tìm kiếm nhân viên trong danh sách">
                                    </div>
                                    <button id='button_search_nhan_vien' class = "buttonSearch">Search</button>
                                </div>
                                <div class="Count">
                                    <h5 style ="color: white;">Tổng số nhân viên: 10</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
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
	                                        <td><button class = "buttonSearch">Chi tiết</button></td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                      
                    </div>
                    <div class="card popup">
                        <div class="header1">
                            <div class="backForward">
                                <button><</button>
                                <div class="Name">
                                    <h6>Nhân viên</h6>
                                    <h5>Nguyễn Văn A</h5>
                                </div>
                            </div>
                            <div class="ModifyInfor" style = "transform: translateX(-10%);">
                                <button class="add"><i class="fa-solid fa-book"></i>Chỉnh sửa thông tin</button>
                            </div>
                        </div>
    
                        
                    </div>
                    </div> 
                </div>
            </div>
        </div>
    </div>


<script src="./chucuahang.js"></script>

</body>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>