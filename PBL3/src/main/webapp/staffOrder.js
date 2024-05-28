let a = document.querySelectorAll('.huy_don_hang');
a.forEach(item => {
	item.addEventListener('click', e =>{
		const inputValue = item.childNodes[0].value;
		const id_nhan_vien = document.querySelector('#id_nhan_vien').value;
		$.ajax({
			url: "nhan_vien_huy_don", 
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang : inputValue,
				id_nhan_vien: id_nhan_vien,
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

let b = document.querySelectorAll('.status-waiting');
b.forEach(item => {
	item.addEventListener('click', e =>{
		const inputValue = item.childNodes[0].value;
		const id_nhan_vien = document.querySelector('#id_nhan_vien').value;
		$.ajax({
			url: "nhan_vien_xac_nhan_don", 
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang : inputValue,
				id_nhan_vien: id_nhan_vien,
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

/*$(document).ready(function() {
	$(".status status-waiting").click(function() {

		const buttonElement = document.querySelector('.status status-waiting');
		const inputElement = buttonElement.querySelector('input');
		const inputValue = inputElement.value;
		
		$.ajax({
			url: "nhan_vien_xac_nhan_don", 
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang : inputValue,
				id_nhan_vien: $("#id_nhan_vien")
			},

			success: function(data) {
				alert(data);
			}
		});
	});
});

$(document).ready(function() {
	$(".status status-waiting").click(function() {

		const buttonElement = document.querySelector('.status status-waiting');
		const inputElement = buttonElement.querySelector('input');
		const inputValue = inputElement.value;
		
		$.ajax({
			url: "nhan_vien_xac_nhan_don", 
			type: "POST",
			dataType: 'json',
			data: {
				id_don_hang : inputValue,
				id_nhan_vien: $("#id_nhan_vien")
			},

			success: function(data) {
				alert(data);
			}
		});
	});
});*/
