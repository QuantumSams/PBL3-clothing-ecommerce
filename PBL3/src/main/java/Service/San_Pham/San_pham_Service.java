package Service.San_Pham;

import java.util.List;

import DAO.implemet.San_pham_DAO;
import Entity.San_Pham.San_pham;

public class San_pham_Service {
	
	private San_pham_DAO san_pham_DAO;
	
	public San_pham_Service() {
		san_pham_DAO = new San_pham_DAO();
	}
	
	public List<San_pham> LayTatCaSanPham() {
		return san_pham_DAO.getList_San_Pham();
	}
	
	
}
