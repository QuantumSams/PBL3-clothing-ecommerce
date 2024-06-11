package Model.BLL.Service.Nguoi_Dung;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;

import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.Specification.Implements.Nguoi_dung.FindAllNhanVien;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByEmail;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByID;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByMailOrNumber;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByNumber;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNhanVienByName;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Nguoi_dung_Service {
	private Nguoi_dung_DAO nguoidung_DAO;
	
	public Nguoi_dung_Service(Nguoi_dung_DAO nguoidung_DAO) {
		this.nguoidung_DAO = nguoidung_DAO;
		
	}
	
	public Nguoi_dung Login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html;charset=UTF-8");
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		password = toSHA1(password);
		
		List<Nguoi_dung> list = nguoidung_DAO.findBySpacification(new FindNguoiDungByMailOrNumber(user, user, password));
		
		if(list == null || list.size() == 0) {
			throw new Exception("Tài khoản, mật khẩu không hợp lệ");
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("acc", list.get(0));
		return list.get(0);
	}	
	
	public void Sign_up(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String email = req.getParameter("email");
		String passWord = req.getParameter("passWord");
		String fullname = req.getParameter("fullname");
		String phoneNumber = req.getParameter("phoneNumber");
		String repass = req.getParameter("repassword");
		
		if(!passWord.equals(repass)) {
			throw new Exception("Mật khẩu không trùng khớp");
		}
		else {
			try {
				int id = new Random().nextInt(1000);

				Nguoi_dung nguoi_dung = new Nguoi_dung(id, fullname, true, new Date(0), " / / / ", "", phoneNumber, email, "KHACH_HANG");
				nguoi_dung.setPassword(passWord);
				
				// xet xem email co bi trung hay khong
				List<Nguoi_dung>  findByEmail = nguoidung_DAO.findBySpacification(new FindNguoiDungByEmail(email));
				
				if(findByEmail.size() > 0)
					throw new Exception("Email bị trùng");
				
				// xet xem so dien thoai co bi trung hay khong
				List<Nguoi_dung> findByNumber = nguoidung_DAO.findBySpacification(new FindNguoiDungByNumber(phoneNumber));
				if(findByNumber.size() > 0) 
					throw new Exception("Số điện thoại bị trùng");
				
				nguoi_dung.setPassword(toSHA1(nguoi_dung.getPassword()));
				
				nguoidung_DAO.add(nguoi_dung);
			}
			catch(Exception e){
				throw new Exception(e.getMessage());
			}
			
		}
	}
	
	public void tao_nhan_vien(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String email = req.getParameter("email");
		String passWord = req.getParameter("new_password");
		String fullname = req.getParameter("ho_ten");
		String phoneNumber = req.getParameter("so_dien_thoai");
		String ngay_sinh = req.getParameter("ngay_sinh");
		String dia_chi = req.getParameter("dia_chi");
		String gioi_tinh = req.getParameter("gioi_tinh");
		String anh_nhan_vien = req.getParameter("anh");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng chuỗi ngày tháng
	       
		Date date = new Date(formatter.parse(ngay_sinh).getTime());
		
		
		try {
			int id = new Random().nextInt(1000);

			Nguoi_dung nguoi_dung = new Nguoi_dung(id, fullname, Boolean.parseBoolean(gioi_tinh), date, dia_chi, "img/anh_nguoi_dung/mac_dinh.png", phoneNumber, email, "NHAN_VIEN");
			nguoi_dung.setPassword(passWord);
			nguoi_dung.setAnh_dai_dien(add_image(anh_nhan_vien, Integer.toString(id)));
			
			// xet xem email co bi trung hay khong
			List<Nguoi_dung>  findByEmail = nguoidung_DAO.findBySpacification(new FindNguoiDungByEmail(email));
				
			if(findByEmail.size() > 0)
				throw new Exception("Email bị trùng");
				
			// xet xem so dien thoai co bi trung hay khong
			List<Nguoi_dung> findByNumber = nguoidung_DAO.findBySpacification(new FindNguoiDungByNumber(phoneNumber));
			if(findByNumber.size() > 0) 
				throw new Exception("Số điện thoại bị trùng");
				
			nguoi_dung.setPassword(toSHA1(nguoi_dung.getPassword()));
				
			nguoidung_DAO.add(nguoi_dung);
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}	
			
		
	}
	public String add_image(String imageStrings, String id_nguoi_dung) throws IOException, ServletException {
		
		byte[] data1 =  java.util.Base64.getDecoder().decode(imageStrings);
			 
		String path = "img/anh_nguoi_dung/" + id_nguoi_dung + ".png";
		
		image(data1, path);
			 
		return path;	
	}
	
	public void delete_image(String name_image) {
		String root = "D:/Language Program/Java_web/PBL3/PBL3-clothing-ecommerce/PBL3/src/main/webapp/";
		String path = root + name_image;
		File file = new File(path);

        if (file.delete()) {
            System.out.println("Tệp đã được xóa.");
        } else {
            System.out.println("Xóa tệp không thành công.");
        }
	}
	
	public void image(byte[] data1, String name_image) {
		String root = "D:/Language Program/Java_web/PBL3/PBL3-clothing-ecommerce/PBL3/src/main/webapp/";
		String path = root + name_image;
		
		try (FileOutputStream fos = new FileOutputStream(path)) {
			fos.write(data1);
			System.out.println("Image saved successfully to: " + path);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void UpdateInformation(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		try {
			int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
			String ho_ten_khach_hang = req.getParameter("ho_ten_khach_hang");
			String ngay_sinh = req.getParameter("ngay_sinh");
			String dia_chi = req.getParameter("dia_chi");
			String gioi_tinh = req.getParameter("gioi_tinh");
			String anh =  req.getParameter("anh");
			System.out.println(anh);
			Nguoi_dung acc = nguoidung_DAO.findBySpacification(new FindNguoiDungByID(id_khach_hang)).get(0);
			
			acc.setDia_chi(dia_chi);
			acc.setHo_ten(ho_ten_khach_hang);
			acc.setGioi_tinh(Boolean.parseBoolean(gioi_tinh));
			if(anh != null) {
				delete_image( "img/anh_nguoi_dung/" + id_khach_hang + ".png");
				acc.setAnh_dai_dien(add_image(anh, Integer.toString(id_khach_hang)));
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng chuỗi ngày tháng
       
			acc.setNgay_sinh(new Date(formatter.parse(ngay_sinh).getTime()));
			
			nguoidung_DAO.update(acc);
			
		} catch (ParseException e) {
			throw new Exception("Cập nhật thông tin tài khoản thất bại");
		}
	}
	
	public void UpdatePassword(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String old_password = req.getParameter("old_password");
		String new_password = req.getParameter("new_password");
		String new_repassword = req.getParameter("new_repassword");
		
		HttpSession session = req.getSession();
		Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
		
		if(!new_password.equals(new_repassword)) {
			throw new Exception("Mật khẩu mới không trùng khớp");
		}
		else{
			if(acc == null) throw new Exception("không tìm thấy người dùng");
			Nguoi_dung tmp = nguoidung_DAO.findBySpacification(new FindNguoiDungByMailOrNumber(acc.getEmail(), acc.getSo_dien_thoai(),toSHA1(old_password))).get(0);
			if(tmp == null) {
				throw new Exception("Mật khẩu cũ không trùng khớp");
			}
			else {
				nguoidung_DAO.update_password(acc.getId_nguoi_dung(), toSHA1(new_password));
			}
		}
	}
	
	public List<Nguoi_dung> getAllNhanVien(HttpServletRequest req, HttpServletResponse resp){
		List<Nguoi_dung> list = nguoidung_DAO.findBySpacification(new FindAllNhanVien());
		return list;
	}
	
	public List<Nguoi_dung> getNhanVienByName(HttpServletRequest req, HttpServletResponse resp){
		
		String search = req.getParameter("name_nhan_vien");
		
		List<Nguoi_dung> list = nguoidung_DAO.findBySpacification(new FindNhanVienByName(search));
		return list;
	}
	
	public List<Nguoi_dung> getNguoiDungByID(HttpServletRequest req, HttpServletResponse resp){
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		List<Nguoi_dung> list = nguoidung_DAO.findBySpacification(new FindNguoiDungByID(id));
		return list;
	}
	
	public void remove_User(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		Nguoi_dung nguoi_dung = nguoidung_DAO.findBySpacification(new FindNguoiDungByID(id)).get(0);
		nguoidung_DAO.remove(nguoi_dung);
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
