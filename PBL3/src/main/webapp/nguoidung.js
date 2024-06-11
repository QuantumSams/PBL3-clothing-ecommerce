
$(document).ready(function() {
	$("#gio_hang").click(function() {
		$.ajax({
			url: "don_hang_tong_quat", // URL of your Servlet
			type: "GET",
			dataType: 'json',
			data: {
				id_khach_hang: $("#id_khach_hang").val()
			},

			success: function(data) {

				let chuoi = "";
				data.forEach(function(item) {
					chuoi += '<div class="card ">' +
						'<div class="item-cart">' +
						'<div class="img-infor">' +
						'<img src="' + item.muc_san_pham.anh_chi_tiet + '" alt="" width="100px">' +
						'<div class="inforItems">' +
						'<div class="name">' +
						'<h5>' + item.muc_san_pham.ten_san_pham + '</h5>' +
						'<h6>' + item.muc_san_pham.mau_sac_san_pham.ten_mau + ' / ' + item.muc_san_pham.kich_thuoc_san_pham.ten_size + '</h6>' +
						'<button value="' + (item.id_gio_hang) + '" class = "btnXoa">Xoá</button>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'<div class="price-amount">' +
						'<h6 class = "gia">' + parseInt(item.muc_san_pham.gia_tien).toLocaleString('vi-VN') + ' VNĐ <input type="checkbox" name="" class="checkBuy"  > <input class="gio_hang" type="hidden" value="' + item.id_gio_hang + '"/></h6>' +
						'' +
						'<h6 class = "soLuong">' + item.so_luong + ' Cái</h6>' +
						'</div>' +	
						'</div>' +
						'</div>';
				});

				chuoi += '<div class="thanhtoan">' +
					'<div class="giatien">' +
					'<h5>Tạm tính: </h5>' +
					'<h5 id = "sum"></h5>' +
					'</div>' +
					'<form action = "create_order" method = "get">' +
					'<input name="gio_hang" id = "giohang" type = "hidden"/>' +
					'<input type = "submit" class = "mua" value =  "Thanh toán">' +
					'</form>'
				'</div>';

				$("#list_gio_hang").html(chuoi);
				tien();

				getID()
				var checkBox = document.querySelectorAll('.checkBuy');
    				checkBox.forEach(item =>{
       			 	item.addEventListener('change', (e)=>{
            		tien();
            		getID();
        			})
    			})

				
			}
		});
	});
});

$(document).ready(function() {
	$('#list_gio_hang').on('click', 'button', function() {
		$.ajax({
			url: "xoa_gio_hang", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				id_gio_hang: $(this).val()
			},
			success: function(data) {
			}
		});

		this.parentElement.parentElement.parentElement.parentElement.parentElement.remove();
		tien();

		getID();
	});
});
function getID(){
	document.querySelector('#giohang').value = "";
	let a = document.querySelectorAll('.gia');
	for(let i = 0; i < a.length; ++i){
		if(a[i].childNodes[1].checked){
			document.querySelector('#giohang').value += a[i].childNodes[3].value + " ";
		}
	}
}
/*

$(document).ready(function() {
	$('.buttonTT').on('click', 'button', function() {
		
		let gio_hang = [];

		let list = document.querySelectorAll('.gio_hang');
		list.forEach(item => {
			gio_hang.push(item.value);
		});
		
		$.ajax({
			url: "create_order", // URL of your Servlet
			type: "GET",
			dataType: 'json',
			data: {
				gio_hang: JSON.stringify(gio_hang)
			},

			success: function(data) {
			}
		});

	});
});*/


function layGioHang() {
	
	
	//return JSON.stringify(gio_hang);
}
  
function tien() {
	let a = document.querySelectorAll('.gia');
	let b = document.querySelectorAll('.soLuong');
	let sum = 0;
	for(let i = 0; i < a.length; ++i){
		if(a[i].childNodes[1].checked){
			let tmp = a[i].innerHTML
			sum += parseFloat(a[i].innerHTML.split(' ', 1))*(parseFloat(b[i].innerHTML.split(' ', 1)));
		}
	}
	document.querySelector('#sum').innerHTML = parseInt(sum).toLocaleString('vi-VN') + ' VNĐ'
}
$(document).ready(function() {
	$("#lich_su").click(function() {
		$.ajax({
			url: "lich_su_don_tong_quat", 
			type: "GET",
			dataType: 'json',
			data: {
				id_user: $("#id_khach_hang").val()
			},

			success: function(data) {

				let chuoi = "";
				data.forEach(function(item) {

					const date = new Date(item.thoi_gian_dat);
					const year = date.getFullYear();
					const month = date.getMonth() + 1; // Tháng trong JavaScript bắt đầu từ 0
					const day = date.getDate();

					chuoi += '<tr>' +
						'<td>' + day + "/" + month + "/" + year + '</td>' +
						'<td>' + item.tong_tien + ' VNĐ</td>' +
						'<td>' + item.so_luong + '</td>' +
						'<td><button type="button" class="btn btn-primary submitDon" id = "'+item.id_don_hang+'">' + item.trang_thai_don_hang + '</button></td>' +
						'<td>' + item.so_sao_danh_gia + '</td>' +
						'<td>'+
						'<form action="xem_lich_su_don" method="get">'+
						'<input type="hidden" name="id_don_hang" value="'+item.id_don_hang+'">'+
						'<button class="btn btn-primary">Xem chi tiết</button>'+
						'</form>'+
						'</td>'+
						'<td>'+
						'<button class="huy_don_hang">'+
						'<input class="vale" type="hidden" value="'+item.id_don_hang+'">Hủy đơn hàng'+
						'</button>'+
						'</td>'+
						'</tr>';
				});

				$("#san_pham").html(chuoi);
			}
		});
	});
});

let a = document.querySelectorAll('.huy_don_hang');
a.forEach(item => {
	item.addEventListener('click', e =>{
		const inputValue = item.childNodes[0].value;
		alert(inputValue);
		$.ajax({
			url: "khach_hang_huy_don", 
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang : inputValue,
				trang_thai_don_hang: "huy"
			},
			success: function(data) {
				alert(data);
			},
			error:  function() {
				alert("loi");
			},
		});
	})
})

$(document).ready(function() {
	$("#doi_mat_khau").click(function() {
		$.ajax({
			url: "update_password", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				old_password: $("#old_password").val(),
				new_password: $("#new_password").val(),
				new_repassword: $("#new_repassword").val()
			},
			success: function(data) {
				alert(data);
			}
		});
	});
});

$(document).ready(function() {
	let img = document.querySelectorAll('#img');
	
	$("#cap_nhat_thong_tin").click(function() {
		let imageSrc = [];
		img.forEach((image) => {
			imageSrc.push(image.src.split(",")[1]);

		});	
		$.ajax({
			url: "modify_Infor", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				id_khach_hang: $("#id_khach_hang").val(),
				ho_ten_khach_hang: $("#ho_ten_khach_hang").val(),
				ngay_sinh: $("#ngay_sinh").val(),
				gioi_tinh: $("#radio1").prop('checked'),
				dia_chi: $("#tinh").val() + '/' + $("#huyen").val() + '/' + $("#xa").val() + '/' + $("#cu_the").val(),
				anh:  imageSrc[0]
			},
			success: function(data) {
				alert(data);
			}
		});
	});
	
	$("#cap_nhat_thong_tin1").click(function() {
			
		$.ajax({
			url: "modify_Infor", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				id_khach_hang: $("#id_khach_hang").val(),
				ho_ten_khach_hang: $("#ho_ten_khach_hang").val(),
				ngay_sinh: $("#ngay_sinh").val(),
				gioi_tinh: $("#radio1").prop('checked'),
				dia_chi: $("#tinh").val() + '/' + $("#huyen").val() + '/' + $("#xa").val() + '/' + $("#cu_the").val(),
				anh:  imageSrc[0]
			},
			success: function(data) {
				alert(data);
			}
		});
	});
});

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

const btnSubmit = document.querySelectorAll('.submitDon');
btnSubmit.forEach(item=>{
	item.addEventListener('click', e=>{
		const inputValue = item.id;
		$.ajax({
			url: "khach_hang_nhan_don", 
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang : inputValue,
				trang_thai_don_hang: "xac_nhan"
			},
			success: function(data) {
				alert(data);
			},
			error:  function() {
				alert("loi");
			},
		});
	})
})