let a = document.querySelectorAll('.btnColor');
let o = document.querySelectorAll('.btnSize');

let list_id_mau = document.querySelectorAll('.id_mau_sac_duyet');
let list_id_size = document.querySelectorAll('.id_size_duyet');
let list_muc = document.querySelectorAll('.id_muc_duyet');
let list_gia = document.querySelectorAll('.gia_san_pham');
let list_soluong = document.querySelectorAll('.so_luong_san_pham');
let mausac = document.querySelectorAll('.mausac');
let kichco = document.querySelectorAll('.kichco');

const map1 = new Map();
const mau = new Array();


document.querySelector('#giaTien').innerText = parseInt(document.querySelector('#giaTien').innerText).toLocaleString('vi-VN') + " VNĐ"


a.forEach(item => {
	item.addEventListener('click', e=>{
		o.forEach(u =>{
			u.disabled = true;
		})
		if(item.classList.contains('selected')){
			item.classList.remove('selected');
		}
		else{
			let b = document.querySelector('.selected');
			let c = document.querySelector('.selected1');
		
		if(c == null){
			
		}
		else{
			c.classList.remove('selected1');
		}
		
		if(b == null){
			
		}
		else{
			b.classList.remove('selected');
		}
		item.classList.add('selected');
		mau.length = 0;
		for(let i = 0; i<list_id_mau.length; ++i){
			if(item.childNodes[3].value == list_id_mau[i].value){
				mau.push(list_id_size[i]);
			}
		}
		mau.forEach(q => {
			for(let i =0; i<o.length; ++i){
				if(q.value == o[i].childNodes[1].value){
					o[i].disabled = false;
				}
			}
		})
		
		/*if(c != null && b!= null){
			for(let i = 0; i<list_id_mau.length; ++i){
				if(b.childNodes[3].value == list_id_mau[i].value && c.childNodes[1].value == list_id_size[i].value){
					document.querySelector('.tonKho').innerText = "Kho: " + list_soluong[i].value; 
				}
			}
		}*/
		document.querySelector('#labelColor').innerHTML = 'Màu sắc: ' + item.childNodes[1].innerText;
		document.querySelector('.resultColor').value = item.childNodes[3].value;
		}
		
		})
});
o.forEach(item => {
	item.addEventListener('click', e=>{
		if(item.classList.contains('selected1')){
			item.classList.remove('selected1');
		}
		else{
			
		let b = document.querySelector('.selected');
		item.classList.add('selected1');
		
		if(b!= null){
			for(let i = 0; i<list_id_mau.length; ++i){
				if(b.childNodes[3].value == list_id_mau[i].value && item.childNodes[1].value == list_id_size[i].value){
					document.querySelector('.tonKho').innerText = "Kho: " + list_soluong[i].value; 
					document.querySelector('#giaTien').innerText = parseInt(list_gia[i].value).toLocaleString('vi-VN') + " VNĐ"; 
					document.querySelector('.so_luong').max = list_soluong[i].value;
				}
			}
		}
		setSL();
		document.querySelector('#labelSize').innerHTML = 'Kích cỡ: ' + item.innerText;
		document.querySelector('.resultSize').value = item.childNodes[1].value;
		}
		
		})
});
function setSL(){
	let a = document.querySelector('.so_luong')
	if(document.querySelector('.tonKho').innerText.split(" ",2)[1] == 0){
		a.disabled = true;
	}
	else{
		a.disabled = false;
	}
}
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