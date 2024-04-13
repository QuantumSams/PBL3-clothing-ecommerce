<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./Crud.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
    <div class="mainBody">
        <div class="sideBar col-2">
            
        </div>
        <div class="addProduct">
            <div class="header">
                <div class="block">
                    <div class="title">
                        <h2>Thêm sản phẩm mới</h2>
                    </div>
                    <div class="listButton">
                        <button class = "add button1">
                            Lưu
                        </button>
                        <button class = "Cancel button1">
                            Huỷ bỏ
                        </button>
                    </div>
                </div>  
            </div>
            <div class="main">
                <div class="Left">
                    <div class="information">
                        <div class="form">
                            <div >
                                <h5>Tên mặt hàng</h5>
                                <textarea id="my-textarea" rows="1" cols="80"></textarea>
                            </div>
                            <div style = "margin-top: 10px;">
                                <h5>Mô tả sản phẩm</h5>
                                <textarea id="my-textarea" rows="4" cols="80"></textarea>
                            </div>
                            <div style = "margin-top: 10px;">
                                <h5>Thông tin chi tiết</h5>
                                <textarea id="my-textarea" rows="6" cols="80"></textarea>
                            </div>
                            
                        </div>
                    </div>
                    <div class="imageItems">
                        <div class="form">
                            <h5>Ảnh</h5>
                            <div class="upload-container">
                                <label for="image-upload" class="custom-label">Kéo thả hình ảnh vào đây</label>
                                <input type="file" id="image-upload" class="custom-input" accept="image/*">
                                <img id="preview-image" src="#" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="price">
                        <div class="form">
                            <h5>Giá</h5>
                            <div class="priceSet" style = "display: flex;">
                                <div class = "blockPrice" >
                                    <h6>Giá bán: </h6>
                                    <input type="text" style = "width: 50%;" >
                                </div>
                                <div class = "blockPrice">
                                    <h6>Giá khuyến mãi:</h6>
                                    <input type="text" style = "width: 50%;">
                                </div>
                            </div>
                            <div style = "margin-top: 30px;">
                                <h6>Giá nhập vào:</h6>
                                <input type="text" style = "width: 40%;">
                            </div>
                            <div style = "margin-top: 30px;">
                                <h6>Số lượng hàng đã nhập</h6>
                                <input type="text">
                            </div>
                        </div>
                    </div>
                    <div class = "SizeandColor">
                        <div class="form">
                            <h5>Phân loại hàng</h5>
                            <div style = "margin-top: 20px;">
                                <h6>Chất liệu</h6>
                                <Select>
                                    <Option>Cotton</Option>
                                    <Option>Thun</Option>
                                    <Option>Jean</Option>
                                </Select>
                            </div>
                            <hr style = "margin-top: 20px; margin-bottom: 20px; width: 95%;">
                            <div class="color">
                                <div style= "display: flex; justify-content: space-between;">
                                    <h6 style = "font-weight: bold;">Màu sắc</h6>
                                    <button class ="btn1" onclick = "acceptChange('btn1','.editColor')">Chỉnh sửa</button>
                                </div>
                                <div class = "editColor">
                                            	
                                            <c:forEach var="item" items="${mau_sac}">
                                            	<input type="text" value = '${item.ten_mau}'/>
                                            </c:forEach>
                                        <ul id="itemListColor">
                                        </ul>
                                      <button onclick="addItem('itemListColor')">Add</button>
                                </div>

                            </div>
                            <div class="size">
                                <div style= "display: flex; justify-content: space-between;">
                                    <h6 style = "font-weight: bold;">Size</h6>
                                    <button class ="btn2" onclick = "acceptChange('btn2', '.editSize')">Chỉnh sửa</button>
                                </div>
                                <div class = "editSize">
                                        <ul id="itemListSize">
                                            
                                        </ul>
                                      <button onclick="addItem('itemListSize')">Add</button>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                    <button onclick = "createTable()">OK</button>
                    <div class="table">
                        <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Chủng loại</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Số lượng</th>
                              </tr>
                            </thead>
                            <tbody id = "myTable">
                                
                            </tbody>
                          </table>
                    </div>
                </div>
                <div class="Right">
                    <div class="up">
                        <div class="form">
                            <h5>Nhà phân phối</h5>
                            <h6>Thương hiệu</h6>
                            <input type="text">
                        </div>
                    </div>
                    <div class="down">
                        <div class="form">
                            <h5>Danh mục hàng</h5>
                            <h6>Đối tượng</h6>
                            <Select>
                                <Option>
                                    Nam
                                </Option>
                                <Option>
                                    Nữ
                                </Option>
                                <Option>
                                    Trẻ em
                                </Option>
                                <Option>
                                    Người già
                                </Option> 
                            </Select>
                            <h6>Tên danh mục</h6>
                            <Select>
                                <Option>
                                    Áo
                                </Option>
                                <Option>
                                    Quần
                                </Option>
                                <Option>
                                    Giày
                                </Option>
                                <Option>
                                    Thắt lưng
                                </Option> 
                            </Select>
                            <h6>Tên loại sản phẩm</h6>
                            <Select>
                                <Option>
                                    Áo cố tròn
                                </Option>
                                <Option>
                                    Áo cổ vuông
                                </Option>
                                <Option>
                                    Quần sịp
                                </Option>
                                <Option>
                                    Quần dài
                                </Option> 
                            </Select>
                        </div>
                    </div>
                </div>
            </div>
            
    </div>
    <script src="./Crud.js"></script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>