<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="order.css">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div class="payment">
       <div class="thanhtoan">
            <h2>Thanh toán đơn hàng</h2>
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
                            <th></th>
                        </tr>
                    </thead>
                   <tbody id="list_san_pham">
                   <input class="id_gio_hang" type="hidden" value="${gio_hang}">
                   <c:forEach var="item" items="${chi_tiet_don_hang}">
                    	<tr>
                    		<input class="so_luong" value="${item.so_luong}" type="hidden">
                    		<input class="id_muc" value="${item.id_muc_san_pham}" type="hidden">
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
	                        <td><Button class = "btnXoa" onclick="deleteR(this)"><i class="fa-solid fa-trash"></i></Button></td>
                    	</tr>          	  
					</c:forEach>
                   </tbody>
                </table>
            </div> 
            <div class="price">
                <h3>Thành tiền</h3>
                <div class="User">
                    <h5>Tổng tiền hàng</h5>
                    <h5 id = "tongtien" ></h5>
                </div>
                <div class="User">
                    <h5>Phí vận chuyển</h5>
                    <h5 id = "phivanchuyen">0</h5>
                </div>
                <div class="User">
                    <h5>Giảm giá</h5>
                    <h5 id = "giamgia">0</h5>
                </div>
                <div class="User">
                    <h5>Thành tiền</h5>
                    <h5 id = "thanhtien"></h5>
            </div>  
        </div>
        </div>
        <div class="left">
            <div class="userinfor">
                <div class="infor">
                    <h4>Thông tin người nhận</h4>
                    <button class = "chinhsua">Chỉnh sửa</button>
                </div>
                <div  class="User">
                	<input type="hidden" id="id_nguoi_dung" value="${acc.id_nguoi_dung}" />
                    <h5>Họ tên người nhận</h5>
                    <h5>${acc.ho_ten}</h5>
                </div>
                <div class="User">
                    <h5>Số điện thoại giao hàng</h5>
                    <input  id="so_dien_thoai" class = "inf" type="text" value="${acc.so_dien_thoai}" disabled >
                </div>
                <div class="User">
                    <h5>Địa chỉ giao hàng</h5>
                    <input  id="dia_chi" class = "inf" type="text" disabled  value = "${acc.tinh}, ${acc.huyen}, ${acc.xa}, ${acc.dia_chi_cu_the} ">
                </div>
            </div>
            <div class="note">
                <h4>Ghi chú đơn hàng</h4>
                <textarea name="" id="ghi_chu" placeholder="Nhập thông tin ghi chú tại đây" ></textarea>
            </div>
            <button id="add_order" class="chinhsua xacnhan">Xác nhận thanh toán</button>
        </div>
      
       </div>
      
    </div>
</body>

<script>

$(document).ready(function(){
	
	let sanPhamValues = [];
	let soLuongValues = [];
	let list = document.querySelectorAll('.id_muc');
	  list.forEach(item => {
		  sanPhamValues.push(item.value);
	})
	let list1 = document.querySelectorAll('.so_luong');
	  list1.forEach(item => {
		  soLuongValues.push(item.value);
	})
	 	
	
	 $("#add_order").click(function(){
		  
			$.ajax({
			      url: "create_order", // URL of your Servlet
			      type: "POST",
			      dataType: 'json',
			      data: {
			    	  id_khach_hang:  	$("#id_nguoi_dung").val(),
			    	  so_dien_thoai: 	$("#so_dien_thoai").val(),
			    	  dia_chi: 			$("#dia_chi").val(),
			    	  so_luong:			JSON.stringify(soLuongValues),
			    	  muc_san_pham: 	JSON.stringify(sanPhamValues),
			    	  ghi_chu: 			$("#ghi_chu").val(),
			    	  tong_tien: 		$("#thanhtien").text(),
			    	  gio_hang:			$(".id_gio_hang").val()
			      },
			
			      success: function(data) {
					alert(data);
					window.history.back();
			      },
			      error: function(data) {
						alert(data);
					}
		   });
	});
});

    function deleteR(button) {
      var row = button.parentNode.parentNode;
      var table = document.getElementById('table');
      table.deleteRow(row.rowIndex);
    }
    let giamgia = document.getElementById("giamgia").innerHTML;
    let phivanchuyen = document.getElementById("phivanchuyen").innerHTML;
    let thanhtien = document.getElementById('thanhtien');
    giamgia = giamgia.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
    document.querySelector('.chinhsua').addEventListener('click', (e)=>{
            var infor = document.querySelectorAll('.inf');
            infor.forEach(item =>{
                if(item.disabled)
                    item.disabled = false;
                else
                    item.disabled = true;
            })
        });

    let a = document.querySelectorAll('.priceItems');
    let sum = 0;
    a.forEach((item)=> {sum += parseFloat(item.innerHTML)});
    document.getElementById('tongtien').innerHTML = sum;
    thanhtien.innerHTML = sum - giamgia - phivanchuyen;
    const b = document.querySelectorAll('.btnXoa')
    b.forEach(element => {
            element.addEventListener('click',(e)=>{
            a = document.querySelectorAll('.priceItems');
            sum = 0;
            console.log("haha");
            a.forEach((item)=> {sum += parseFloat(item.innerHTML)});
            document.getElementById('tongtien').innerHTML = sum;
            thanhtien.innerHTML = sum - giamgia - phivanchuyen;
        })   
    });
    
    
  </script> 
</html>