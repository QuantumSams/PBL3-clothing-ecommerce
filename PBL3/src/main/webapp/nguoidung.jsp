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
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#gio-hang">Giỏ hàng</a>
                <a class="list-group-item list-group-item-action" data-toggle= "list"
                href="#lich-su">Lịch sử</a>
                
                </div>
            
        </div>
        <div class = "infor col-md-10 pt-0">
            <div class="tab-content">
                <div class = "tab-pane fade" id = "gio-hang">
                    <div class="mainform">
                        <div class="card ">
                            <div class="item-cart">
                                <div class="img-infor">
                                    <img src="goods_69_464605.png" alt="" width="100px">
                                    <div class="inforItems">
                                        <div class="name">
                                            <h5>Áo sơ mi bỏ túi chống nắng UV (3D Cut)</h5>
                                            <h6>Xanh biển ngà / S</h6>
                                            <button class = "btnXoa">Xoá</button>
                                        </div>
                                        
                                    </div>
                                </div>
                                
                                <div class="price-amount">
                                    <h6 class = "gia">50000 VNĐ</h6>
                                    <select name="" id="" class = "optionS">
                                        <option value="1">1 Chiếc</option>
                                        <option value="2">2 Chiếc</option>
                                        <option value="3">3 Chiếc</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="card ">
                            <div class="item-cart">
                                <div class="img-infor">
                                    <img src="goods_69_464605.png" alt="" width="100px">
                                    <div class="inforItems">
                                        <div class="name">
                                            <h5>Áo sơ mi bỏ túi chống nắng UV (3D Cut)</h5>
                                            <h6>Xanh biển ngà / S</h6>
                                            <button class = "btnXoa">Xoá</button>
                                        </div>
                                        
                                    </div>
                                </div>
                                
                                <div class="price-amount">
                                    <h6 class = "gia">50000 VNĐ</h6>
                                    <select name="" id="" class = "optionS">
                                        <option value="1">1 Chiếc</option>
                                        <option value="2">2 Chiếc</option>
                                        <option value="3">3 Chiếc</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="card ">
                            <div class="item-cart">
                                <div class="img-infor">
                                    <img src="goods_69_464605.png" alt="" width="100px">
                                    <div class="inforItems">
                                        <div class="name">
                                            <h5>Áo sơ mi bỏ túi chống nắng UV (3D Cut)</h5>
                                            <h6>Xanh biển ngà / S</h6>
                                            <button class = "btnXoa">Xoá</button>
                                        </div>
                                        
                                    </div>
                                </div>
                                
                                <div class="price-amount">
                                    <h6 class = "gia">50000 VNĐ</h6>
                                    <select name="" id="" class = "optionS">
                                        <option value="1">1 Chiếc</option>
                                        <option value="2">2 Chiếc</option>
                                        <option value="3">3 Chiếc</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="thanhtoan">
                            <div class="giatien">
                                <h5>Tạm tính: </h5>
                                <h5 id = "sum"></h5>
                            </div>
                            <Button class = "buttonTT">Thanh toán</Button>
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
                                    
                                </tr>
                            </thead>
                            <tbody id="san_pham">
                                    <tr>
                                        <td><a href="lishsudon.jsp">07/05/2024</a></td>
                                        <td>180.000 VNĐ</td>
                                        <td>10</td>
                                        <td><button type="button" class="btn btn-warning">Chờ xác nhận</button></td>
                                        <td>N/A</td>
                                    </tr>
                                    <tr>
                                        <td>08/05/2024</td>
                                        <td>200.000 VNĐ</td>
                                        <td>4</td>
                                        <td><button type="button" class="btn btn-success">Thành công</button></td>
                                        <td>N/A</td>
                                    </tr>
                                    <tr>
                                        <td>09/05/2024</td>
                                        <td>230.000 VNĐ</td>
                                        <td>4</td>
                                        <td><button type="button" class="btn btn-primary">Chờ nhận hàng</button></td>
                                        <td>N/A</td>
                                    </tr>
                                    <tr>
                                        <td>10/05/2024</td>
                                        <td>250.000 VNĐ</td>
                                        <td>1</td>
                                        <td><button type="button" class="btn btn-danger">Bị huỷ</button></td>
                                        <td>N/A</td>
                                    </tr>
                                    <tr>
                                        <td>11/05/2024</td>
                                        <td>100.000 VNĐ</td>
                                        <td>5</td>
                                        <td><button type="button" class="btn btn-warning">Chờ xác nhận</button></td>
                                        <td>N/A</td>
                                    </tr>
                                
                            </tbody>
                        </table>

                    </div>
                </div> 
                <div class="tab-pane fade  active show" id="tai-khoan">
                    <div class="mainform">
                        <h4>Thông tin chung</h4>
                        <div class="userinfor">
                            <div class="img inputClass">
                                <h6>Ảnh đại diện</h6>
                            </div>
                            <div class="name inputClass">
                                <h6>Họ và tên</h6>
                                <input type="text" value="Nguyễn Văn A">

                            </div>
                            <div class="birth inputClass">
                                <h6>Ngày sinh</h6>
                                <input type="date" >
                                
                            </div>
                            <div class="gender ">
                                <h6>Giới tính</h6>
                                <div class="radio">
                                    <div class="form-check">
                                        <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Nam
                                        <label class="form-check-label" for="radio1"></label>
                                      </div>
                                      <div class="form-check">
                                        <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Nữ
                                        <label class="form-check-label" for="radio2"></label>
                                      </div>
                                      
                                </div>
                            </div>
                            <div class="phone inputClass">
                                <h6>Số điện thoại</h6>
                                <input type="number" >
                                
                            </div>
                            <div class="email inputClass">
                                <h6>Email</h6>
                                <input type="number" >
                                
                            </div>
                            <div class="buttonList">
                                <button class = "buttonTT">Save</button>
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
                            <input type="text" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Huyện / Quận</h6>
                            <input type="text" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Xã / Phường</h6>
                            <input type="text" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Địa chỉ cụ thể </h6>
                            <input type="text" >
                            
                        </div>
                        <div class="buttonList">
                            <button class = "buttonTT">Save</button>
                            <button class = "buttonCancel">Cancel</button>
                        </div>
                    </div>
                </div> 
                <div class="tab-pane fade" id="mat-khau">
                    <div class="mainform">
                        <h4>Đổi mật khẩu</h4>
                        <div class="inputClass">
                            <h6>Mật khẩu hiện tại</h6>
                            <input type="password" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Mật khẩu mới</h6>
                            <input type="password" >
                            
                        </div>
                        <div class="inputClass">
                            <h6>Nhập lại mật khẩu mới</h6>
                            <input type="password" >
                        </div>
                        <div class="buttonList">
                            <button class = "buttonTT">Save</button>
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
<script>
    tien();
    var btnXoa = document.querySelectorAll('.btnXoa');
    btnXoa.forEach(element => {
        element.addEventListener('click', (e)=>{
            element.parentElement.parentElement.parentElement.parentElement.parentElement.remove();
            tien();
        })
    });

    function tien(){
        let a = document.querySelectorAll('.gia');
        let sum = 0; 
        a.forEach(item => {
        sum += parseFloat(item.innerHTML.split(' ',1));
    })
        document.querySelector('#sum').innerHTML = sum+' VNĐ'
    }
    

</script>
</html>