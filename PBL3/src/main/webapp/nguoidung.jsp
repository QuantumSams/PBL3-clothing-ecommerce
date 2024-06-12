<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
    <meta Name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="nguoidung.css">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div class="modal fade" id="huydonhang" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Bạn có muốn huỷ đơn hàng không
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
        <button type="button" class="btn btn-success xac_nhan" data-bs-dismiss="modal">Có</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="xoasanpham" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Bạn có muốn xoá sản phẩm không
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
        <button type="button" class="btn btn-success xac_nhan_xoa" data-bs-dismiss="modal">Có</button>
      </div>
    </div>
  </div>
</div>
<div class="card cardForm">
    <div class="form" style="display: flex;">
        <div class=" col-md-2 pt-0">
            <img src="386644391_1615327005662931_6147334074894597765_n.jpg" alt="" width="200">
            <div class="list-group list-group-flush account-settings-links">
                <a class="list-group-item list-group-item-action  active" data-toggle= "list" data-bs-target = "#submenu" data-bs-toggle="collapse" 
                href="#tai-khoan">Tài khoản</a>
                <div class="list-group list-group-flush account-settings-linkss collapse" id = "submenu" >
                    <a class="list-group-item list-group-item-action active" data-toggle="list"
                    href="#tai-khoan">Thông tin chung</a>
                    <a class="list-group-item list-group-item-action" data-toggle= "list"
                    href="#dia-chi-giao-hang">Địa chỉ giao hàng</a>
                    <a class="list-group-item list-group-item-action" data-toggle= "list"
                    href="#mat-khau">Mật khẩu</a>
                </div>
                <a id="gio_hang" class="list-group-item list-group-item-action" data-toggle="list"
                href="#gio-hang">Giỏ hàng</a>
                <a  id="lich_su" class="list-group-item list-group-item-action" data-toggle= "list"
                href="#lich-su">Lịch sử</a>
                
                </div>
            
        </div>
        <div class = "infor col-md-10 pt-0">
            <div class="tab-content">
                <div class = "tab-pane fade" id = "gio-hang">
                    <div id="list_gio_hang" class="mainform">
                        
                        <div class="thanhtoan">
                            <div class="giatien">
                                <h5>Tạm tính: </h5>
                                <h5 id = "sum"></h5>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="lich-su">
                    <div class="mainform">
                        <table class = "content-table">
                            <thead>
                                <tr>
                                    <th>Ngày đặt hàng</th>
                                    <th>Giá trị sản phẩm</th>
                                    <th>Số lượng sản phẩm</th>
                                    <th>Trạng thái đơn</th>
                                    <th>Đánh giá</th>
                                    <th>Xem chi tiết</th>
                                    <th>Hủy đơn</th>
                                </tr>
                            </thead>
                            <tbody id="san_pham">
                                    
                            </tbody>
                        </table>

                    </div>
                </div> 
                <div class="tab-pane fade  active show" id="tai-khoan">
                    <div class="mainform thongtin">
                        <h4>Thông tin chung</h4>
                        <div class="userinfor">
                            <div class="img inputClass">
                                <h6>Ảnh đại diện</h6>
                                <div class="cardImage card-body">
									<img id="img" src="${sessionScope.acc.anh_dai_dien}" alt="Card image" class="d-block ui-w-80">
									<input type="file" id="fileInput" name="file" />
								</div>
                            </div>
                            <div class="name inputClass">
                                <h6>Họ và tên</h6>
                                <input id="ho_ten_khach_hang"type="text" value="${sessionScope.acc.ho_ten}">
								<input id="id_khach_hang" type="hidden" value="${sessionScope.acc.id_nguoi_dung}">
                            </div>
                            <div class="birth inputClass">
                                <h6>Ngày sinh</h6>
                                <input id="ngay_sinh" type="date" value = "${sessionScope.acc.ngay_sinh}">
                                
                            </div>
                            <div class="gender ">
                                <h6>Giới tính</h6>
                                <div class="radio">
                                    <c:if test="${sessionScope.acc.gioi_tinh == true}">
  										<div class="form-check">
	                                        <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Nam
	                                        <label class="form-check-label" for="radio1"></label>
                                      	</div>
                                      	<div class="form-check">
	                                        <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Nữ
	                                        <label class="form-check-label" for="radio2"></label>
                                      	</div>
									</c:if>
									<c:if test="${sessionScope.acc.gioi_tinh == false}">
  										<div class="form-check">
	                                        <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" >Nam
	                                        <label class="form-check-label" for="radio1"></label>
                                      	</div>
                                      	<div class="form-check">
	                                        <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2" checked>Nữ
	                                        <label class="form-check-label" for="radio2"></label>
                                      	</div>
									</c:if>
                                      
                                </div>
                            </div>
                            <div class="phone inputClass">
                                <h6>Số điện thoại</h6>
                                <input id="so_dien_thoai" type="number" value="${sessionScope.acc.so_dien_thoai}" readonly>
                                
                            </div>
                            <div class="email inputClass">
                                <h6>Email</h6>
                                <input id="email" type="email" value="${sessionScope.acc.email}" name="email" readonly>
                                
                            </div>
                            <div class="buttonList">
                                <button id="cap_nhat_thong_tin" class = "buttonTT">Save</button>
                                <button class = "buttonCancel">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div> 
                <div class="tab-pane fade" id="dia-chi-giao-hang">
                    <div class="mainform">
                        <h4>Địa chỉ giao hàng</h4>
                        <div class="inputClass">
                            <h6>Tỉnh/ Thành phố</h6>
                            <input id="tinh" type="text" value="${sessionScope.acc.tinh}">
                            
                        </div>
                        <div class="inputClass">
                            <h6>Huyện / Quận</h6>
                            <input id="huyen" type="text" value="${sessionScope.acc.huyen}">
                            
                        </div>
                        <div class="inputClass">
                            <h6>Xã / Phường</h6>
                            <input id="xa" type="text" value="${sessionScope.acc.xa}">
                            
                        </div>
                        <div class="inputClass">
                            <h6>Địa chỉ cụ thể </h6>
                            <input id="cu_the" type="text" value="${sessionScope.acc.dia_chi_cu_the}">
                            
                        </div>
                        <div class="buttonList">
                            <button id="cap_nhat_thong_tin1" class = "buttonTT">Save</button>
                            <button class = "buttonCancel">Cancel</button>
                        </div>
                    </div>
                </div> 
                <div class="tab-pane fade" id="mat-khau">
                    <div class="mainform">
                        <h4>Đổi mật khẩu</h4>
                        <div class="inputClass">
                            <h6>Mật khẩu hiện tại</h6>
                            <input id="old_password"  type="password" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Mật khẩu mới</h6>
                            <input id="new_password"type="password" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Nhập lại mật khẩu mới</h6>
                            <input id="new_repassword" type="password" >
                        </div>
                        <div class="buttonList">
                            <button id = "doi_mat_khau"  class = "buttonTT">Save</button>
                            <button class = "buttonCancel">Cancel</button>
                        </div>
                    </div>
                </div> 
                </div> 
            </div>
        </div>
    </div>
</div>


</body>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script defer src="./nguoidung.js"></script>

</html>