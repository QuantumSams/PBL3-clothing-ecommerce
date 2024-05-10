<%@ page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="order.css">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Document</title>
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
                            <th>Sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                            <th></th>
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
                        <td><Button class = "btnXoa" onclick="deleteR(this)"><i class="fa-solid fa-trash"></i></Button></td>
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
                        <td><Button class = "btnXoa" onclick="deleteR(this)"><i class="fa-solid fa-trash"></i></Button></td>
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
                        <td><Button class = "btnXoa" onclick="deleteR(this)"><i class="fa-solid fa-trash"></i></Button></td>
                    </tr>
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
                <div class="User">
                    <h5>Họ tên người nhận</h5>
                    <h5>Nguyễn Văn A</h5>
                </div>
                <div class="User">
                    <h5>Số điện thoại giao hàng</h5>
                    <input class = "inf" type="text" value="0905 123 456" disabled >
                </div>
                <div class="User">
                    <h5>Địa chỉ giao hàng</h5>
                    <input  class = "inf" type="text" disabled  value = "31 Ba Đình, phường Thạch Trang, quận Hải Châu, Thành phố Đà Nẵng">
                </div>
            </div>
            <div class="note">
                <h4>Ghi chú đơn hàng</h4>
                <textarea name="" id="" placeholder="Nhập thông tin ghi chú tại đây" ></textarea>
            </div>
            <button class="chinhsua xacnhan">Xác nhận thanh toán</button>
        </div>
      
       </div>
      
    </div>
</body>
<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
<script>
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
    a.forEach((item)=> {sum += parseFloat(item.innerHTML)*1000});
    document.getElementById('tongtien').innerHTML = sum;
    thanhtien.innerHTML = sum - giamgia - phivanchuyen;
    const b = document.querySelectorAll('.btnXoa')
    b.forEach(element => {
            element.addEventListener('click',(e)=>{
            a = document.querySelectorAll('.priceItems');
            sum = 0;
            console.log("haha");
            a.forEach((item)=> {sum += parseFloat(item.innerHTML)*1000});
            document.getElementById('tongtien').innerHTML = sum;
            thanhtien.innerHTML = sum - giamgia - phivanchuyen;
        })   
    });
    
    
  </script> 
</html>