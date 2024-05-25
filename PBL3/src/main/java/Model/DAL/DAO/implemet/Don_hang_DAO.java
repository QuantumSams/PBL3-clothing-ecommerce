package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Don_Hang.Don_hang_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Don_hang;

public class Don_hang_DAO extends AbstractDao implements Repository<Don_hang>{

	@Override
	public void add(Don_hang don_hang) {
		String query = "INSERT INTO don_hang VALUES (?, ?, NULL, ?, ?, ?, ?, ?, ?)";
		insert(query, 	don_hang.getId_hoa_don(),
						don_hang.getId_khach_hang(),
						don_hang.getSo_dien_thoai(),
						don_hang.getDia_chi_giao_dich(), 
						don_hang.getNgay_gio_dat_don_hang(),
						don_hang.getNgay_gio_nhan_don_hang(),
						don_hang.getGhi_chu(),
						don_hang.getTrang_thai_don_hang());
	}


	@Override
	public void update(Don_hang don_hang) {
		String query = "UPDATE don_hang SET id_khach_hang = ?, id_nhan_vien = ? , ngay_gio_dat = ?, ngay_gio_nhan = ?, trang_thai_don_hang = ? WHERE id_don_hang = ?";
		
		update(query, don_hang.getId_khach_hang(), don_hang.getId_nhan_vien(), don_hang.getNgay_gio_dat_don_hang(), don_hang.getId_nhan_vien(), don_hang.getTrang_thai_don_hang(), don_hang.getId_hoa_don());
	}


	@Override
	public void remove(Don_hang don_hang) {
		String query = "DELETE FROM don_hang WHERE id_don_hang = ?";
		
		update(query, don_hang.getId_hoa_don());
	}


	@Override
	public List<Don_hang> getALL() {
		String Query = "SELECT * FROM chi_tiet_don_hang";
		List<Don_hang> list = query(Query, new Don_hang_Mapper());
		return list;
	}


	@Override
	public List<Don_hang> findBySpacification(Specification<Don_hang> specification) {
		List<Don_hang> list = query(specification.getQuery(), new Don_hang_Mapper(), specification.getParameters());
		return list;
	}
}
