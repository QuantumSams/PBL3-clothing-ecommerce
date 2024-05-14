package DAO.implemet;

import java.util.List;

import DAO.AbstractDao;
import Entity.Don_Hang.Gio_hang;
import Entity.San_Pham.Muc_san_pham;
import Entity.San_Pham.San_pham;
import Mapper.San_Pham.Gio_hang_Mapper;

public class Gio_hang_DAO extends AbstractDao{
	public List<Gio_hang> get_list_by_id_khach_hang(int id_khach_hang) {
		
		String query = "SELECT * FROM gio_hang WHERE id_khach_hang = ?";
		List<Gio_hang> list_gio_hang = query(query, new Gio_hang_Mapper(), id_khach_hang);
		
		for(Gio_hang gio_hang : list_gio_hang) {
			Muc_san_pham muc_san_pham = new San_pham_DAO().getMuc_san_pham(gio_hang.getId_muc_san_pham());
			muc_san_pham.get_ten_san_pham();
			gio_hang.setMuc_san_pham(muc_san_pham);
		}
		
		return list_gio_hang;
	}
	
	public void delete_by_id(int id_gio_hang) {
		String query = "DELETE FROM gio_hang WHERE id_gio_hang = ?";
		update(query, id_gio_hang);
	}
	
}
