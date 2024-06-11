<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link rel="stylesheet" href="userInfor.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<title>Document</title>
</head>
<body>
	<div class="container light-style flex-grow-1 container-p-y">
		<div class="header font-weight-bold py-3 mb-4">
			<h3>Thêm nhân viên mới</h3>
		</div>

			<div class="card overflow-hidden">
				<div class="form" style="display: flex;">
					<div class="sidebar col-md-3 pt-0">
						<div class="list-group list-group-flush account-settings-links">
							<a class="list-group-item list-group-item-action active"
								data-toggle="list" href="#account-general">General</a> <a
								class="list-group-item list-group-item-action"
								data-toggle="list" href="#account-change-password">Change
								password</a>
						</div>
					</div>

					<div class="infor col-md-9 pt-0">
						<div class="tab-content">
							<div class="tab-pane fade active show" id="account-general">
								<div class="cardImage card-body">

									<img id="img" src="" alt="Card image" class="d-block ui-w-80">
								</div>
								<div class="mainInfor card-body">

									<input type="file" id="fileInput" name="file" />

									<div class="name form">
										<label for="" class="form-label">Tên</label> <input
											id="ho_ten_khach_hang" type="text" class="form-control"
											value="" name="name">
										<input id="id_khach_hang" type="text" class="form-control"
											value="" name="id"
											style="display: none">
									</div>
									<div class="phoneNum form">
										<label for="" class="form-label">Số điện thoại</label> <input
											type="tel" id="so_dien_thoai" class="form-control"
											value="" name="phone">
									</div>
									<div class="email form">
										<label for="" class="form-label">Email</label> <input
											type="email" id="email" class="form-control"
											value="" name="email">
									</div>
									<div class="address form">
										<label for="" class="form-label">Tỉnh/ Thành phố</label> <input
											id="tinh" type="text" class="form-control"
											value="" name="address">
									</div>
									<div class="address form">
										<label for="" class="form-label">Huyện / Quận</label> <input
											id="huyen" type="text" class="form-control"
											value="" name="address">
									</div>
									<div class="address form">
										<label for="" class="form-label">Xã / Phường</label> <input
											id="xa" type="text" class="form-control"
											value="" name="address">
									</div>
									<div class="address form">
										<label for="" class="form-label">Địa chỉ cụ thể</label> <input
											id="cu_the" type="text" class="form-control"
											value=""
											name="address">
									</div>
									<div class="Gender form">
										<label for="" class="form-label">Giới tính</label>

										<div class="radio">
											<div class="form-check">
													<input type="radio" class="form-check-input" id="radio1"
														name="optradio" id="radio1" value="option1" checked>Nam
													<label class="form-check-label" for="radio1"></label>
												</div>
												<div class="form-check">
													<input type="radio" class="form-check-input" id="radio2"
														name="optradio" id="radio2" value="option2">Nữ <label
														class="form-check-label" for="radio2"></label>
											</div>
											
										</div>

									</div>
									<div class="birth form">
										<label for="" class="form-label">Ngày sinh</label> <input
											id="ngay_sinh" type="date" class="form-control"
											value="" name="birth">
									</div>
									<div class="form-group">
										<label class="form-label">Mật khẩu </label> <input
											id="new_password" type="password" class="form-control">
									</div>
									<div class="form-group">
										<label class="form-label">Nhập lại mật khẩu</label> <input
											id="new_repassword" type="password" class="form-control">
									</div>

								</div>
							</div>
							<div class="tab-pane fade" id="account-change-password">
								<div class="card-body pb-2">
									<div class="form-group">
										<label class="form-label">Mật khẩu hiện tại</label> <input
											id="old_password" type="password"
											class="form-control">
									</div>
									<div class="form-group">
										<label class="form-label">Mật khẩu mới</label> <input
											id="new_password" type="password" class="form-control">
									</div>
									<div class="form-group">
										<label class="form-label">Nhập lại mật khẩu mới</label> <input
											id="new_repassword" type="password" class="form-control">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="text-right mt-3">

				<button id="save">OK</button>
				<button type="button" class="btn btn-default"
					onclick="history.back()">Cancel</button>
			</div>

		<input type="button" id="doi_mat_khau" value='Thay đổi mật khẩu' />

	</div>
</body>
<script data-cfasync="false"
	src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>

<script type="text/javascript">
	const fileInput = document.getElementById('fileInput');
	const imgElement = document.getElementById('img');

	fileInput.addEventListener('change', function(event) {
		const file = event.target.files[0];

		if (file) {
			const reader = new FileReader();

			reader.onload = function(event) {
				imgElement.src = event.target.result;
			};

			reader.readAsDataURL(file);
		}
	});

	
	
	$(document).ready(
			function() {
				let img = document.querySelectorAll('#img');
				
				$("#save").click(
						function() {
							let imageSrc = [];
							img.forEach((image) => {
								imageSrc.push(image.src.split(",")[1]);
								
							});
							
							$.ajax({
								url : "tao_nhan_vien", // URL of your Servlet
								type : "POST",
								dataType : 'json',
								data : {
									email : $("#email").val(),
									so_dien_thoai : $("#so_dien_thoai").val(),
									ho_ten : $("#ho_ten_khach_hang").val(),
									ngay_sinh : $("#ngay_sinh").val(),
									gioi_tinh : $("#radio1").prop('checked'),
									dia_chi : $("#tinh").val() + '/'
											+ $("#huyen").val() + '/'
											+ $("#xa").val() + '/'
											+ $("#cu_the").val(),
									new_password : $("#new_password").val(),
									anh: imageSrc[0]
								},
								success : function(data) {
									alert(data);
								}
							});
						});
			});

	function uploadFile() {
		let formData = new FormData();
		formData.append("file", ajaxfile.file[0]);
		await
		fetch('fileuploadservlet', {
			method : "POST",
			body : formData
		});
		alert('The file upload thanh cong');
	}
</script>
</html>