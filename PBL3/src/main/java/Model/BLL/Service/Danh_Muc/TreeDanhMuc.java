package Model.BLL.Service.Danh_Muc;

import java.util.List;

import Model.DTO.San_Pham.Danh_muc_san_pham;

public class TreeDanhMuc {
	private Danh_muc_san_pham danh_muc_san_pham;
	private List<TreeDanhMuc> node;
	public TreeDanhMuc() {
		
	}
	public TreeDanhMuc(Danh_muc_san_pham danh_muc_san_pham, List<TreeDanhMuc> node) {
		super();
		this.danh_muc_san_pham = danh_muc_san_pham;
		this.node = node;
	}
	public Danh_muc_san_pham getDanh_muc_san_pham() {
		return danh_muc_san_pham;
	}
	public void setDanh_muc_san_pham(Danh_muc_san_pham danh_muc_san_pham) {
		this.danh_muc_san_pham = danh_muc_san_pham;
	}
	public List<TreeDanhMuc> getNode() {
		return node;
	}
	public void setNode(List<TreeDanhMuc> node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "TreeDanhMuc [danh_muc_san_pham=" + danh_muc_san_pham + ", node=" + node + "]";
	}
	
	
	
}
