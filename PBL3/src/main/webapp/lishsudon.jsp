<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="lishsudon.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Document</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="payment">
       <div class="thanhtoan">
            <h2>Lịch sử đơn hàng</h2>
       </div>
       <div class="maininfor">
        <div class="right">
            <div class="listProduct">
                <h3>Danh sách sản phẩm</h3>
                <table id = "table">
                    <thead>
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                           
                        </tr>
                    </thead>
                   <tbody>
                    <tr>
                        <td>
                            <div class="name">
                                <h5>Áo sơ mi bỏ túi chống nắng UV  (3D cut)</h5>
                            </div>
                            <div class="color">
                                    <h5>Nâu/S</h5>
                            </div>
                        </td>
                        <td>1</td>
                        <td class = "priceItems">100.000</td>
                        
                    </tr>
                    <tr>
                        <td>
                            <div class="name">
                                <h5>Áo sơ mi bỏ túi chống nắng UV  (3D cut)</h5>
                            </div>
                            <div class="color">
                                    <h5>Nâu/S</h5>
                            </div>
                        </td>
                        <td>2</td>
                        <td class = "priceItems" >100.000</td>
                        
                    </tr>
                    <tr>
                        <td>
                            <div class="name">
                                <h5>Áo sơ mi bỏ túi chống nắng UV  (3D cut)</h5>
                            </div>
                            <div class="color">
                                    <h5>Nâu/S</h5>
                            </div>
                        </td>
                        <td>3</td>
                        <td class = "priceItems" >100.001</td>
                        
                    </tr>
                   </tbody>
                    
                </table>
            </div> 
            <div class="price">
                <h3>Đánh giá đơn hàng</h3>
                <div class="dform">
                    <h5>Đánh giá</h5>
                    <div class="star">
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                    </div>
                </div>
                <div class="dform">
                    <h5>Bình luận</h5>
                    <div class="textarea">
                        <textarea name="" id="" >Bình luận sẽ xuất hiện ở đây
                        </textarea>
                    </div>
                </div>
        </div>
        </div>
        <div class="left">
            <div class="userinfor">
                <div class="infor">
                    <h4>Thông tin người nhận</h4>
                   
                </div>
                <div class="User">
                    <h5>Họ tên người nhận</h5>
                    <h5>Nguyễn Văn A</h5>
                </div>
                <div class="User">
                    <h5>Số điện thoại giao hàng</h5>
                    <h5>0905 123 456</h5>
                </div>
                <div class="User">
                    <h5>Địa chỉ giao hàng</h5>
                    <h5>31 Ba Đình, phường Thạch Trang, quận Hải Châu, Thành phố Đà Nẵng</h5>
                </div>
            </div>
            <div class="note">
                <h4>Thông tin đơn hàng</h4>
                <div class="User">
                    <h5>Số lượng</h5>
                    <h5>3</h5>
                </div>
                <div class="User">
                    <h5>Đặt vào lúc</h5>
                    <h5>07/05/2004</h5>
                </div>
                <div class="User">
                    <h5>Nhận vào lúc</h5>
                    <h5>-</h5>
                </div>
                <div class="User">
                    <h5>Nhân viên xác nhận lúc</h5>
                    <h5>-</h5>
                </div>
                <div class="User">
                    <h5>Trạng thái</h5>
                    <h5><button type="button" class="btn btn-success">Thành công</button></h5>
                </div>
            </div>
            <div class="note">
                <h4>Ghi chú đơn hàng</h4>
                <h5 style = "display: flex; align-items: center; justify-content: center; margin-top: 5%;">Chỉ giao vào giờ hành chính</h5>
            </div>
            <button class="chinhsua xacnhan huy">Xác nhận thanh toán</button>
        </div>
      
       </div>
      
    </div>
</body>
<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
<script>
    
    
    
  </script> 
</html>