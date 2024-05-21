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
    <jsp:include page="header.jsp"></jsp:include>
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
        
    <div class = main-items>
    	<c:forEach var="item" items="${san_pham}">
                 <div class="card" style="width:250px">
            		<img class="card-img-top" src="${item.anh_san_pham[0]}" alt="Card image">
            		<div class="card-body">
	                	<h6>${item.danh_muc_san_pham}</h6>
	                	<h5 class="card-title" style ="font-weight: bold;" >
	                	
	                	<form action="load_product" method="get">
	                		<button>
	                			${item.ten_san_pham}
	                		</button>
	                		<input type="hidden" name="id_san_pham" value="${item.id_san_pham}"/>
	                	</form>
	                		
	                	</h4>
	                	<p class="card-text">${item.ten_nhan_hang}</p>
	                	<h4 style = "font-weight: bold;">${item.gia_tien}</h4>
                		<div class="star">
	                    	<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
	                    	<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
	                    	<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
	                    	<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
	                    	<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
	                    	<p style = "text-decoration: underline">(79)</p>
                		</div>
            		</div>
        		</div>                        	  
		</c:forEach>
    </div>
</body>
    
</body>
<script>

	$(document).ready(function() {
	  $("#loadProductLink").click(function(event) {
	    event.preventDefault(); // Prevent default link behavior
	    var productId = $(this).data("productId");
	    // Use AJAX to load product information based on productId
	  });
	});
    var myCarousel = document.querySelector('#myCarousel')
    var carousel = new bootstrap.Carousel(myCarousel, {
    interval: 1000,
    wrap: false
    })
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</html>