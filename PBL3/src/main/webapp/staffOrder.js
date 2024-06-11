let a = document.querySelectorAll('.huy_don_hang');
a.forEach(item => {
	item.addEventListener('click', e => {
		const inputValue = item.childNodes[0].value;
		alert(inputValue);
		$.ajax({
			url: "nhan_vien_huy_don",
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang: inputValue,
				id_nhan_vien: $('#id_nhan_vien').val(),
				trang_thai_don_hang: "huy"
			},
			success: function(data) {
				load_ajax_don_hoang()
			},
			error: function() {
				alert("loi");
			},
		});
	})
})
let b = document.querySelectorAll('.status-waiting');
b.forEach(item => {
	item.addEventListener('click', e => {
		const inputValue = item.childNodes[0].value;
		$.ajax({
			url: "nhan_vien_xac_nhan_don",
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang: inputValue,
				id_nhan_vien: $('#id_nhan_vien').val(),
				trang_thai_don_hang: "xac_nhan"
			},
			success: function(data) {
				load_ajax_don_hoang();
			},
			error: function() {
				alert("loi");
			},
		});
	})
})
function buttonHuy() {
	let a = document.querySelectorAll('.huy_don_hang');
	a.forEach(item => {
		item.addEventListener('click', e => {
			const inputValue = item.childNodes[0].value;
			alert(inputValue);
			$.ajax({
				url: "nhan_vien_huy_don",
				type: "POST",
				dataType: 'json',
				data: {
					id_don_hang: inputValue,
					id_nhan_vien: $('#id_nhan_vien').val(),
					trang_thai_don_hang: "huy"
				},
				success: function(data) {
					load_ajax_don_hoang()
				},
				error: function() {
					alert("loi");
				},
			});
		})
	})
}

function buttonXacNhan() {
	let b = document.querySelectorAll('.status-waiting');
	b.forEach(item => {
		item.addEventListener('click', e => {
			const inputValue = item.childNodes[0].value;
			$.ajax({
				url: "nhan_vien_xac_nhan_don",
				type: "POST",
				dataType: 'json',
				data: {
					id_don_hang: inputValue,
					id_nhan_vien: $('#id_nhan_vien').val(),
					trang_thai_don_hang: "xac_nhan"
				},
				success: function(data) {
					load_ajax_don_hoang();
				},
				error: function() {
					alert("loi");
				},
			});
		})
	})
}


function load_ajax_don_hoang(){
	$.ajax({
		url: "load_don_hang_ajax",
		type: "GET",
		dataType: 'json',
		data: {
		},

		success: function(data) {
			load_don_hang(data)
		}
	});
}

function load_don_hang(data){
	let chuoi = "";
	data.forEach(function(item) {

		chuoi += '<tr>' +
			'<th scope="row">'+item.id_don_hang+'</th>' +
			'<td>' +
			'<div class="d-flex justify-content-between">' +
			'<span>'+item.tong_tien+'</span> <span><b>VND</b></span>' +
			'</div>' +
			'</td>' +
			'<td>'+item.ten_khach_hang+'</td>' +
			'<td>'+item.thoi_gian_dat+'</td>' +
			'<td>' +
			'<button class="status status-waiting"><input type="hidden" value="'+item.id_don_hang+'">Chờ xác nhận</button>' +
			'</td>' +
			'<td>' +
			'<form action="xem_don_hang_chi_tiet" method="get">' +
			'<input type="hidden" name="id_don_hang" value="'+item.id_don_hang+'">' +
			'<button class="xem_chi_tiet">Xem chi tiết</button>' +
			'</form>' +
			'</td>' +
			'<td>' +
			'<button class="huy_don_hang"><input class="vale" type="hidden" value="'+item.id_don_hang+'">Hủy đơn hàng</button>' +
			'</td>' +
			'</tr>';
	});

	$(".don_hang").html(chuoi);
	
	buttonXacNhan();
	buttonHuy();
}

