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
    <link rel="stylesheet" href="product.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
        <div class="row">
          <div class="col-7">
            <div class="imageItems">
                <div class="top">
                    <div class="left">
                    </div>

						<div id="demo" class="carousel slide" data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#demo"
									data-bs-slide-to="0" class="active"></button>
								<button type="button" data-bs-target="#demo"
									data-bs-slide-to="1"></button>
								<button type="button" data-bs-target="#demo"
									data-bs-slide-to="2"></button>
							</div>
							<div class="carousel-inner">
								<c:forEach var="item" items="${product.anh_san_pham}">
									<div class="carousel-item active">
										<img src="${item}" alt=""
											class="d-block w-70 " style = "padding: 10px 10px 10px 10px; width: 500px; margin-left: 35px;"="">
									</div>
								</c:forEach>
								
							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#demo" data-bs-slide="prev">
								<span class="btn-left"><i
									class="fa-solid fa-chevron-left"></i></span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#demo" data-bs-slide="next">
								<span class="btn-right"><i
									class="fa-solid fa-chevron-right"></i></span>
							</button>
						</div>
						
               
                </div>
                
                <div class="bottom">
                    <div class="describe">
                        <h4>
                            Mô tả
                        </h4>
                        <p>
                            Mã sản phẩm
                        </p>
                    </div>
                    <div class="overview">
                        <div class="accordion" id="accordionExample">
                            <div class="accordion-item">
                              <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                  Tổng quan
                                </button>
                              </h2>
                              <div id="collapseOne" class="accordion-collapse collapse " data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                   ${product.thong_tin_chi_tiet}
                                </div>
                              </div>
                            </div>
                            <div class="accordion-item">
                              <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                  Chất liệu
                                </button>
                              </h2>
                              <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                  ${product.chat_lieu}
                                </div>
                              </div>
                            </div>
                            <div class="accordion-item">
                              <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                  Chính sách hoàn trả
                                </button>
                              </h2>
                              <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                  <strong>This is the third item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
                                </div>
                              </div>
                            </div>
                          </div>
                    </div>
                </div>
            </div>
          </div>
          <div class="col-5">
            <div class="inforItems">
                <h2>
                	${product.ten_san_pham}
                </h2>
                <div class="Price-star">
                    <h4>
                        ${product.gia_tien}
                    </h4>
                    <div class="star">
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <p style = "text-decoration: underline">(79)</p>
                    </div>
                </div>
                <p>
                	${product.ten_nhan_hang}
                </p>
                <h7>
                    ${product.thong_tin_chung}
                </h7>
                <hr>
                <h5 id = "labelColor">
                    Màu sắc: 
                </h5>
                <div class = "box color">
					<c:forEach var="item" items="${product.mau_hien_co}">

						<button class = "btnColor"><img src="${item.anh_mau_sac}" width="100%" ><div class ="colorDiv">${item.ten_mau}</div> 
							<input  value = "${item.id_mau_sac}" class = "mausac" type = "hidden"></button>

					</c:forEach>
                </div>
                <div class="size">
                    <h5 id = "labelSize">
                        Kích cỡ: 	
                    </h5>
                    <a href="" class="">
                        BẢNG KÍCH THƯỚC
                    </a>
                </div>
                <div class="box sizes">
                	<c:forEach var="item" items="${product.size_hien_co}">

                	 	<div class="square"> <button class ="btnSize" disabled >${item.ten_size} <input  value = "${item.id_size}" class = "kichco" type = "hidden"></button> </div>

					</c:forEach>
                </div>
                <div>
                    <button class = "buttonS">KÍCH THƯỚC THEO CHIỀU CAO</button>
                </div>

                <div>
                    <h5 style = "margin-top: 20px;">Số lượng trong kho</h5>
                </div>
                
                <div>
                	<input >
                </div>
              <!--   <p style = "margin-top: 10px;">
                    Còn ít hàng
                </p -->
                <c:forEach var="item" items="${product.muc_san_pham}">
                	<input class = "id_mau_sac_duyet" value="${item.mau_sac_san_pham.id_mau_sac}" type = "hidden">
                	<input class = "id_size_duyet" value="${item.kich_thuoc_san_pham.id_size}" type = "hidden">
                	<input class = "id_muc_duyet" value="${item.id_muc_san_pham}" type = "hidden">
                </c:forEach>
                
                <input class = "id_nguoi_dung" value="${acc.id_nguoi_dung}" type="hidden">
                <input class = "resultColor" type="hidden">
                <input class = "resultSize" type="hidden">
               	<input class = "muc_san_pham" value="${product.muc_san_pham}" type="hidden">
               	<div>
                    <h5 style = "margin-top: 20px;">Số lượng mua hàng</h5>
                </div>
               	<input class = "so_luong" >
                <button class = "cart">
                    THÊM VÀO GIỎ HÀNG
                </button>
                <div class="addAndSearch">
                    <button class ="buttonA">THÊM VÀO DANH SÁCH MONG MUỐN</button>
                    <button class ="buttonA">TÌM SẢN PHẨM CÒN HÀNG TRONG CỬA HÀNG</button>
                </div>
                <hr>
                <p style = "font-weight: bold;">CHIA SẺ:</p>
                <div class = "icon" style = "margin-top:20px;display: flex; gap:20px;">
                    <i class="fa-brands fa-square-facebook fa-2xl"></i>
                    <i class="fa-brands fa-square-x-twitter fa-2xl"></i>
                    <i class="fa-brands fa-youtube fa-2xl"></i>
                </div>
            </div>
          </div>
        </div>
      </div>
    
</body>
<script src= "product.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</html>
</html>