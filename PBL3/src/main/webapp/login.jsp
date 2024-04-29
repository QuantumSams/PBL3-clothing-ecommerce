<%@ page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TGH</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
                <form action="sign_up" method = "post">
                    <h1>Tạo tài khoản</h1>
                    <span>Email hoặc số điện thoại</span>
                    <input type ="email"  placeholder="Email" name = "email" required>
                    <input type="text" placeholder="Họ và tên" name = "fullname" required>
                    <input type="number" placeholder="Phone Number" name = "phoneNumber" required>
                    <input type="password" placeholder="Password" name = "password" required>
                    <input type="password" placeholder="Repeat Password" name = "repassword" required>
                    <button type = "submit">Đăng ký</button> 
                    <p style = "color: red">${message2}</p>
                </form>    
            </div>
            <div class="form- sign-in">
                <form action="login" method = "post">
                    <h1>Đăng nhập</h1>
                    <input type="text" placeholder="Email" name = "username" required >
                    <input type="password" placeholder="Password" name = "password" required>
                    <a href="">Quên mật khẩu? </a>
                    <button type = "submit">Đăng nhập</button>
  					<p style = "color: red">${message1}</p>
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
    </script>
</body>
</html>