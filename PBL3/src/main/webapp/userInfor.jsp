<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="userInfor.css">
    <title>Document</title>
</head>
<body>
    <div class="container light-style flex-grow-1 container-p-y">
        <div class="header font-weight-bold py-3 mb-4">
            <h3>
                Chỉnh sửa thông tin người dùng
            </h3>
        </div>

        <form action="modify_Infor" method="post" enctype="multipart/form-data">

        <div class="card overflow-hidden">
            <div class="form" style="display: flex;">
                <div class="sidebar col-md-3 pt-0">
                    <div class="list-group list-group-flush account-settings-links">
                        <a class="list-group-item list-group-item-action active" data-toggle="list"
                        href="#account-general">General</a>
                        <a class="list-group-item list-group-item-action" data-toggle="list"
                        href="#account-change-password">Change password</a>
                    </div>
                </div>
                
                <div class = "infor col-md-9 pt-0">
                    <div class="tab-content">
                        <div class = "tab-pane fade active show" id = "account-general">
                            <div class="cardImage card-body">
 
                                <img id="img" src="${sessionScope.acc.anh_dai_dien}" alt="Card image" class = "d-block ui-w-80">
                            </div>
                            <div class="mainInfor card-body">
                            	
                            	<input type="file"  id="fileInput" name="file"/>
                            
                                <div class="name form">
                                    <label for="" class="form-label">Tên</label>
                                    <input type="text" class="form-control"  value = "${sessionScope.acc.ho_ten}" name="name">
                                    <input type="text" class="form-control"  value = "${sessionScope.acc.id_nguoi_dung}" name="id" style = "display: none">
                                </div>
                               <div class="phoneNum form">
                                    <label for="" class="form-label">Số điện thoại</label>
                                    <input type="tel" class="form-control"  value = "${sessionScope.acc.so_dien_thoai}" name="phone">
                               </div>
                               <div class="email form">
                                    <label for="" class="form-label">Email</label>
                                    <input type="email" class="form-control"  value="${sessionScope.acc.email}" name="email">
                                </div>
                                <div class="address form">
                                    <label for="" class="form-label">Địa chỉ</label>
                                    <input type="text" class="form-control"  value = "${sessionScope.acc.dia_chi}" name="address">
                                </div>
                                <div class="Gender form">
                                    <label for="" class="form-label">Giới tính</label>
                                    
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
                                    
                                    <div class="form-check">
                                        <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Nam
                                        <label class="form-check-label" for="radio1"></label>
                                      </div>
                                      <div class="form-check">
                                        <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Nữ
                                        <label class="form-check-label" for="radio2"></label>
                                      </div>
                                </div>
                                <div class="birth form">
                                    <label for="" class="form-label">Ngày sinh</label>
                                    <input type="date" class="form-control"  value = "${sessionScope.acc.ngay_sinh}" name="birth">
                                </div>
                                
                            </div>
                        </div>
                        <div class="tab-pane fade" id="account-change-password">
                            <div class="card-body pb-2">
                                <div class="form-group">
                                    <label class="form-label">Mật khẩu hiện tại</label>
                                    <input id="old_password" type="password" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Mật khẩu mới</label>
                                    <input id="new_password" type="password" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Nhập lại mật khẩu mới</label>
                                    <input id="new_repassword" type="password" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             
        </div> 
        
        <div class="text-right mt-3">

        	<input value = "Save" type = "submit"/>

         	<button type="button" class="btn btn-default" onclick="history.back()">Cancel</button>
        </div>

       </form>
	    <input type="button" id="doi_mat_khau" value='Thay đổi mật khẩu'/> 
                        
    </div>
</body>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript"></script>

<script type="text/javascript">

	const fileInput = document.getElementById('fileInput');
	const imgElement = document.getElementById('img');

	fileInput.addEventListener('change', function(event) {
  		const file = event.target.files[0];

  		if (file) {
    		const reader = new FileReader();

    		reader.onload = function(event) {
      		imgElement.src = event.target.result;
    		};

    		reader.readAsDataURL(file);
  		}
	}); 

	
	
	$(document).ready(function(){
		 $("#doi_mat_khau").click(function(){
				$.ajax({
				      url: "update_password", // URL of your Servlet
				      type: "POST",
				      dataType: 'json',
				      data: {
				    	  	old_password: $("#old_password").val(),
				  			new_password: $("#new_password").val(),
				  			new_repassword: $("#new_repassword").val()
					  },
				      success: function(data) {
					    	alert(data);
				      }
			   });
		});
	});

  function modifyInforDisable() {
	var inputElements = document.querySelectorAll(".infor");
    inputElements.forEach(function(inputElement) {
      inputElement.disabled = !inputElement.disabled;
    });
  }
  document.getElementById("modify").addEventListener("click", function () {
    document.getElementById("target").disabled = !document.getElementById("target").disabled; // Vô hiệu hóa nút đích
  }); 
  
  async function uploadFile(){
	 let formData = new FormData();
	 formData.append("file",ajaxfile.file[0]);
	 await fetch('fileuploadservlet',{
		 method: "POST",
		 body: formData
	 });
	 alert('The file upload thanh cong');
  }
  console.log($sessionScope.acc);
  
</script>
</html>