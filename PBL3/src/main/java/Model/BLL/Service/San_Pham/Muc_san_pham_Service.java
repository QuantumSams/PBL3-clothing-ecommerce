package Model.BLL.Service.San_Pham;

import java.util.List;

import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DAL.Specification.Implements.San_pham.FindProductByID;
import Model.DTO.San_Pham.Muc_san_pham;

public class Muc_san_pham_Service {
	private Muc_san_pham_DAO muc_san_pham_DAO;
	private San_pham_DAO san_pham_DAO;
	public Muc_san_pham_Service(Muc_san_pham_DAO muc_san_pham_DAO, San_pham_DAO san_pham_DAO) {
		
		this.muc_san_pham_DAO = muc_san_pham_DAO;
		this.san_pham_DAO = san_pham_DAO;
	}
	
	public List<Muc_san_pham> getAllMucSanPham(){
		
		List<Muc_san_pham> list_muc_san_pham = muc_san_pham_DAO.getALL();
		
		for(Muc_san_pham muc_san_pham : list_muc_san_pham) {
			muc_san_pham.setSan_pham(san_pham_DAO.findBySpacification(new FindProductByID(muc_san_pham.getId_san_pham())).get(0));
			muc_san_pham.get_ten_san_pham();
		}
		
		return list_muc_san_pham;
	}
}
