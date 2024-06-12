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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    
    <div class="mainBody">
        <div class="sideBar col-2">
            
        </div>	
        
        <div class="addProduct">
            <div class="header">
                <div class="block">
                    <div class="title">
                        <h2>Chỉnh sửa sản phẩm </h2>
                    </div>
                    <div class="listButton">
                    	<button id="button_add_product" class = "add button1">
	                        Lưu
	                    </button>
                        
                        <button class = "Cancel button1" onclick="history.back()">
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
                            	<% int a = 80;  %>
                                <h5>Tên mặt hàng</h5>
                                <input id="id_san_pham" type="hidden" value="${product.id_san_pham}">
                                <textarea id="ten_mat_hang" style = "width: 100%;height: 20%">${product.ten_san_pham}</textarea>
                            </div>
                            <div style = "margin-top: 10px;">
                                <h5>Mô tả sản phẩm</h5>
                                <textarea id="mo_ta" style = "width: 100%; height: 20%;" >${product.thong_tin_chung}</textarea>
                            </div>
                            <div style = "margin-top: 10px;">
                                <h5>Thông tin chi tiết</h5>
                                <textarea id="thong_tin_chi_tiet" >${product.thong_tin_chi_tiet}</textarea>
                            </div>
                            
                        </div>
                    </div>
                    <div class="imageItems">
                        <div class="form">
                            <h5>Ảnh</h5>
                            <div class="upload-container" id="div_anh">
                            	<c:forEach var="item" items="${product.anh_san_pham}">
                            		<div class="img_element">
	                            		<img src="${item}">
										<div class="btnXoa" onclick="removeIMG(this)">
											<i class="fa-solid fa-x"></i>
										</div>		
										<div class="btnPreview" onclick="previewImageElement(this)">
											<i class="fa-solid fa-search"></i>
										</div>	
                            		</div>
                                </c:forEach>
                                <input  style="display: none;" type="file"  id="fileInput" name="file" multiple/>
                               	<label for="fileInput">
                               		<i class="fa-solid fa-plus"></i>
                               	</label>
                            </div>
                        </div>
                    </div>
                    <div class = "SizeandColor">
                        <div class="form">
                            <h5>Phân loại hàng</h5>
                            <div style = "margin-top: 20px;">
                                <h6>Chất liệu</h6>
                                <input id="chat_lieu" type="text" value="">
                            </div>
                            <hr style = "margin-top: 20px; margin-bottom: 20px; width: 95%;">
                            <div class="color">
                                <div class = "fixcontent" style= "display: flex;">
                                    <h6 style = "font-weight: bold;">Màu sắc</h6>
                                   <!--  <button class ="btn1" onclick = "acceptChange('btn1','.editColor')">Chỉnh sửa</button> -->
                                     <div class = "box color">
							<c:forEach var="item" items="${mau_sac}">
							<button class = "btnColor"><img src="${item.anh_mau_sac}" width="100%" ><div class ="colorDiv">${item.ten_mau}</div> 
							<input  value = "${item.id_mau_sac}" class = "mausac" type = "hidden"></button>
							</c:forEach>
                		</div>
                		
							<button class = "themMuc" onclick="openPopupColor()">Add </button>

                                	<%-- <Select id="itemListMau_sac">
                                            <c:forEach var="item" items="${mau_sac}">
                                            	<option value="${item.id_mau_sac}">
                                            		${item.ten_mau}
                                            	</option>
                                            </c:forEach>
                                    </Select> --%>
                                </div>
                               <%--  <div class = "editColor">
                                        <ul id="itemListColor">
                                         	<c:forEach var="item" items="${mau_sac}">
                                         		<div class ="inputSize">
                                         			<input class = " " type="text" value = '${item.ten_mau}'/>
                                            		<button class = "deleteItem" onclick = "removeItem('#itemListColor')">X</button>
                                         		</div>  
                                            </c:forEach>
                                        </ul>
                                      <button onclick="addItem('itemListColor')">Add</button>
                                </div>
 --%>
                            </div>
                            <div class="size">
                                <div class = "fixcontent" style= "display: flex; justify-content: space-between;">
                                    <h6 style = "font-weight: bold;">Size</h6>
                                    <!-- <button class ="btn2" onclick = "acceptChange('btn2', '.editSize')">Chỉnh sửa</button> -->
                                	<%-- <Select id="itemListSize">
                                            <c:forEach var="item" items="${size}">
                                            	<option value="${item.id_size}">
                                            		${item.ten_size}
                                            	</option>
                                            </c:forEach>
                                    </Select> --%>
                                    <div class = "box sizeBtn">
						<c:forEach var="item" items="${size}">
						<button class = "btnSize"><div >${item.ten_size}</div><input  value = "${item.id_size}" class = "mausac" type = "hidden"></button>
						</c:forEach> 	
                		</div>
                		<button class ="themMuc" onclick="openPopupSize()">Add </button>
                                </div>
                                
                               <%--  <div class = "editSize">
                                	<ul id="itemListSize">
                                 			<c:forEach var="item" items="${size}">
                                 				<div>
                                 					<input type="text" value = '${item.ten_size}'/>
                                            		<button class = "deleteItem" onclick = "removeItem('#itemListColor')">X</button>
                                 				</div>
                                            </c:forEach>
                                     </ul> 
                                     <button onclick="addItem('itemListSize')">Add</button>
                                </div> --%>
                            </div>
                        </div>
                    </div>
                   <div style = "display: flex; margin: 20px 0 20px 0; justify-content: center;">
                     <button class = "create" onclick = "createTable()">OK</button>
                    </div>
                    <div class="Jtable">
                        <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Size</th>
                                <th scope="col">Màu</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Ảnh</th>
                                <th scope="col"></th>
                              </tr>
                            </thead>
                            <tbody id = "myTable">
								<f:viewBean>
									<managed-bean class="com.example.MyBean" scope="session" />
								</f:viewBean>

								<%-- In your JSP code --%>
								<c:set var="count" value="#{myBean.counter}" />
								<c:forEach var="item" items="${product.muc_san_pham}">
									<tr>
										<c:set var="count" value="${count + 1}" />
										<td>${count}</td>
										<td>
											<div>${item.kich_thuoc_san_pham.ten_size}</div> <input
											class="size_table" type="hidden"
											value="${item.kich_thuoc_san_pham.id_size}">
										</td>
										<td>
											<div>${item.mau_sac_san_pham.ten_mau}</div> <input
											class="size_table" type="hidden"
											value="${item.mau_sac_san_pham.id_mau_sac}">
										</td>
										<td><input type="text" class="gia"
											value="${item.gia_tien}"></td>
										<td>
											<div class="item-images item-images${count}">
												<input onchange="addImageItems(this)" style="display: none;"
													type="file" id="imageInput${count}" name="file" multiple>
												<label for="imageInput${count}"> <i
													class="fa-soild fa-plus"></i>
												</label>
												<div class="img_element">
												<div class = "imgItems">
												<div class="btnXoa" onclick="removeIMG(this)">
														<i class="fa-solid fa-x"></i>
													</div>	
													<img src="${item.anh_chi_tiet}" style="width: 80px">
													
													<div class="btnPreview" onclick="previewImageElement(this)">
														<i class="fa-solid fa-search"></i>
													</div>
													</div>
												</div>
											</div>
										</td>
										<td>
										<button class = "xoaRow" onclick = "deleteRow(this)">Xoá</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
                          </table>
                    </div>
                </div>
                <div class="Right">
                    <div class="up">
                        <div class="form">
                            <h5>Nhà phân phối</h5>
                            <h6>Thương hiệu</h6>
                            <input id="thuong_hieu" type="text" value="${product.ten_nhan_hang}">
                        </div>
                    </div>
                    <div class="down">
                        <div class="form">
                            <h5>Danh mục hàng</h5>
                            <h6>Đối tượng</h6>
                            <div class = "selectItem">
                            <Select id="Doi_tuong_khach_hang"><c:forEach var="item" items="${doi_tuong_khach_hang}"><Option value="${item.id}">${item.category}</Option></c:forEach></Select>
                            <button class = "themMuc" onclick="themDoituong()">Thêm</button>
                            </div>
                            
                            <h6>Tên loại sản phẩm</h6>
                            <div class = "selectItem">
                            <Select id="Loai_san_pham">
                            <c:forEach var="item" items="${ten_loai_san_pham}"><Option value="${item.id}">${item.category}</Option>
                                </c:forEach>
                            </Select>
                            <button class = "themMuc" onclick = "themLoaiSanPham()">Thêm</button>
                            </div>
                            <h6>Tên danh mục sản phẩm</h6>
                            <div class = "selectItem">
                            <Select id="Danh_muc">
                                <c:forEach var="item" items="${ten_danh_muc_san_pham}">
                            		<Option value="${item.id}">
                            			${item.category}	
									</Option>
                                </c:forEach>
                            </Select>
                            <button class = "themMuc" onclick = "themDanhMuc()">Thêm</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
    <script defer src="./CrudUpdate.js"></script>
    <script src="./Crud_Image.js"></script>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>