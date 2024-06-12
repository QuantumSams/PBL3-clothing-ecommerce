	var doanhthu = document.querySelector('.bodyform');
    var donhang = document.querySelector('.mainform2');
    var btn_doanhthu = document.querySelector('.doanh-thu').addEventListener('click', (e) => {
          
        doanhthu.classList.add('active');
        doanhthu.classList.remove('fade');
        donhang.classList.remove('active');
        donhang.classList.add('fade');
    });
    var btn_donhang = document.querySelector('.don-hang').addEventListener('click', (e) => {
          
        donhang.classList.add('active');
        donhang.classList.remove('fade');
        doanhthu.classList.add('fade');
        doanhthu.classList.remove('active');
    });
    
    let tien = document.querySelector('#tienDoanhthu').textContent;
    document.querySelector('#tienDoanhthu').innerText = parseInt(tien).toLocaleString('vi-VN') + ' VNĐ';
    const xValues = ["Nam", "Nữ", "Trẻ em"];
    
    const barColors = ["#667085", "#667085","#667085","#667085","#667085"];
	const so_san_pham = document.querySelectorAll('.so_san_pham');
	const yValues = [so_san_pham[0].value, so_san_pham[1].value, so_san_pham[2].value];
    new Chart("myChart", {
        type: "bar",
        data: {
        labels: xValues,
        datasets: [{
        backgroundColor: barColors,
        data: yValues
        }]
    },
  //    options: {...}
});
$(document).ready(function(){
	 $("#button_search").click(function(){
		load_ajax_product();
	});
});

function load_ajax_product() {
	$.ajax({
		url: "get_product_by_ajax", // URL of your Servlet
		type: "GET",
		dataType: 'json',
		data: {
			product_name: $("#search").val()
		},
		success: function(data) {
			ShowSP(data);
		},

	});
}

function ShowSP(data) {
	let chuoi = "";
	data.forEach(function(item) {
		chuoi += '<tr>' +

			'<td><img src=' + item.anh_san_pham[0] + ' width="50px" alt=""></td>' +
			'<td>' + item.ten_san_pham + '</td>' +
			'<td>' + parseInt(item.gia_tien).toLocaleString('vi-VN')+ ' VNĐ</td>' +
			'<td>Nam</td>' +
			'<td>' + item.danh_muc_san_pham + '</td>' +
			'<td>' + item.ten_nhan_hang + '</td>' +
			'<td>' +
			'<form action="update_product" method="get">' +
			'<button class = "buttonSearch">Chi tiết</button>' +
			'<input type="hidden" name="id_san_pham" value="' + item.id_san_pham + '">' +
			'</form>' +
			'</td>' +
			'<td><button class="buttonRemove"><input type="hidden" value="' + item.id_san_pham + '">Xóa</button></td>' +
			'</tr>';

	});

	$("#san_pham").html(chuoi);

	let a = document.querySelectorAll('.buttonRemove');
	a.forEach(item => {
		item.addEventListener('click', e => {
			const inputValue = item.childNodes[0].value;
			$.ajax({
				url: "remove_product",
				type: "POST",
				dataType: 'json',
				data: {
					id_san_pham: inputValue,
				},
				success: function(data) {
					load_ajax_product();
				},
				error: function() {
					alert("loi");
				},
			});
		})
	})
}

let a = document.querySelectorAll('.buttonRemove');
a.forEach(item => {
	item.addEventListener('click', e => {
		const inputValue = item.childNodes[0].value;
		$.ajax({
			url: "remove_product",
			type: "POST",
			dataType: 'json',
			data: {
				id_san_pham: inputValue,
			},
			success: function(data) {
				load_ajax_product(data);
			},
			error: function() {
				alert("loi");
			},
		});
	})
})

$(document).ready(function(){
	 $("#button_search_nhan_vien").click(function(){
		load_ajax_nhan_vien();
	});
});

function load_ajax_nhan_vien(){
	$.ajax({
	      url: "load_nhan_vien_by_json", // URL of your Servlet
	      type: "GET",
	      dataType: 'json',
	      data: {
			name_nhan_vien: $("#search_nhan_vien").val()
		  },
	      success: function(data) {
			showNV(data)
	      },
	      
	   });
}

function showNV(data) {
	let chuoi = "";
	data.forEach(function(item) {
		chuoi += '<tr>' +
			'<td><img src="' + item.anh_dai_dien + '" width="50px" alt=""></td>' +
			'<td>' + item.ho_ten + '</td>' +
			'<td>'+ ((item.gioi_tinh) ? 'Nam' : 'Nữ')+'</td>' +
			'<td>' + item.so_dien_thoai + '</td>' +
			'<td>' +
			'<form action="thong_tin_nhan_vien" method="get">' +
			'<input type="hidden" name="id" value="' + item.id_nguoi_dung + '"/>' +
			'<button class="buttonSearch">Chi tiết</button>' +
			'</form>' +
			'</td>' +
			'<td>' +
			'<button class="buttonRemoveNV"><input type="hidden" name="id" value="' + item.id_nguoi_dung + '">Xóa</button>' +
			'</td>' +
			'</tr>'
	});

	$("#nhan_vien").html(chuoi);

	let b = document.querySelectorAll('.buttonRemoveNV');
	b.forEach(item => {
		item.addEventListener('click', e => {
			const inputValue = item.childNodes[0].value;
			$.ajax({
				url: "remove_User",
				type: "POST",
				dataType: 'json',
				data: {
					id: inputValue,
				},
				success: function(data) {
					load_ajax_nhan_vien(data);
				},
				error: function() {
					alert("loi");
				},
			});
		})
	})
}


let b = document.querySelectorAll('.buttonRemoveNV');
b.forEach(item => {
	item.addEventListener('click', e =>{
		const inputValue = item.childNodes[0].value;
		$.ajax({
			url: "remove_User", 
			type: "POST",
			dataType: 'json',
			data: {
				id : inputValue,
			},
			success: function(data) {
				load_ajax_nhan_vien(data);
			},
			error:  function() {
				alert("loi");
			},
		});
	})
})

$(document).ready(function(){
	 $(".buttonSearch").click(function(){
		$.ajax({
			url: "tim_kho_hang", 
			type: "GET",
			dataType: 'json',
			data: {
				ten_muc_san_pham: $("#searchKhoHang").val(),
			},
			success: function(data) {
				load_muc_san_pham(data);
			},
			error:  function() {
				alert("loi");
			},
		});
	});
});


let c = document.querySelectorAll('.cap_nhat_san_pham');
c.forEach(item => {
	item.addEventListener('click', e =>{
		let gia = item.parentElement.parentElement.childNodes[9].childNodes[0].value;
		let so_luong = item.parentElement.parentElement.childNodes[11].childNodes[0].value;
		let id = item.childNodes[1].value;
		//alert(so_luong);
		//alert(gia);
		//alert(id);
		$.ajax({
			url: "sua_muc_san_pham", 
			type: "POST",
			dataType: 'json',
			data: {
				id_muc_san_pham : id,
				so_luong_san_pham: so_luong,
				gia_san_pham: gia
			},
			success: function(data) {
				load_muc_san_pham(data);
			},
			error:  function() {
				alert("loi");
			},
		});
	})
})
let listTien = document.querySelectorAll('.giaDonHang');
listTien.forEach(item => {
	item.innerText = parseInt(item.textContent).toLocaleString('vi-VN') + " VNĐ"
})
let listTienSanPham = document.querySelectorAll('.giaTienSanPham');
listTienSanPham.forEach(item => {
	item.innerText = parseInt(item.textContent).toLocaleString('vi-VN') + " VNĐ"
})

let btnList = document.querySelectorAll('.btnStatus');
btnList.forEach(item=>{
	if(item.textContent == "Đã nhận được đơn hàng"){
	item.classList.add('btn-success');
}
else if(item.textContent == "Đang vận chuyển"){
	item.classList.add('btn-primary');
}
else if(item.textContent == "Đợi xác nhận đơn hàng"){
	item.classList.add('btn-warning');
}
else{
	item.classList.add('btn-danger');
}
})
function load_muc_san_pham(data){
	let chuoi = "";
	data.forEach(function(item) {
		chuoi += '<tr class="muc_san_pham">' +
			'<td><img ' +
			'src="'+item.anh_chi_tiet+'" ' +
			'width="50px" alt=""></td>' +
			'<td>'+item.ten_san_pham+'</td>' +
			'<td>'+item.kich_thuoc_san_pham.ten_size+'</td>' +
			'<td>'+item.mau_sac_san_pham.ten_mau+'</td>' +
			'<td><input value="'+item.so_luong_trong_kho+'"></td>' +
			'<td><input value="'+item.gia_tien+'"></td>' +
			'<td><button class="cap_nhat_san_pham" >' +
			'<input value="'+item.so_luong_trong_kho+'" type="hidden">' +
			'<input value="'+item.gia_tien+'" type="hidden">' +
			'<input value="'+item.id_muc_san_pham+'" type="hidden">' +
			'Cập nhật</button></td>' +
			'</tr>';
	});

	$(".Muc_sp").html(chuoi);
	
	let c = document.querySelectorAll('.cap_nhat_san_pham');
	c.forEach(item => {
		item.addEventListener('click', e => {
			let gia = item.parentElement.parentElement.childNodes[4].childNodes[0].value;
			let so_luong = item.parentElement.parentElement.childNodes[5].childNodes[0].value;
			let id = item.childNodes[2].value;
			$.ajax({
				url: "sua_muc_san_pham",
				type: "POST",
				dataType: 'json',
				data: {
					id_muc_san_pham : id,
					so_luong_san_pham: so_luong,
					gia_san_pham: gia
				},
				success: function(data) {
					load_muc_san_pham(data);
				},
				error: function() {
					alert("loi");
				},
			});
		})
	})
}