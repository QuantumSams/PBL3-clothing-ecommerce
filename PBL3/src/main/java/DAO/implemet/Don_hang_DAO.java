package DAO.implemet;

import java.sql.Date;
import java.util.List;

import DAO.AbstractDao;
import DataStructures.Pair;
import Entity.Don_Hang.Don_hang;
import Mapper.Don_Hang.Don_hang_Mapper;

public class Don_hang_DAO extends AbstractDao{

	public void add_order(Don_hang don_hang) {
		String query = "INSERT INTO don_hang VALUES (?, ?, ?, null, ?, ?, ?, ?, ?, ?)";
		insert(query, don_hang.getId_hoa_don(),
										don_hang.getTong_tien(), 
										don_hang.getId_khach_hang(),
										don_hang.getSo_dien_thoai(),
										don_hang.getDia_chi_giao_dich(), 
										don_hang.getNgay_gio_dat_don_hang(),
										don_hang.getNgay_gio_nhan_don_hang(),
										don_hang.getGhi_chu(),
										don_hang.getTrang_thai_don_hang());
		
		for(Pair<Integer, Integer> muc_san_pham : don_hang.getList_muc_san_pham()) {
			query = "INSERT INTO chi_tiet_don_hang VALUES (?, ?, ?)";
			
			insert(query, don_hang.getId_hoa_don(), muc_san_pham.getKey(), muc_san_pham.getValue());
		}
	}
	
	
	public List<Don_hang> select_order(){
		
		String query = "SELECT * FROM don_hang";
		List<Don_hang> list = query(query, new Don_hang_Mapper());
		
		return list;
	}
	public Don_hang select_order(int id) {
		String query = "SELECT * FROM don_hang WHERE id_don_hang = ?";
		List<Don_hang> list = query(query, new Don_hang_Mapper(), id);
		
		if(list != null) {
			
			query = "SELECT id_muc_san_pham, so_luong FROM chi_tiet_don_hang WHERE id_don_hang = ?";
			list.get(0).setList_muc_san_pham(query(query, id));
			
			return list.get(0);
		}
		else {
			return null;
		}
		
	}
	
	public void update_order(Don_hang don_hang) {
		String query = "UPDATE don_hang SET tong_tien = ?, id_khach_hang = ?, id_nhan_vien = ? , ngay_gio_dat = ?, ngay_gio_nhan = ?, trang_thai_don_hang = ? WHERE id_don_hang = ?";
	
		update(query, don_hang.getTong_tien(), don_hang.getId_khach_hang(), don_hang.getId_nhan_vien(), don_hang.getNgay_gio_dat_don_hang(), don_hang.getId_nhan_vien(), don_hang.getTrang_thai_don_hang(), don_hang.getId_hoa_don());
	}
	
	public void update_order(int id, int id_nhan_vien, String trang_thai_don_hang) {
		String query = "UPDATE don_hang SET id_nhan_vien = ?, trang_thai_don_hang = ? WHERE id_don_hang = ?";
	
		update(query, id_nhan_vien,	trang_thai_don_hang, id);
	}
	
	public void update_order(int id, Date ngay_gio_nhan_hang, String trang_thai_don_hang) {
		String query = "UPDATE don_hang SET ngay_gio_nhan = ?, trang_thai_don_hang = ? WHERE id_don_hang = ?";
	
		update(query, ngay_gio_nhan_hang, trang_thai_don_hang, id);
	}
	
	public void delete_order(Don_hang don_hang) {
		
		String query = "DELETE FROM chi_tiet_don_hang WHERE id_don_hang = ?";
		update(query, don_hang.getId_hoa_don());
		
		query = "DELETE FROM don_hang WHERE id_don_hang = ?";
		update(query, don_hang.getId_hoa_don());
		
	}
}
