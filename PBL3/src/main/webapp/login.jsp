<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TGH</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div class="header">
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
                <a href="index.jsp"><img src="img/logoicqon.png" width = 100; alt=""></a>
            </div>
        </nav>
    </div>
    <hr>
    <div class="footer">
        <div class="container" id = "container">
            <div class="form- sign-up">
            <div class = "dangky">
            <h1>Tạo tài khoản</h1>
                    <span>Email hoặc số điện thoại</span>
                    <input id="email" type ="email"  placeholder="Email" name = "email" required>
                    <input id="fullname" type="text" placeholder="Họ và tên" name = "fullname" required>
                    <input id="phoneNumber" type="number" placeholder="Phone Number" name = "phoneNumber" required>
                    <input id="passWord" type="password" placeholder="Password" name = "password" required>
                    <input id="repassword" type="password" placeholder="Repeat Password" name = "repassword" required>
                    <button id="dang_ky" type = "submit">Đăng ký</button> 
                    <p id="message2" style = "color: green"></p>
            </div>
            		
            </div>
            <div class="form- sign-in">
                <form action="login" method = "post">
                    <h1>Đăng nhập</h1>
                    <input type="text" placeholder="Email" name = "username" required >
                    <input type="password" placeholder="Password" name = "password" required>
                    <a href="">Quên mật khẩu? </a>
                    <button type = "submit">Đăng nhập</button>
  					<p style = "color: red"></p>
                </form>    
            </div>
            <div class="container-toggle">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Chào mừng</h1>
                        <p>Điền thông tin cá nhân để đăng ký</p>
                        <button class="hidden" id = "login">
                            Đăng nhập
                        </button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Chào mừng trở lại</h1>
                        <p>Điền thông tin cá nhân đăng nhập</p>
                        <button class="hidden" id = "register">
                            Đăng ký
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        const registerBtn = document.getElementById('register');
        const container = document.getElementById('container');
        const loginBtn = document.getElementById('login');
        registerBtn.addEventListener('click', ()=>{
            container.classList.add("active");
        });
        loginBtn.addEventListener('click', ()=>{
            container.classList.remove("active");
        });
        
        
        $(document).ready(function(){
       	 	$("#dang_ky").click(function(){
       			$.ajax({
       	      		url: "sign_up", // URL of your Servlet
       	      		type: "POST",
       	      		dataType: 'json',
       	      		data: {
       					email: 			$("#email").val(),
       					passWord: 		$("#passWord").val(),
       					fullname: 		$("#fullname").val(),
       					phoneNumber: 	$("#phoneNumber").val(),
       					repassword: 	$("#repassword").val(),
       		  		},
       	      		success: function(data) {
       	      			$("#message2").html(data);
       	      		}
       	   		});
       		});
       });
        
    </script>
</body>
</html>