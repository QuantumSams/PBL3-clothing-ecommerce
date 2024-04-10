<%@page import="jakarta.servlet.http.HttpSession"%>

<%@ page contentType="text/html; charset=UTF-8"  %>

<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="userInfor.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>Information</title>
</head>
<body>
    <div class="over">
        <div class="main">
            <div class="left">            
                <div class="name">
                    <a href="">
                        <i class="fa-solid fa-user"></i>
                    </a>
                    <h5>${sessionScope.acc.ho_ten }</h5>
                </div>
                <hr class="hrbar">
                <div class="side-bar">
               
				<img src="img\anh_nguoi_dung\aa.png" width = 200px/>
			<form method = "post" action="fileuploadservlet" enctype="multipart/form-data">
			<input id = "ajaxfile" type="file" name="file"/> 
			<button type = "submit" onclick = "uploadFile()">Upload</button>
			
			
			</form>
					
                </div>
            </div>
            <hr class= "center">
            <div class="right">
                <div class="setting">
                    <h5>
                        Chỉnh sửa thông tin
                    </h5>
                    <button class = "modify btn btn-success" id = "modify" onclick = "modifyInforDisable()" >Chỉnh sửa</button>
                </div>
                <hr> 
                <form action="modifyInfor" method = "post">
                 <div class="mainInfor">
                    <div class="rightleft">
                    
                    	<h5>Họ và tên:</h5>
                    	<input class = "infor" name = "fullName" type = "text" required="required" value = "${sessionScope.acc.ho_ten}" disabled="disabled"> </input>
						<h5>ID tài khoản: </h5>
           				 <input class = "infor" name = "id" type = "text" value = "${sessionScope.acc.id_nguoi_dung }" disabled="disabled">
                        <%-- <c:if test = "${sessionScope.acc.gioi_tinh == 1}">
    					<h5>Giới tính: Nam</h5>
   						 </c:if>
    					<c:if test = "${sessionScope.acc.gioi_tinh == 0}">
    					<h5>Giới tính: Nữ</h5>
    					</c:if>
                        <h5>Ngày sinh: </h5> --%>
                        <input class = "infor" name = "birth" type = "date" value = "${sessionScope.acc.ngay_sinh}" disabled="disabled"> </input>
                        <h5> Địa chỉ: </h5>
                        <input class = "infor" name = "address" type = "text" value = "${sessionScope.acc.dia_chi }" disabled="disabled"> </input>
                    </div>
                     <div class="rightright">
                        <h5>Email: </h5>
                        <input class = "infor" name = "email" type = "text" required="required" value = "${sessionScope.acc.email }" disabled="disabled"> </input>
                        <h5>Số điện thoại:</h5>
                        <input class = "infor" name = "phoneNumber" type = "text" required="required" value = "${sessionScope.acc.so_dien_thoai }" disabled="disabled"> </input>
                        
                    </div>
               	 </div>
               	 <div class = "buttonS">
               	  <button class = "btn btn-success" id = "target" type = "submit" disabled="disabled" >Lưu thay đổi</button>   
               	 </div>
                </form>
                <a class = "back" href = "index.jsp"><button class = "btn btn-success" >Quay về trang chủ </button></a>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
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
</script>
</html>