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
	    		  			'<form action="chinh_sua_san_pham" method="get">'+
	    		  			'<td><img src='+item.anh_san_pham[0]+' width="50px" alt=""></td>' +
	    		  			'<td>'+item.ten_san_pham+'</td>'+
	    		  			'<td>'+item.ten_san_pham+'</td>'+
	    		  			'<td>'+item.gia_tien +' VNĐ</td>'+
	                        '<td>Nam</td>' +
	                        '<td>'+item.danh_muc_san_pham+'</td>'+
	                        '<td>'+item.ten_nhan_hang+'</td>'+
	                        '<td><button class = "buttonSearch">Chi tiết</button></td>'+
	                        '<td><button class = "buttonSearch">Xóa</button></td>'+
	                        '<input type="hidden" name="id_san_pham" value="'+item.id_san_pham+'">'+
	                        '</form>'+
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
	    		  chuoi += 	'<tr><td><img src="'+item.anh_dai_dien+'" width="50px" alt=""></td>'
	                        +'<td>'+item.ho_ten+'</td>'
	                        +'<td><c:if test="'+(item.gioi_tinh == true)+'">Nam</c:if>'
							+'<c:if test="'+(item.gioi_tinh != true)+'">Nữ</c:if></td>'
							+'<td>'+item.so_dien_thoai+'</td>'
							+'<td><button class = "buttonSearch">Chi tiết</button></td></tr>'
	    	  });
			
			$("#nhan_vien").html(chuoi);
	      },
	      
	   });
	});
});