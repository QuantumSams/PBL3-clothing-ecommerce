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
</head>
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
                    <h5>${sessionScope.acc.fullName }</h5>
                </div>
                <hr class="hrbar">
                <div class="side-bar">

                </div>
            </div>
            <hr class= "center">
            <div class="right">
                <div class="setting">
                    <h5>
                        Chỉnh sửa thông tin
                    </h5>
                </div>
                <hr> 
                <div class="mainInfor">
                    <div class="rightleft">
                        <h5>Họ và tên: ${sessionScope.acc.fullName }</h5>
                        <c:if test = "${sessionScope.acc.gender == 1}">
    					<h5>Giới tính: Nam</h5>
   						 </c:if>
    					<c:if test = "${sessionScope.acc.gender == 0}">
    					<h5>Giới tính: Nữ</h5>
    					</c:if>
                        <h5>Ngày sinh: ${sessionScope.acc.birth }</h5>
                        <h5> Địa chỉ: ${sessionScope.acc.address }</h5>
                    </div>
                    <div class="rightright">
                        <h5>Email: ${sessionScope.acc.email }</h5>
                        <h5>Số điện thoại: ${sessionScope.acc.phoneNumber }</h5>
                        <h5>ID tài khoản: ${sessionScope.acc.id }</h5>
                    </div>
                </div>   
            </div>
        </div>
    </div>
</body>
</html>