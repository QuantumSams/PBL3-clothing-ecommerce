package Model.BLL.Service.Thuoc_Tinh;

import java.util.List;

import Model.DAL.DAO.implemet.Thuoc_tinh_DAO;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class Thuoc_tinh_Service {
	
	private Thuoc_tinh_DAO thuoc_tinh_DAO;
	
	public Thuoc_tinh_Service() {
		thuoc_tinh_DAO = new Thuoc_tinh_DAO();
	}
	
	public List<Mau_sac> getMau_sac() {
		return thuoc_tinh_DAO.getMau_sac();
	}
	
	public List<Size> getSize(){
		return thuoc_tinh_DAO.getSize();
	}
	
}
