package DAO.implemet;

import java.util.List;

import DAO.AbstractDao;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Mapper.Thuoc_tinh_san_pham.Size_Mapper;

public class Thuoc_tinh_DAO extends AbstractDao{
	
	public List<Mau_sac> getMau_sac() {
		String sql = "select * from mau_sac";
		List<Mau_sac> list_mau_sac = query(sql, new Mau_sac_Mapper());
		return list_mau_sac;
	}
	
	public void them_Mau_sac(Mau_sac mau_sac) {
		String query = "INSERT INTO mau_sac VALUES (?, ?, ?)";
		insert(query, mau_sac.getId_mau_sac(), mau_sac.getTen_mau(), mau_sac.getAnh_mau_sac());
	}
	
	public void sua_Mau_sac(Mau_sac mau_sac) {
		
	}
	
	public List<Size> getSize() {
		String sql = "SELECT * FROM size";
		List<Size> list_size = query(sql, new Size_Mapper()); 
		return list_size;
	}
	
}
