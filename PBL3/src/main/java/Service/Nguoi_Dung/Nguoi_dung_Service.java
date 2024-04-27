package Service.Nguoi_Dung;

import DAO.implemet.Nguoi_dung_DAO;
import Entity.Nguoi_Dung.Nguoi_dung;

public class Nguoi_dung_Service {
	private Nguoi_dung_DAO nguoidung_DAO;
	
	public Nguoi_dung_Service() {
		nguoidung_DAO = new Nguoi_dung_DAO();
	}
	
	public Nguoi_dung LayTaiKhoan(String user, String password) {
		return nguoidung_DAO.Dang_nhap(user, password);
	}
}
