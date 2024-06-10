$(document).ready(function() {
	$("#button_add_product").click(function() {

		let sizeValues = [];
		let colorValues = [];
		let giaValues = [];
		let imageValues = [];

		let list = document.querySelectorAll('.size_table');
		list.forEach(item => {
			sizeValues.push(item.value);
		});

		let list1 = document.querySelectorAll('.color_table');
		list1.forEach(item => {
			colorValues.push(item.value);
		});

		let list2 = document.querySelectorAll('.gia');
		list2.forEach(item => {
			giaValues.push(item.value);
		});

		let list3 = document.querySelectorAll('#myTable img')
		list3.forEach((image) => {
			imageValues.push(image.src.split(",")[1])
		});


		let data = [];

		const images = document.querySelectorAll('#div_anh img');
		let imageSrc = [];
		images.forEach((image) => {
			imageSrc.push(image.src.split(",")[1])
		});
		
		$.ajax({
			url: "add_product", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				id_danh_muc: $("#Danh_muc").val(),
				ten_mat_hang: $("#ten_mat_hang").val(),
				mo_ta: $("#mo_ta").val(),
				thong_tin_chi_tiet: $("#thong_tin_chi_tiet").val(),
				thuong_hieu: $("#thuong_hieu").val(),
				chat_lieu: $("#chat_lieu").val(),
				images: JSON.stringify(imageSrc),
				size: JSON.stringify(sizeValues),
				color: JSON.stringify(colorValues),
				gia: JSON.stringify(giaValues),
				image_muc: JSON.stringify(imageValues)
			},

			success: function(data) {
				//alert("Thêm sản phẩm thành công!");
			}
		});
	});
});

function uploadImages() {
	const divId = 'div_anh';
	const images = document.getElementById(divId).querySelectorAll('img');
	const formData = new FormData();

	// Check if there are images
	if (images.length === 0) {
		console.error('No images found in the card');
		return;
	}

	// Loop through all IMG tags and create FormData entries from their src attribute (assuming they point to local files)
	for (const image of images) {
		const file = new File([/* File content (optional) */], image.src, { type: image.dataset.type || 'image/jpeg' }); // Set appropriate type if available in data-type attribute
		formData.append('images[]', file);
	}

	// Send data using AJAX
	const xhr = new XMLHttpRequest();
	xhr.open('POST', '/add_image');
	xhr.onload = function() {
		if (xhr.status === 200) {
			const response = JSON.parse(xhr.responseText);
			console.log(response);
		} else {
			console.error('Error uploading images:', xhr.statusText);
		}
	};
	xhr.send(formData);
}

$(document).ready(function() {
	$("#Doi_tuong_khach_hang").change(function() {
		$.ajax({
			url: "load_category", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				danh_muc: $("#Doi_tuong_khach_hang").val()
			},
			success: function(data) {
				let chuoi = "";
				data.forEach(function(item) {
					chuoi += '<Option value="' + item.id + '">' + item.category + '</Option>';
				})

				$("#Loai_san_pham").html(chuoi);
			}
		});
	});
});


$(document).ready(function() {
	$("#Loai_san_pham").change(function() {
		$.ajax({
			url: "load_category", // URL of your Servlet
			type: "POST",
			dataType: 'json',
			data: {
				danh_muc: $("#Loai_san_pham").val()
			},
			success: function(data) {
				let chuoi = "";
				data.forEach(function(item) {
					chuoi += '<Option value="' + item.id + '">' + item.category + '</Option>';
				})

				$("#Danh_muc").html(chuoi);
			}
		});
	});
});

const imageUpload = document.getElementById('image-upload');
const previewImage = document.getElementById('preview-image');
const container = document.querySelector(".upload-container");

container.querySelector('#fileInput').addEventListener('change', (e) => {
	addImage(e.target)
});

let btnColor = document.querySelectorAll('.btnColor');
btnColor.forEach(item =>{
	item.addEventListener('click',e=>{
		if(item.classList.contains('selected')){
			item.classList.remove('selected');
		}
		else{
			let b = document.querySelector('.selected');
			if(b == null){
				
			}
			else{
				b.classList.remove('selected');
				
			}
			item.classList.add('selected');
		}

	})
})



	let btnSize = document.querySelectorAll('.btnSize');

btnSize.forEach(item =>{
	item.addEventListener('click',e=>{
		if(item.classList.contains('selected1')){
			item.classList.remove('selected1');
		}
		else{
			let c = document.querySelector('.selected1');
			if(c == null){
				
			}
			else{
				c.classList.remove('selected1');
			}
			item.classList.add('selected1');
		}
	})
})




function addImage(input) {
	const file = input.files[0];
	if (file) {
		const reader = new FileReader();
		reader.onloadend = function(e) {
			let imgElement = document.createElement('div');
			imgElement.className = "img_element";
			imgElement.innerHTML = `
				<img src="${reader.result}">
				<div class="btnXoa" onclick="removeIMG(this)">
					<i class="fa-solid fa-x"></i>
				</div>		
				<div class="btnPreview" onclick="previewImageElement(this)">
					<i class="fa-solid fa-search"></i>
				</div>		
			`
			document.querySelector('#div_anh').appendChild(imgElement);
		};
		reader.readAsDataURL(file);
	}
}
function addColorImage(input) {
	const file = input.files[0];
	if (file) {
		const reader = new FileReader();
		reader.onloadend = function(e) {
			let imgElement = document.createElement('div');
			imgElement.className = "img_element";
			imgElement.innerHTML = `
				<img src="${reader.result}">
				<div class="btnXoa" onclick="removeIMG(this)">
					<i class="fa-solid fa-x"></i>
				</div>		
				<div class="btnPreview" onclick="previewImageElement(this)">
					<i class="fa-solid fa-search"></i>
				</div>		
			`
			document.querySelector('.popup').appendChild(imgElement);
		};
		reader.readAsDataURL(file);
	}
}
function addImageItems(linput) {
	const file = linput.files[0];
	if (file) {
		const reader = new FileReader();
		reader.onloadend = function(e) {
			let imgElement = document.createElement('div');
			imgElement.className = "img_element";
			imgElement.innerHTML = `
				<img src="${reader.result}" style = "width : 80px">
				<div class="btnXoa" onclick="removeIMG(this)">
					<i class="fa-solid fa-x"></i>
				</div>		
				<div class="btnPreview" onclick="previewImageElement(this)">
					<i class="fa-solid fa-search"></i>
				</div>		
			`
			linput.parentElement.appendChild(imgElement);
		};
		reader.readAsDataURL(file);
	}
}
function openPopupColor(){
	let overlay = document.createElement('div');
	overlay.className = "overlay";
	let form = document.createElement('div');
	form.className = "popup";
	
	let name  = document.createElement('input');
	name.className = "nameColor";
	let buttonExit = document.createElement('button');
	let buttonDone = document.createElement('button');
	let buttonImage = document.createElement('input');
	let label = document.createElement('label');	
	let icon = document.createElement('i');
	icon.className = "fa-solid fa-plus";
	label.appendChild(icon);
	/*	<input onchange="addImageItems(this)" style="display: none;" type="file" id="imageInput${count}" name="file" multiple/>*/
	buttonImage.type = "file"
	buttonImage.name = "file"
	buttonImage.setAttribute('id', "idImage");
	buttonImage.multiple = true;
	buttonImage.hidden = true;
	buttonImage.textContent = "Thêm ảnh";
	label.setAttribute('for', "idImage" );
	buttonImage.addEventListener('change', e=>{
		addColorImage(e.target);
	})
	buttonExit.textContent ="Thoát";
	buttonDone.textContent = "Hoàn thành"
	form.appendChild(name);
	form.appendChild(buttonDone);
	form.appendChild(buttonExit);
	form.appendChild(buttonImage);
	form.appendChild(label);
	overlay.appendChild(form);
	buttonExit.addEventListener('click', () => {
		overlay.remove();
	});
	buttonDone.addEventListener('click', ()=>{
		let buttonAdd =  document.createElement('button');
		buttonAdd.textContent = document.querySelector('.nameColor').value;
		if(buttonAdd.textContent.trim == ""){
			alert("Chưa nhập gì cả");
			overlay.remove();
		}
		/*buttonAdd.className = "btnColor";
		document.querySelector('.color').childNodes[1].childNodes[5].appendChild(buttonAdd);*/
		overlay.remove();
	})
	document.body.appendChild(overlay);
}
function themDoituong(){
	let overlay = document.createElement('div');
	overlay.className = "overlay";
	let form = document.createElement('div');
	form.className = "popup";
	
	let name  = document.createElement('input');
	name.className = "name";
	let buttonExit = document.createElement('button');
	let buttonDone = document.createElement('button');
	buttonExit.textContent ="Thoát";
	buttonDone.textContent = "Hoàn thành"
	form.appendChild(name);
	form.appendChild(buttonDone);
	form.appendChild(buttonExit);
	
	overlay.appendChild(form);
	buttonExit.addEventListener('click', () => {
		overlay.remove();
	});
	buttonDone.addEventListener('click', ()=>{
		let newOption =  document.createElement('option');
		newOption.textContent = document.querySelector('.name').value;
		if(newOption.textContent.trim == ""){
			alert("Chưa nhập gì cả");
			overlay.remove();
		}
		document.querySelector('#Doi_tuong_khach_hang').appendChild(newOption)
		overlay.remove();
	})
	document.body.appendChild(overlay);
}
function themLoaiSanPham(){
	let overlay = document.createElement('div');
	overlay.className = "overlay";
	let form = document.createElement('div');
	form.className = "popup";
	
	let name  = document.createElement('input');
	name.className = "name";
	let buttonExit = document.createElement('button');
	let buttonDone = document.createElement('button');
	
	buttonExit.textContent ="Thoát";
	buttonDone.textContent = "Hoàn thành"
	
	
	form.appendChild(name);
	form.appendChild(buttonDone);
	form.appendChild(buttonExit);
	
	overlay.appendChild(form);
	buttonExit.addEventListener('click', () => {
		overlay.remove();
	});
	buttonDone.addEventListener('click', ()=>{
		let newOption =  document.createElement('option');
		newOption.textContent = document.querySelector('.name').value;
		if(newOption.textContent.trim == ""){
			alert("Chưa nhập gì cả");
			overlay.remove();
		}
		document.querySelector('#Loai_san_pham').appendChild(newOption)
		overlay.remove();
	})
	document.body.appendChild(overlay);
}
function themDanhMuc(){
	let overlay = document.createElement('div');
	overlay.className = "overlay";
	let form = document.createElement('div');
	form.className = "popup";
	
	let name  = document.createElement('input');
	name.className = "name";
	let buttonExit = document.createElement('button');
	let buttonDone = document.createElement('button');
	buttonExit.textContent ="Thoát";
	buttonDone.textContent = "Hoàn thành"
	form.appendChild(name);
	form.appendChild(buttonDone);
	form.appendChild(buttonExit);
	
	overlay.appendChild(form);
	buttonExit.addEventListener('click', () => {
		overlay.remove();
	});
	buttonDone.addEventListener('click', ()=>{
		let newOption =  document.createElement('option');
		newOption.textContent = document.querySelector('.name').value;
		if(newOption.textContent.trim == ""){
			alert("Chưa nhập gì cả");
			overlay.remove();
		}
		document.querySelector('#Danh_muc').appendChild(newOption)
		overlay.remove();
	})
	document.body.appendChild(overlay);
}
function openPopupSize(){
	let overlay = document.createElement('div');
	overlay.className = "overlay";
	let form = document.createElement('div');
	form.className = "popup";
	
	let name  = document.createElement('input');
	name.className = "nameSize";
	let buttonExit = document.createElement('button');
	let buttonDone = document.createElement('button');
	buttonExit.textContent ="Thoát";
	buttonDone.textContent = "Hoàn thành"
	form.appendChild(name);
	form.appendChild(buttonDone);
	form.appendChild(buttonExit);
	
	overlay.appendChild(form);
	buttonExit.addEventListener('click', () => {
		overlay.remove();
	});
	buttonDone.addEventListener('click', ()=>{
		let buttonAdd =  document.createElement('button');
		let nameSize = document.createElement('div');
		let valueSize = document.createElement('input');
		let btnDelete = document.createElement('button');
		btnDelete.textContent = "X";
		
		
		if(document.querySelector('.nameSize').value.trim() == ""){
			alert("Chưa nhập gì cả");
		}
		else{
			buttonAdd.className = "btnSize";
			nameSize.innerHTML = document.querySelector('.nameSize').value;
			valueSize.value = document.querySelectorAll('.btnSize').length + 1;
			valueSize.className = "mausac";
			valueSize.type = "hidden";
			
			buttonAdd.appendChild(nameSize);
			buttonAdd.appendChild(valueSize);
			buttonAdd.appendChild(btnDelete);
			btnDelete.addEventListener('click', e=>{
				btnDelete.parentElement.remove();
			})
			buttonAdd.addEventListener('click',e=>{
		if(buttonAdd.classList.contains('selected1')){
			buttonAdd.classList.remove('selected1');
		}
		else{
			let b = document.querySelector('.selected1');
			if(b == null){
				
			}
			else{
				b.classList.remove('selected1');
				
			}
			buttonAdd.classList.add('selected1');
		}
		})
		document.querySelector('.sizeBtn').appendChild(buttonAdd);
		overlay.remove();
		}
		
	})
	document.body.appendChild(overlay);
}
function acceptChange(i, j) {
	const btn = document.getElementsByClassName(i);
	const form = document.querySelector(j);
	if (form.style.display == "none") {
		btn.textContent = "Hoàn tất";
		form.style.display = "block";
	}
	else {
		btn.textContent = "Chỉnh sửa";
		form.style.display = "none";
	}
}
function removeItem(i) {
	const list = document.querySelector(i);
	list.addEventListener("click", function(event) {
		if (event.target.tagName === "BUTTON") {
			list.removeChild(event.target.parentNode);
		}
	});
}

function createTable() {
	let colorInput = document.querySelector('.selected');
	let sizeInput = document.querySelector('.selected1');
	if(colorInput == null) return;
	if(sizeInput == null) return;
	const tableCheck = document.querySelector('#myTable');
	
	let table = document.getElementById('myTable');
	let count = tableCheck.rows.length + 1;
	for(let i = 0; i < count - 1; ++i){
		if(tableCheck.rows[i].cells[1].innerText == sizeInput.childNodes[0].innerHTML &&
		tableCheck.rows[i].cells[2].innerText == colorInput.childNodes[1].textContent){
			return;
		}
	}
	var newRow = table.insertRow();
	var stt = newRow.insertCell();
	var size = newRow.insertCell();
	
	stt.innerHTML = count;
	size.innerHTML = `<div>${sizeInput.childNodes[0].innerHTML}</div> 
	<input class = "size_table" type="hidden" value = ${sizeInput.childNodes[1].value}>`;
	var name = newRow.insertCell();

	name.value = count;
	name.innerHTML = `<div>${colorInput.childNodes[1].textContent}</div> 
	<input  class = "color_table" type="hidden" value = "${colorInput.childNodes[3].value}">`;
	var input = newRow.insertCell();
	input.innerHTML = `<input type = "text" class = "gia">`;
	var img = newRow.insertCell();
	img.innerHTML = `
        <div class = "item-images item-images${count}">
        <input onchange="addImageItems(this)" style="display: none;" type="file" id="imageInput${count}" name="file" multiple/>
                               	<label for="imageInput${count}">
                               	<i class="fa-solid fa-plus"></i>
      		 </label>
		</div>`;
	var xoa = newRow.insertCell();
	xoa.innerHTML = `<button class = "xoaRow" onclick = "deleteRow(this)">Xoá</button>`
	colorInput.classList.remove('selected');
	sizeInput.classList.remove('selected1');	
}
function deleteRow(r) {
  var i = r.parentNode.parentNode.rowIndex;
  document.getElementById('myTable'	).deleteRow(i-1	);
}

function previewImageElement(button) {
	const parentImage = button.parentElement.querySelector('img');
	if (!parentImage) {
		console.error('No image found in button parent.');
		return;
	}
	let overlay = document.createElement('div');
	overlay.className = "overlay";

	imgPreview = document.createElement('img');
	imgPreview.src = parentImage.src;

	overlay.appendChild(imgPreview);
	overlay.addEventListener('click', () => {
		overlay.remove();
	})
	document.body.appendChild(overlay);
}

function removeIMG(btnXoa) {
	btnXoa.parentElement.remove();
}

