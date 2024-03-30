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
                    <img src="img/ao-thun-in-hinh-theo-yeu-cau.jpg" style = "padding: 10px 10px 10px 10px; width: 500px; margin-left: 35px;"="">
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
                                  <strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
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
                                  <strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
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
                    Áo Parky chống UV bỏ túi(3D cut) Chống Nắng
                </h2>
                <div class="Price-star">
                    <h4>
                        990.000 VNĐ
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
                    Sản phẩm này được làm từ chất liệu tái chế
                </p>
                <h7>
                    Áo parky bỏ túi tiện dụng của chúng tôi luôn sẵn sàng khi bạn cần. Cắt 3D cho phép di chuyển dễ dàng, UPF40
                </h7>
                <hr>
                <h5>
                    MÀU SẮC: 09 BLACK
                </h5>
                <div class = "box color">
                    <div class="square box1"></div>
                    <div class="square box2"></div>
                    <div class="square box3"></div>
                </div>
                <div class="size">
                    <h5>
                        KÍCH CỠ: NAM L
                    </h5>
                    <a href="" class="">
                        BẢNG KÍCH THƯỚC
                    </a>
                </div>
                <div class="box sizes">
                    <div class="square"> XL </div>
                    <div class="square"> L </div>
                    <div class="square"> 2XL</div>
                </div>
                <div>
                    <button class = "buttonS">KÍCH THƯỚC THEO CHIỀU CAO</button>
                </div>

                <div>
                    <h5 style = "margin-top: 20px;">Số lượng</h5>
                </div>
                <select class="form-select" aria-label="Default select example">
                    <option selected>1</option>
                    <option value="1">2</option>
                    <option value="2">3</option>
                    <option value="3">4</option>
                </select>
                <p style = "margin-top: 10px;">
                    Còn ít hàng
                </p>
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</html>
</html>