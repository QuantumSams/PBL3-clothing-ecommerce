package Service.Nguoi_Dung;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.Nguoi_dung_DAO;
import Entity.Nguoi_Dung.Nguoi_dung;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class Nguoi_dung_Service {
	private Nguoi_dung_DAO nguoidung_DAO;
	
	public Nguoi_dung_Service() {
		nguoidung_DAO = new Nguoi_dung_DAO();
	}
	
	public String Login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html;charset=UTF-8");
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		
		password = toSHA1(password);
		Nguoi_dung acc = nguoidung_DAO.Dang_nhap(user, password);
		if(acc == null) throw new Exception("Sai tài khoản hoặc mật khẩu");
		
		HttpSession session = req.getSession();
		session.setAttribute("acc", acc);
		return acc.getPhan_quyen_nguoi_dung();
	}	
	
	public void Load_nguoi_dung_by_ID(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		Nguoi_dung acc = nguoidung_DAO.Get_by_ID(id);
		HttpSession session = req.getSession();
		session.setAttribute("acc", acc);
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		session.removeAttribute("acc");
	}
	

	public void Sign_up(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passWord = req.getParameter("passWord");
		String fullname = req.getParameter("fullname");
		String phoneNumber = req.getParameter("phoneNumber");
		String repass = req.getParameter("repassword");
		
		if(!passWord.equals(repass)) {
			postJson(resp, "Mật khẩu không trùng khớp");
		}
		else {
			try {
				int id = new Random().nextInt(1000);

				Nguoi_dung nguoi_dung = new Nguoi_dung(id, fullname, true, new Date(0), "", "", phoneNumber, email, "KHACH_HANG");
				nguoi_dung.setPassword(passWord);
				if(nguoidung_DAO.count_email(nguoi_dung.getEmail()) > 0) throw new Exception("Email bị trùng");
				if(nguoidung_DAO.count_so_dien_thoai(nguoi_dung.getSo_dien_thoai()) > 0) throw new Exception("Số điện thoại bị trùng");
				
				nguoi_dung.setPassword(toSHA1(nguoi_dung.getPassword()));
				new Nguoi_dung_DAO().Dang_ky(nguoi_dung);
				
				postJson(resp, "Tạo tài khoản thành công");
			}
			catch(Exception e){
				postJson(resp, e.getMessage());
			}
			
		}
	}
	
	public void UpdateInfor(HttpServletRequest request) throws IOException, ServletException {
		
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
        String imagePath;
        if(fileName != null && fileName != "") {
        	imagePath = "img/anh_nguoi_dung/" + fileName;
        }
        else {
        	imagePath = acc.getAnh_dai_dien();
        }
        
        
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
	
	public void Update_password(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String old_password = request.getParameter("old_password");
		String new_password = request.getParameter("new_password");
		String new_repassword = request.getParameter("new_repassword");
		
		HttpSession session = request.getSession();
		Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
		
		if(!new_password.equals(new_repassword)) {
			postJson(resp, "Mật khẩu mới không trùng khớp");
		}
		else{
			Nguoi_dung tmp = nguoidung_DAO.Dang_nhap(acc.getEmail(), toSHA1(old_password));
			if(tmp == null) {
				postJson(resp, "Mật khẩu cũ không trùng khớp");
			}
			else {
				nguoidung_DAO.update_password(acc.getId_nguoi_dung(), toSHA1(new_password));
				postJson(resp, "Cập nhật mật khẩu thành công");
			}
		}
	}
	
	public void Update(Nguoi_dung nguoi_dung, HttpServletRequest request) throws IOException, ServletException {
		String path = "D:\\Language Program\\Java_web\\PBL3-clothing-ecommerce\\PBL3\\src\\main\\webapp\\img\\anh_nguoi_dung\\";
		
		new Nguoi_dung_DAO().Update_thong_tin(nguoi_dung);
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		filePart.write(path + fileName);
	}
	
	public void load_nhan_vien_by_json(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String search = req.getParameter("name_nhan_vien");
		
		List<Nguoi_dung> list = nguoidung_DAO.SearchNhanVien(search);
		
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public void load_nhan_vien_by_session(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Nguoi_dung> list = nguoidung_DAO.GetNhanVien();
		HttpSession session = req.getSession();
		session.setAttribute("nhan_vien", list);
	}

	private void postJson( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public static String toSHA1(String str) {
		String salt = "iuseh92q3yr9ow8q3r7y9whf938ay4rhw";
		String result = null;
		
		str = str + salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		}
		catch(Exception e) {
			
		}
		return result;
		
	}
}
