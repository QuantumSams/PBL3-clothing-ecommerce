<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TGH</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="header">
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
                <a href="index.jsp"><img src="img/logoicqon.png" width = 100; alt=""></a>
            </div>
            <div class="container-fluid">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" href="#">Nữ</a>
                    <ul class="dropdown">
                        <li><a href="#">Áo thun</a></li>
                        <li><a href="#">áo ấm</a></li>
                        <li><a href="#">Áo vest</a></li>
                        <li><a href="#">Áo len</a></li>
                    </ul>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">nam</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Trẻ em</a>
                  </li>
                </ul>
              </div>
              <div class="container-fluid">
                <div class="search">
                    <form class = "d-flex">
                        <input class="form-control me 2 " type="search">
                        <button class="btn btn-outline-infor"><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i></button>
                    </form>
                </div>
              </div>
              <div class="container-fluid">
                <ul class="navbar-nav">
                    <c:if test = "${sessionScope.acc == null}">
                        <li class="nav-item">
                            <a href="login.jsp" class="nav-link"><i class="fa-solid fa-user" style="color: #000000;"></i></a>
                        </li>
                    </c:if>
                    <c:if test = "${sessionScope.acc != null }">
                    	<li class = "nav-item">
                    		<a href = "userInfor.jsp" class = "nav-link">Hello ${sessionScope.acc.fullName}</a>
                    	</li>
                    </c:if>
                    <li class="nav-item">
                      <a class="nav-link" href="#"><i class="fa-solid fa-heart" style="color: #000000;"></i></a>
                    </li>
                    <li class="nav-item">
                        <a href="" class="nav-link"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></i></a>
                    </li>
                    <c:if test = "${sessionScope.acc != null }">
                    	<li class = "nav-item">
                    		<a href = "logout" class = "nav-link">Log out</a>
                    	</li>
                    </c:if>
                  </ul>
                </div>
              </div>
        </nav>

    <div id="demo" class="carousel slide" data-bs-ride="carousel">

        <div class="carousel-indicators">
            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
             <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="img/61Pdr3h6MmL._SX3000_.jpg" alt="" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="img/61zAjw4bqPL._SX3000_.jpg" alt="" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="img/71VBt4eTg3L._SX3000_.jpg" alt="" class="d-block w-100">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
            <span class = "btn-left"><i class="fa-solid fa-chevron-left"></i></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
            <span class = "btn-right"><i class="fa-solid fa-chevron-right"></i></span>
        </button>
        </div>
    </div>
</body>
<script>
    var myCarousel = document.querySelector('#myCarousel')
    var carousel = new bootstrap.Carousel(myCarousel, {
    interval: 1000,
    wrap: false
    })
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</html>