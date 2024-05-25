let a = document.querySelectorAll('.btnColor');
let o = document.querySelectorAll('.btnSize');

let list_id_mau = document.querySelectorAll('.id_mau_sac_duyet');
let list_id_size = document.querySelectorAll('.id_size_duyet');
let list_muc = document.querySelectorAll('.id_muc_duyet');

a.forEach(item => {
	item.addEventListener('click', e=>{
		let b = document.querySelector('.selected');
		if(b == null){
		
		}
		else{
			b.classList.remove('selected');
		}
		item.classList.add('selected');
		document.querySelector('#labelColor').innerHTML = 'Màu sắc: ' + item.childNodes[1].innerText;
		document.querySelector('.resultColor').value = item.childNodes[3].value;
		})
});
o.forEach(item => {
	item.addEventListener('click', e=>{
		let b = document.querySelector('.selected1');
		if(b == null){
		}
		else{
			b.classList.remove('selected1');
		}
		item.classList.add('selected1');
		document.querySelector('#labelSize').innerHTML = 'Kích cỡ: ' + item.innerText;
		document.querySelector('.resultSize').value = item.childNodes[1].value;
		})
		
});
	
$(document).ready(function() {
	$(".cart").click(function() {
		
		let id_mau = $(".resultColor").val();
		let id_size = $(".resultSize").val();
		let id_muc;
		for(let i = 0; i < list_muc.length; ++i){
			console.log(list_id_mau[i].value == id_mau && list_id_size[i].value == id_size);
			if(list_id_mau[i].value == id_mau && list_id_size[i].value == id_size){
				id_muc = list_muc[i].value;
				console.log(list_muc[i].value);
			
				break;
			}
		}
		
		$.ajax({
			url: "them_gio_hang", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				id_khach_hang: $(".id_nguoi_dung").val(),
				id_mau_sac: $(".resultColor").val(),
				id_size: $(".resultSize").val(),
				so_luong: $(".so_luong").val(),
				id_muc_san_pham: id_muc,
				
			},

			success: function(data) {
				alert(data);
			}
			
		});
	});

});