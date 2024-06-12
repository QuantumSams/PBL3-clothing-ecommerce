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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>
<div class="card ">
    <div class="form" style="display: flex;">
        <div class=" col-md-2 pt-0">
            <img src="img/logoicqon.png" alt="" width="150px">
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
                                    <h5 style ="color: white;">Tổng số sản phẩm: ${so_san_pham}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
                                <thead>
                                    <tr>
                                    	<th>Ảnh sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá bán</th>
                                        <th>Đối tượng</th>
                                        <th>Danh mục</th>
                                        <th>Nhãn hàng</th>
                                        <th>Chi tiết</th>
                                        <th>Xóa</th>
                                    </tr>
                                </thead>
                                <tbody id="san_pham">
                                	<c:forEach var="item" items="${san_pham}">
										<tr>
											<td><img src="${item.anh_san_pham[0]}" width="50px"
												alt=""></td>
											<td>${item.ten_san_pham}</td>
											<td>${item.gia_tien}VNĐ</td>
											<td>Nam</td>
											<td>${item.danh_muc_san_pham}</td>
											<td>${item.ten_nhan_hang}</td>
											<form action='update_product' method='get'>
												<td><button class="buttonSearch">Chi tiết</button></td>
												 <input type="hidden" name='id_san_pham' value="${item.id_san_pham}">
											</form>
											<td><button class="buttonRemove"><input type="hidden" value="${item.id_san_pham}">Xóa</button></td>

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
                                        <input id="searchKhoHang" class = "inputSearch" type="text" placeholder="Tìm kiếm sản phẩm trong danh sách">
                                    </div>
                                    <button class = "buttonSearch">Search</button>
                                </div>
                                
                                    <h5 style ="color: white;"> Tổng số mục sản phẩm: ${so_muc_san_pham}</h5>
                                
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
                                <thead>
                                    <tr>
                                    	<th>Ảnh</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Size</th>
                                        <th>Màu</th>
                                        <th>Sẵn hàng</th>
                                        <th>Giá</th>
                                        <th>Cập nhật số lượng sản phẩm</th>
                                    </tr>
                                </thead>
                                <tbody class="Muc_sp">
                                	<c:forEach var="item" items="${muc_san_pham}">
										<tr class="muc_san_pham">
											<td><img
												src="${item.anh_chi_tiet}"
												width="50px" alt=""></td>
											<td>${item.ten_san_pham}</td>
											<td>${item.kich_thuoc_san_pham.ten_size}</td>
											<td>${item.mau_sac_san_pham.ten_mau}</td>
											<td><input class="so_luong_trong_kho" value="${item.so_luong_trong_kho}"></td>
											<td><input class="gia_tien_muc_san_pham" value="${item.gia_tien}"></td>
											<td><button class="cap_nhat_san_pham">
												<input value="${item.id_muc_san_pham}" type="hidden">
												Cập nhật</button></td>
										</tr>
									</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div> 
                <div class="tab-pane fade" id="doanh-thu">
			<div class="mainform">

						<c:forEach var="item" items="${cot_du_lieu}">
							<input type = "hidden" class="ten_doi_tuong" value="${item.doi_tuong_khach_hang }">
							<input type = "hidden" class="so_san_pham" value="${item.so_san_pham_ban }">
						</c:forEach>

						<div class="header2">
                                <button class = "doanh-thu btn1">Doanh thu</button>
                                <button class = "don-hang btn1">Đơn hàng</button>
                            </div>
                            <div class="bodyform active">
                                <div class="header3">
                                    <h3>Thống kê doanh thu</h3>
                                    <select name="" id="selectOpt">
                                        <option value="">Hôm nay</option>
                                        <option value="">Hôm qua</option>
                                    </select>
                                </div>
                                <div class="thongke">
                                    <div class="doanhThu card1">
                                        <h5>Doanh thu</h5>
                                        <h2>${doanh_thu.doanh_thu}</h2>
                                    </div>

                                    <div class="tongsodon card1">
                                        <h5>Tổng số đơn</h5>
                                        <h2>${doanh_thu.tong_so_don}</h2>
                                    </div>

                                    <div class="daBan card1">
                                        <h5>Tổng số sản phẩm đã bán</h5>
                                        <h2>${doanh_thu.san_pham_da_ban}</h2>

                                    </div>
                                </div>
                                <div class="thongkedoituong">
                                    <h5>Thống kê đối tượng mua hàng</h5>
                                    <canvas id="myChart" style="width:100%; max-width: 900px;"></canvas>
                                </div>
                                <div class="topbanchay">
                                    <table class = "content-table">
                                        <thead>
                                            <tr>
                                                <th>Ảnh</th>
                                                <th>Tên sản phẩm</th>
                                                <th>Đã bán</th>
                                                <th>Giá bán</th>
                                                <th>Lợi nhuận</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                                
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                              
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                            
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                           
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                            
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>
                                            </tr>
                                            <tr>
                                                <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt=""></td>
                                                <td>Tên sản phẩm 1</td>
                                                <td>1000</td>
                                                <td>15000</td>
                                                <td>5000</td>   
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class = "mainform2 fade">
                                <h3>Danh sách đơn hàng</h3>
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
                                            <h5 style ="color: white;">Tổng số sản phẩm: ${so_don_hang}</h5>
                                        </div>
                                    </div>
                                </div>
                                <table class = "content-table">
                                    <thead>
                                        <tr>
                                            <th>Mã đơn hàng</th>
                                            <th>Giá trị đơn hàng</th>
                                            <th>Nhân viên xác nhận</th>
                                            <th>Thời điểm đặt</th>
                                            <th>Thời điểm nhận</th>
                                            <th>Trạng thái</th>
                                            <th>Xem chi tiết</th>
                                        </tr>
                                    </thead>
								<tbody>

									<c:forEach var="item" items="${don_hang}">
										<tr>
											<th scope="row">${item.id_don_hang}</th>
											<td>
												<div class="d-flex justify-content-between">
													<span>${item.tong_tien}</span> <span><b>VND</b></span>
												</div>
											</td>
											<td>${item.ten_nhan_vien}</td>
											<td>${item.thoi_gian_dat}</td>
											<td>${item.thoi_gian_nhan}</td>
											<td>
												<button class="status status-waiting">
													<input type="hidden" value="${item.id_don_hang}">
													${item.trang_thai_don_hang}
												</button>
											</td>
											<td>
												<form action="xem_don_hang_chi_tiet" method="get">
													<input type="hidden" name="id_don_hang"
														value="${item.id_don_hang}">
													<button class="xem_chi_tiet">Xem chi tiết</button>
												</form>
											</td>
										</tr>
									</c:forEach>

									<tr>
										<td>1</td>
										<td>20.000 VNĐ</td>
										<td>Nguyễn Văn A</td>
										<td>15/10/2023</td>
										<td>-</td>
										<td><button type="button" class="btn btn-warning"
												disabled>Đang chờ xác nhận</button></td>
									</tr>
									<tr>
										<td>1</td>
										<td>20.000 VNĐ</td>
										<td>Nguyễn Văn A</td>
										<td>15/10/2023</td>
										<td>-</td>
										<td><button type="button" class="btn btn-success"
												disabled>Giao thành công</button></td>
									</tr>
									<tr>
										<td>1</td>
										<td>20.000 VNĐ</td>
										<td>Nguyễn Văn A</td>
										<td>15/10/2023</td>
										<td>-</td>
										<td><button type="button" class="btn btn-danger" disabled>Bị
												huỷ</button></td>
									</tr>
									<tr>
										<td>1</td>
										<td>20.000 VNĐ</td>
										<td>Nguyễn Văn A</td>
										<td>15/10/2023</td>
										<td>-</td>
										<td><button type="button" class="btn btn-primary"
												disabled>Đang giao hàng</button></td>
									</tr>
									<tr>
										<td>1</td>
										<td>20.000 VNĐ</td>
										<td>Nguyễn Văn A</td>
										<td>15/10/2023</td>
										<td>-</td>
										<td><button type="button" class="btn btn-warning"
												disabled>Đang chờ xác nhận</button></td>
									</tr>
								</tbody>
							</table>
    
                            </div>
                        </div>
                </div> 
                <div class="tab-pane fade" id="nhan-vien">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Nhân viên</h3>
                            <form action="tao_nhan_vien" method="GET">
	                            <button class = "add">
	                                <i class="fa-solid fa-plus"></i>
	                                Thêm nhân viên
	                            </button>
                            </form>
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
                                    <h5 style ="color: white;">Tổng số nhân viên: ${so_nhan_vien}</h5>
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
                                        <th>Xóa</th>
                                    </tr>
                                </thead>
                                <tbody id="nhan_vien">
                                	<c:forEach var='item' items='${nhan_vien}'>
										<tr>
											<td><img src="${item.anh_dai_dien}" width="50px" alt=""></td>
											<td>${item.ho_ten}</td>
											<td><c:if test="${item.gioi_tinh == true}">
										                Nam
										            </c:if> <c:if test="${item.gioi_tinh != true}">
										                Nữ
										            </c:if></td>
											<td>${item.so_dien_thoai}</td>
											<form action='thong_tin_nhan_vien' method='get'>
												<input type="hidden" name='id' value="${item.id_nguoi_dung}">
												<td><button class="buttonSearch">Chi tiết</button></td>
											</form>
											<td><button class="buttonRemoveNV"><input type="hidden" name='id' value="${item.id_nguoi_dung}">Xóa</button></td>
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
</body>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>