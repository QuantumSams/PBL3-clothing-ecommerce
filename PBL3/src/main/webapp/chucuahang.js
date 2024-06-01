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
    const xValues = ["Nam", "Nữ", "Trẻ em", "Người già", "Trẻ sơ sinh"];
    const yValues = [55, 49, 44, 24, 25];
    const barColors = ["#667085", "#667085","#667085","#667085","#667085"];

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
		$.ajax({
	      url: "get_product_by_ajax", // URL of your Servlet
	      type: "GET",
	      dataType: 'json',
	      data: {
			product_name: $("#search").val()
		  },
	      success: function(data) {
			let chuoi = "";
	    	  data.forEach(function(item){
	    		  chuoi += 	'<tr>'+

	    		  			'<td><img src='+item.anh_san_pham[0]+' width="50px" alt=""></td>' +
	    		  			'<td>'+item.ten_san_pham+'</td>'+
	    		  			'<td>'+item.ten_san_pham+'</td>'+
	    		  			'<td>'+item.gia_tien +' VNĐ</td>'+
	                        '<td>Nam</td>' +
	                        '<td>'+item.danh_muc_san_pham+'</td>'+
	                        '<td>'+item.ten_nhan_hang+'</td>'+
	                        '<td>'+
	                        '<form action="chinh_sua_san_pham" method="get">'+
	    		  				'<button class = "buttonSearch">Chi tiết</button>'+
	    		  				'<input type="hidden" name="id_san_pham" value="'+item.id_san_pham+'">'+
	                        '</form>'+
	                        '</td>'+
	                        '<td><button class="buttonRemove"><input type="hidden" value="'+item.id_san_pham+'">Xóa</button></td>'+
	                        '</tr>';
	               
	    	  });
			
			$("#san_pham").html(chuoi);
	      },
	      
	   });
	});
});


$(document).ready(function(){
	 $("#button_search_nhan_vien").click(function(){
		$.ajax({
	      url: "load_nhan_vien_by_json", // URL of your Servlet
	      type: "GET",
	      dataType: 'json',
	      data: {
			name_nhan_vien: $("#search_nhan_vien").val()
		  },
	      success: function(data) {
			let chuoi = "";
	    	  data.forEach(function(item){
				  chuoi += '<tr>'+
					  		'<td><img src="'+item.anh_dai_dien+'" width="50px" alt=""></td>'+
					  		'<td>'+item.ho_ten+'</td>'+
					  		'<td><c: if test="'+item.gioi_tinh+' == true}">'+
						  		'Nam'+
					  		'</c: if>'+
					  		'<c: if test="'+item.gioi_tinh+' != true}">'+
							 	'Nữ'+
						  	'</c: if></td>'+
					  		'<td>'+item.so_dien_thoai+'</td>'+
					  		'<td>'+
					  		'<form action="thong_tin_nhan_vien" method="get">'+
						  		'<input type="hidden" name="id" value="'+item.id_nguoi_dung+'"/>'+
							  	'<button class="buttonSearch">Chi tiết</button>'+
					  		'</form>'+
					  		'</td>'+
					  		'<td>'+
					  		'<button class="buttonRemoveNV"><input type="hidden" name="id" value="'+item.id_nguoi_dung+'">Xóa</button>'+
					  		'</td>'+
				  			'</tr>'
	    	  });
			
			$("#nhan_vien").html(chuoi);
	      },
	      
	   });
	});
});


let a = document.querySelectorAll('.buttonRemove');
a.forEach(item => {
	item.addEventListener('click', e =>{
		const inputValue = item.childNodes[0].value;
		$.ajax({
			url: "remove_product", 
			type: "POST",
			dataType: 'json',
			data: {
				id_san_pham : inputValue,
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
				alert(data);
			},
			error:  function() {
				alert("loi");
			},
		});
	})
})