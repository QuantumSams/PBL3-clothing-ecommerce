package Service.Danh_Muc;

import java.util.List;

import DAO.implemet.Danh_muc_DAO;
import Entity.San_Pham.Danh_muc_san_pham;

public class Danh_muc_Service {
	
	private Danh_muc_DAO danh_muc_DAO;
	private Tree tree_danh_muc;
	
	public Danh_muc_Service() {
		danh_muc_DAO = new Danh_muc_DAO();
		tree_danh_muc = new Tree();
		LayTatCaDanhMuc();
	}
	
	public void LayTatCaDanhMuc() {
		List<Danh_muc_san_pham> list = danh_muc_DAO.LayTatCaDanhMuc();
		tree_danh_muc.add(list);
		System.out.println(tree_danh_muc.toString());
	}
	
	public List<Danh_muc_san_pham> Lay_danh_muc_con(){
		return tree_danh_muc.getChild();
	}
	
	public List<Danh_muc_san_pham> Lay_danh_muc_con(Danh_muc_san_pham danh_muc_san_pham){
		return tree_danh_muc.getChild(danh_muc_san_pham);
	}
	
	public List<Danh_muc_san_pham> Lay_danh_muc_con(int id){
		return tree_danh_muc.getChild(id);
	}
	
	public Danh_muc_san_pham getDanh_muc_Id(int id) {
		return tree_danh_muc.getDanhMucByID(id);
	}
}
