package Service.Nguoi_Dung;

import java.io.IOException;
import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

import DAO.implemet.Nguoi_dung_DAO;
import Entity.Nguoi_Dung.Nguoi_dung;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class Nguoi_dung_Service {
	private Nguoi_dung_DAO nguoidung_DAO;
	
	public Nguoi_dung_Service() {
		nguoidung_DAO = new Nguoi_dung_DAO();
	}
	
	public Nguoi_dung LayTaiKhoan(String user, String password) {
		password = toSHA1(password);
		return nguoidung_DAO.Dang_nhap(user, password);
	}
	
	public void Dang_ky(Nguoi_dung nguoi_dung) {
		nguoi_dung.setPassword(toSHA1(nguoi_dung.getPassword()));
		new Nguoi_dung_DAO().Dang_ky(nguoi_dung);
	}
	
	public void Update(Nguoi_dung nguoi_dung, HttpServletRequest request) throws IOException, ServletException {
		String path = "D:\\Language Program\\Java_web\\PBL3-clothing-ecommerce\\PBL3\\src\\main\\webapp\\img\\anh_nguoi_dung\\";
		
		new Nguoi_dung_DAO().Update_thong_tin(nguoi_dung);
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		filePart.write(path + fileName);
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
