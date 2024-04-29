package Control;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import DAO.AbstractDao;
import DAO.implemet.Nguoi_dung_DAO;
import Entity.Nguoi_Dung.Khach_hang;
import Entity.Nguoi_Dung.Nguoi_dung;
import Service.Nguoi_Dung.Nguoi_dung_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns= {"/modify_Infor", "/order", "/add_cart"})
@MultipartConfig(
		fileSizeThreshold = 512 * 512 * 10,
		maxFileSize = 1024 *  1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)
public class ClientController extends HttpServlet{

	private static final long serialVersionUID = -15287231039588276L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/modify_Infor")) {
			UpdateInfor(req);
			req.getRequestDispatcher("userInfor.jsp").forward(req, resp);
		}
		else if(action != null && action.equals("/order")) {
		}
		else if(action != null && action.equals("/add_cart")) {
		}
		
	}
	
	private void UpdateInfor(HttpServletRequest request) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
		
		Nguoi_dung tmp = getNewInfor(request);
		  
		try {
			new Nguoi_dung_Service().Update(tmp, request);
	        System.out.println("Cập nhật thành công");
			session.setAttribute("acc",tmp);  
		} catch (Exception e) {
			System.out.println("Khong the cap nhat tai khoan nguoi dung");
			System.out.println(e);
			session.setAttribute("acc",acc);
		}
	}
	
	public Nguoi_dung getNewInfor(HttpServletRequest request) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
		
		String phoneNumber =  request.getParameter("phone");
		String address = request.getParameter("address");
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String image = request.getParameter("image");
		System.out.println("Bat dau cap nhat nguoi dung");
		
		//Đường dẫn ảnh
		String path = "D:\\Language Program\\Java_web\\PBL3-clothing-ecommerce\\PBL3\\src\\main\\webapp\\img\\anh_nguoi_dung\\";
		Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String imagePath = "img/anh_nguoi_dung/" + fileName;
        
        // thay doi account thanh nguoi_dung
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
        
		return acc;
	}
	
}
