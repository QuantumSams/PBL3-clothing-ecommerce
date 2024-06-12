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
   
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                        	<th>Ảnh sản phẩm</th>
                            <th>Sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                           
                        </tr>
                    </thead>
                   <tbody id="list_san_pham">
                   <c:forEach var="item" items="${chi_tiet_don_hang}">
                    	<tr>
                    		<td><img src="${item.anh}" width="50px"
												alt=""></td>
                    		<td>
	                            <div class="name">
	                                <h5>${item.ten_san_pham}</h5>
	                            </div>
	                            <div class="color">
	                                    <h5>${item.ten_mau} / ${item.ten_size}</h5>
	                            </div>
	                        </td>
	                        <td class = "priceItems">${item.so_luong}</td>
	                        <td class = "priceItems">${item.gia}</td>
	                        
                    	</tr>          	  
					</c:forEach>
                   </tbody>
                    
                </table>
            </div> 
            <input id = "diemdanhgia" value = "${danh_gia.diem_danh_gia}" type = "hidden">
            <input id = "diemsao" value = "${danh_gia.diem_danh_gia}" type = "hidden">
            <div class="price">
                <h3>Đánh giá đơn hàng</h3>
                <div class="dform">
                    <h5>Đánh giá</h5>
                    <div class="star">
                    <button class = "btnStar" value = "1"><i class="fa-solid fa-star" style="color: #FFD43B;"></i></button>
                    <button class = "btnStar" value = "2"><i class="fa-solid fa-star" style="color: #FFD43B;"></i></button>
                    <button class = "btnStar" value = "3"><i class="fa-solid fa-star" style="color: #FFD43B;"></i></button>
                    <button class = "btnStar" value = "4"><i class="fa-solid fa-star" style="color: #FFD43B;"></i></button>
                    <button class = "btnStar" value = "5"><i class="fa-solid fa-star" style="color: #FFD43B;"></i></button>
                    </div>
                </div>
                <div class="dform" style = "margin-top: 20px">
                    <h5>Bình luận</h5>
                    <div class="textarea">
                        <textarea name="" id="cmt" >${danh_gia.binh_luan}
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
                    <h5>${don_hang.ten_khach_hang}</h5>
                </div>
                <div class="User">
                    <h5>Số điện thoại giao hàng</h5>
                    <h5>${don_hang.so_dien_thoai}</h5>
                </div>
                <div class="User">
                    <h5>Địa chỉ giao hàng</h5>
                    <h5>${don_hang.dia_chi}</h5>
                </div>
            </div>
            <div class="note">
                <h4>Thông tin đơn hàng</h4>
                <div class="User">
                    <h5>Đặt vào lúc</h5>
                    <h5>${don_hang.thoi_gian_dat}</h5>
                </div>
                <div class="User">
                    <h5>Nhận vào lúc</h5>
                    <h5>${don_hang.thoi_gian_nhan}</h5>
                </div>
                <div class="User">
                    <h5>Trạng thái</h5>
                    <input id="id_don_hang" value="${don_hang.id_don_hang}" type="hidden">
                    <h5><button type="button" class="btn trangthai">${don_hang.trang_thai_don_hang }</button></h5>
                </div>
            </div>
            <div class="note">
                <h4>Ghi chú</h4>
                <h5 style = "display: flex; align-items: center; justify-content: center; margin-top: 5%;">${don_hang.ghi_chu}</h5>
            </div>
            <div class = "xacnhan">
            	<button class = "btnXacnhan" disabled style = "width: 100%; background-color: orange; color: white; height: 50px; " >Xác nhận đánh giá</button>
            </div>;
        </div>
      
       </div>
      
    </div>
</body>
<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
<script>
let value = 0;
let star = document.querySelectorAll('.btnStar');

if(document.querySelector('#diemdanhgia').value == -1){
	star.forEach(item=>{
		item.addEventListener('click', e=>{
			value = item.value;
			if(item.childNodes[0].classList.contains('fa-2xl')){
				for(let i = item.value - 1; i<5; ++i){
					if(star[i].childNodes[0].classList.contains('fa-2xl')){
						star[i].childNodes[0].classList.remove('fa-2xl')
					}
				}
			}
			for(let i = 0; i<item.value; ++i){
				star[i].childNodes[0].classList.add('fa-2xl');
			}
		}) 
	})
	document.querySelector('.btnXacnhan').disabled = false;
} 
else{
	
	let sosao = document.querySelector('#diemsao').value;
	for(let i = 0; i<sosao; ++i){
		star[i].childNodes[0].classList.add('fa-2xl');
	}
	document.querySelector('#cmt').disabled = true;
}
let a = document.querySelector('.trangthai');
if(a.textContent == "Đã nhận được đơn hàng"){
	a.classList.add('btn-success');
}
else if(a.textContent == "Đang vận chuyển"){
	a.classList.add('btn-primary');
}
else if(a.textContent == "Đợi xác nhận đơn hàng"){
	a.classList.add('btn-warning');
}
else{
	a.classList.add('btn-danger');
}



document.querySelector('.btnXacnhan').addEventListener('click', e=>{
	alert('ahha');
	let id = document.querySelector('#id_don_hang').value;
	let cmt = document.querySelector('#cmt').value;
	
	$.ajax({
	      url: "luu_danh_gia", // URL of your Servlet
	      type: "POST",
	      dataType: 'json',
	      data: {
	    	  id_don_hang: id,
	    	  so_diem_danh_gia: value,
	    	  binh_luan: cmt
	      }
	      /* success: function(data) {
			alert("Thêm sản phẩm thành công!");
	      },
	      error: function(data) {
				alert("Thêm sản phẩm thất bại!");
			}  */
 });
	
})
    
  </script> 
</html>	