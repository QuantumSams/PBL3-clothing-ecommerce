package Control;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.AbstractDao;
import Entity.Nguoi_Dung.Khach_hang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(name = "Infor", urlPatterns = {"/infor"})

@MultipartConfig(
		fileSizeThreshold = 512 * 512 * 10,
		maxFileSize = 1024 *  1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)

public class modifyInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String phoneNumber =  request.getParameter("phone");
		String address = request.getParameter("address");
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String image = request.getParameter("image");
		
		//Đường dẫn ảnh
		String path = "D:\\Language Program\\Java_web\\PBL3-clothing-ecommerce\\PBL3\\src\\main\\webapp\\img\\anh_nguoi_dung\\";
		Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String imagePath = "img/anh_nguoi_dung/" + fileName;
        
		HttpSession session = request.getSession();
		System.out.println(image);
		// thay doi account thanh nguoi_dung
		Khach_hang acc = (Khach_hang)session.getAttribute("acc");
		acc.setSo_dien_thoai(phoneNumber);
		acc.setDia_chi(address);
		acc.setHo_ten(fullName);
		acc.setEmail(email);
		acc.setAnh_dai_dien(imagePath);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng chuỗi ngày tháng
        try {
			acc.setNgay_sinh(new Date(formatter.parse(birth).getTime()));
		} catch (ParseException e) {
			System.out.println("khong chuyen duoc sang Date");
		}
		try {
			String sql1 = "UPDATE thong_tin_dang_nhap SET so_dien_thoai = ?, email = ? WHERE id = ?;";
			String sql2 = "UPDATE thong_tin_nguoi_dung SET ho_ten = ?, gioi_tinh = ?, ngay_sinh = ?, dia_chi = ?, anh_dai_dien = ? WHERE id = ?;";
			
			new AbstractDao().update(sql1, acc.getSo_dien_thoai(), acc.getEmail(), acc.getId_nguoi_dung());
			new AbstractDao().update(sql2, acc.getHo_ten(), acc.isGioi_tinh(), acc.getNgay_sinh(), acc.getDia_chi() , acc.getAnh_dai_dien(), acc.getId_nguoi_dung());
		
	        for(Part part : request.getParts()) {
	        	part.write(path + fileName);
	        	// sử dụng đường dẫn tương đối vì không bt làm sao để dùng đường dẫn tương đối
	        }
	        System.out.println("Cập nhật thành công");
	        
		} catch (Exception e) {
			System.out.println("Khong the cap nhat tai khona nguoi dung");
		}
		
		session.setAttribute("acc",acc);
		
		request.getRequestDispatcher("userInfor.jsp").forward(request, response);
	}

}
