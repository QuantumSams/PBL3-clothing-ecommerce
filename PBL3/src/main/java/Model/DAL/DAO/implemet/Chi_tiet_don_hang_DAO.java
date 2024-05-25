package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Don_Hang.Chi_tiet_don_hang_Mapper;
import Model.DAL.Mapper.San_Pham.Danh_muc_san_pham_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Chi_tiet_don_hang;
import Model.DTO.San_Pham.Danh_muc_san_pham;

public class Chi_tiet_don_hang_DAO extends AbstractDao implements Repository<Chi_tiet_don_hang>{

	@Override
	public void add(Chi_tiet_don_hang t) {
		String query = "INSERT INTO chi_tiet_don_hang VALUES (?, ?, ?, ?)";
		insert(query, t.getId_don_hang(), t.getId_muc_san_pham(), t.getSo_luong(), t.getGia_tien());
	}

	@Override
	public List<Chi_tiet_don_hang> getALL() {
		String Query = "SELECT * FROM chi_tiet_don_hang";
		List<Chi_tiet_don_hang> list = query(Query, new Chi_tiet_don_hang_Mapper());
		return list;
	}

	@Override
	public List<Chi_tiet_don_hang> findBySpacification(Specification<Chi_tiet_don_hang> specification) {
		List<Chi_tiet_don_hang> list = query(specification.getQuery(), new Chi_tiet_don_hang_Mapper(), specification.getParameters());
		return list;
	}

	@Override
	public void update(Chi_tiet_don_hang t) {
//		String sql = "UPDATE chi_tiet_don_hang SET id = ?, ten_muc_san_pham = ? WHERE id_muc_san_pham = ?";
//		update(sql, t.getId_muc_san_pham(), t.getSo_luong(), t.getId_don_hang());
	}

	@Override
	public void remove(Chi_tiet_don_hang t) {
//		String sql = "DELETE FROM danh_muc_san_pham WHERE id_muc_san_pham = ?";
//		update(sql, t.getId_don_hang());
	}

}
