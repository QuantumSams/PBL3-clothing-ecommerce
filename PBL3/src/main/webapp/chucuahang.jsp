<%@ page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta Name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="chucuahang.css">
    <title>Document</title>
</head>
<div class="card ">
    <div class="form" style="display: flex;">
        <div class=" col-md-2 pt-0">
            <img src="386644391_1615327005662931_6147334074894597765_n.jpg" alt="" width="200">
            <p style = "margin-top: 20px;">Chức năng</p>
            <div class="list-group list-group-flush account-settings-links">
                <a class="list-group-item list-group-item-action active" data-toggle="list"
                href="#san-pham"><i class="fa-brands fa-product-hunt"></i>Sản phẩm</a>
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#kho-hang"><i class="fa-solid fa-box"></i>Kho hàng</a>
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#doanh-thu"><i class="fa-solid fa-money-check"></i>Doanh thu</a>
                <a class="list-group-item list-group-item-action" data-toggle="list"
                href="#nhan-vien"><i class="fa-solid fa-user"></i>Nhân viên</a>
            </div>
        </div>
        <div class = "infor col-md-10 pt-0">
            <div class="tab-content">
                <div class = "tab-pane fade active show" id = "san-pham">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Sản phẩm</h3>
                        	<form action="add_product" method="GET">
	                            <button class = "add">
	                                <i class="fa-solid fa-plus"></i>
	                                Thêm sản phẩm
	                            </button>
                            </form>
                        </div>
                        <div class = "inforItem">
                            <div class="header1">
                                <div class="search">
                                    <div class="input">
                                        <span class="iconSearch"><i class="fa-solid fa-magnifying-glass fa-rotate-90" style="color:white;"></i></span>
                                        <input class = "inputSearch" type="text" placeholder="Tìm kiếm sản phẩm trong danh sách">
                                    </div>
                                    <button class = "buttonSearch">Search</button>
                                </div>
                                <div class="Count">
                                    <h5 style ="color: white;">Tổng số sản phẩm: 900</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Giá bán</th>
                                        <th>Đối tượng</th>
                                        <th>Danh mục</th>
                                        <th>Nhãn hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>100.000 VNĐ</td>
                                        <td>Nam</td>
                                        <td>Áo</td>
                                        <td>Adidas</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="kho-hang">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Kho hàng</h3>
                        </div>
                        <div class = "inforItem">
                            <div class="header">
                                <div class="search">
                                    <div class="input">
                                        <span class="iconSearch"><i class="fa-solid fa-magnifying-glass fa-rotate-90" style="color:white;"></i></span>
                                        <input class = "inputSearch" type="text" placeholder="Tìm kiếm sản phẩm trong danh sách">
                                    </div>
                                    <button class = "buttonSearch">Search</button>
                                </div>
                                <div class="Count">
                                    <h5 style ="color: white;">Tổng số sản phẩm: 900</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Sẵn hàng</th>
                                        <th>Đã bán</th>
                                        <th>Cập nhật lần cuối</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Tên sản phẩm 1</td>
                                        <td>100</td>
                                        <td>99</td>
                                        <td>22/04/2024</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div> 
                <div class="tab-pane fade" id="doanh-thu">

                </div> 
                <div class="tab-pane fade" id="nhan-vien">
                    <div class="mainform">
                        <div class="header1">
                            <h3>Nhân viên</h3>
                        </div>
                        <div class = "inforItem">
                            <div class="header">
                                <div class="search">
                                    <div class="input">
                                        <span class="iconSearch"><i class="fa-solid fa-magnifying-glass fa-rotate-90" style="color:white;"></i></span>
                                        <input class = "inputSearch" type="text" placeholder="Tìm kiếm nhân viên trong danh sách">
                                    </div>
                                    <button class = "buttonSearch">Search</button>
                                </div>
                                <div class="Count">
                                    <h5 style ="color: white;">Tổng số nhân viên: 10</h5>
                                </div>
                            </div>
                        </div>
                        <div class="bodyInfor">
                            <table class = "content-table">
                                <thead>
                                    <tr>
                                        <th>Họ tên</th>
                                        <th>Giới tính</th>
                                        <th>Số điện thoại</th>
                                        <th>Chi tiết</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Nguyễn Văn A</td>
                                        <td>Nam</td>
                                        <td>0796 631 299</td>
                                        <td><button class = "buttonSearch">Chi tiết</button></td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Nguyễn Văn A</td>
                                        <td>Nam</td>
                                        <td>0796 631 299</td>
                                        <td><button class = "buttonSearch">Chi tiết</button></td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Nguyễn Văn A</td>
                                        <td>Nam</td>
                                        <td>0796 631 299</td>
                                        <td><button class = "buttonSearch">Chi tiết</button></td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Nguyễn Văn A</td>
                                        <td>Nam</td>
                                        <td>0796 631 299</td>
                                        <td><button class = "buttonSearch">Chi tiết</button></td>
                                    </tr>
                                    <tr>
                                        <td><img src="386644391_1615327005662931_6147334074894597765_n.jpg" width="50px" alt="">Nguyễn Văn A</td>
                                        <td>Nam</td>
                                        <td>0796 631 299</td>
                                        <td><button class = "buttonSearch"><a href="">Chi tiết</a></button></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                      
                    </div>
                    <div class="card popup">
                        <div class="header1">
                            <div class="backForward">
                                <button><</button>
                                <div class="Name">
                                    <h6>Nhân viên</h6>
                                    <h5>Nguyễn Văn A</h5>
                                </div>
                            </div>
                            <div class="ModifyInfor" style = "transform: translateX(-10%);">
                                <button class="add"><i class="fa-solid fa-book"></i>Chỉnh sửa thông tin</button>
                            </div>
                        </div>
    
                        
                    </div>
                    </div> 
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
</html>