$(document).ready(function(){
		 $("#button_add_product").click(function(){
				let data = [];
				
				const images = document.querySelectorAll('#div_anh img');

				let imageSrc = [];
				images.forEach((image) => {
					imageSrc.push(image.src.split(",")[1])
				});
				 
				console.log(imageSrc);
				
				console.log(JSON.stringify(imageSrc));
						
				data.push({
					id_danh_muc: 	$("#Danh_muc").val(),
					ten_mat_hang: 	$("#ten_mat_hang").val(),
					mo_ta: 			$("#mo_ta").val(),
					thong_tin_chi_tiet: $("#thong_tin_chi_tiet").val(),
					thuong_hieu: 	$("#thuong_hieu").val(),
					chat_lieu: 		$("#chat_lieu").val(),
					images: 		imageSrc
				});
						
				$.ajax({
				      url: "add_product", // URL of your Servlet
				      type: "POST",
				      dataType: 'json',
				      data: 
							/*id_danh_muc: 	$("#Danh_muc").val(),
							ten_mat_hang: 	$("#ten_mat_hang").val(),
							mo_ta: 			$("#mo_ta").val(),
							thong_tin_chi_tiet: $("#thong_tin_chi_tiet").val(),
							thuong_hieu: 	$("#thuong_hieu").val(),
							chat_lieu: 		$("#chat_lieu").val(),*/
							 JSON.stringify(data),
					 
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

$(document).ready(function(){
	 $("#Doi_tuong_khach_hang").change(function(){
			$.ajax({
			      url: "load_category", // URL of your Servlet
			      type: "POST",
			      dataType: 'json',
			      data: {
						danh_muc: $("#Doi_tuong_khach_hang").val()
				  },
			      success: function(data) {
				    	let chuoi = "";
				    	data.forEach(function(item){
				    		chuoi += '<Option value="'+item.id+'">'+item.category+'</Option>';
				    	})
				    	  
				    	$("#Loai_san_pham").html(chuoi);
			      }
		   });
	});
});


$(document).ready(function(){
	 $("#Loai_san_pham").change(function(){
		$.ajax({
	      url: "load_category", // URL of your Servlet
	      type: "POST",
	      dataType: 'json',
	      data: {
			danh_muc: $("#Loai_san_pham").val()
		  },
	      success: function(data) {
	    	  let chuoi = "";
	    	  data.forEach(function(item){
	    		  chuoi += '<Option value="'+item.id+'">'+item.category+'</Option>';
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
   
    
function addItem(i) {
        const list = document.getElementById(i);
        const newItem = document.createElement("div");
        const newInput = document.createElement("input");
        const newButton = document.createElement("button");
        newButton.textContent = "X";
        newButton.className = "deleteItem";
        let j = "#"+i;
        newButton.onclick = removeItem(j);
        newItem.appendChild(newInput);
        newItem.appendChild(newButton);
        newItem.className = "inputSize";
        list.appendChild(newItem);
    }
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
    function acceptChange(i,j){
        const btn = document.getElementsByClassName(i);
        const form = document.querySelector(j);
        if(form.style.display == "none"){
            btn.textContent = "Hoàn tất";
            form.style.display = "block";
        }
        else{	
            btn.textContent = "Chỉnh sửa";
            form.style.display = "none";
        }
    }
    function removeItem(i){
        const list = document.querySelector(i);
        list.addEventListener("click", function(event) {
        if (event.target.tagName === "BUTTON") {
            list.removeChild(event.target.parentNode);
        }
    });
    }
    let count = 0;
    function createTable(){
        const optionSize = document.getElementById('itemListSize');
        const optionColor = document.getElementById('itemListMau_sac');
        console.log(optionColor);
		const selectedOptionSize = optionSize.options[optionSize.selectedIndex];
		const selectedOptionColor = optionColor.options[optionColor.selectedIndex];		
        let table = document.getElementById('myTable');
        count=count+1;
        var newRow = table.insertRow();
        var stt = newRow.insertCell();
        stt.innerHTML = count;
        var name = newRow.insertCell();
        name.innerHTML = selectedOptionSize.value +"  "+ selectedOptionColor.value;
        var input = newRow.insertCell();
        input.innerHTML = `<input type = "text" >`;
        var img = newRow.insertCell();
        img.innerHTML = `
        <div class = "item-images item-images${count}">
        <input onchange="addImageItems(this)" style="display: none;" type="file" id="imageInput${count}" name="file" multiple/>
                               	<label for="imageInput${count}">
                               	<i class="fa-solid fa-plus"></i>
      		 </label>
		</div>`;
/*            const imageContainer = document
            .querySelector(`.item-images${count}`)
            .querySelector('#imageInput').addEventListener('change', (e) => {
				addImageItems(e.target)
			});  */
      }
    
    
function previewImageElement(button){
	const parentImage = button.parentElement.querySelector('img');
    if (!parentImage) {
        console.error('No image found in button parent.');
        return;
    }
    let overlay = document.createElement('div');
    overlay.className="overlay";
    
    imgPreview = document.createElement('img');
    imgPreview.src = parentImage.src;
    
    overlay.appendChild(imgPreview);
    overlay.addEventListener('click', ()=>{
		overlay.remove();
	})
    document.body.appendChild(overlay);
}

function removeIMG(btnXoa){
	btnXoa.parentElement.remove();
}

