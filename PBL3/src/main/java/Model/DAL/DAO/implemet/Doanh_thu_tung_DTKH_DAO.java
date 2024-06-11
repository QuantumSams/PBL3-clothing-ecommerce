package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Doanh_Thu.Doanh_thu_tung_DTKH_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Doanh_Thu.Doanh_thu;
import Model.DTO.Doanh_Thu.Doanh_thu_tung_DTKH;

public class Doanh_thu_tung_DTKH_DAO  extends AbstractDao implements Repository<Doanh_thu_tung_DTKH>{

	@Override
	public void add(Doanh_thu_tung_DTKH t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Doanh_thu_tung_DTKH> getALL() {
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("SELECT danh_muc_san_pham.ten_danh_muc_san_pham, SUM(so_luong.so_luong) AS so_san_pham_cuaDTKH FROM danh_muc_san_pham ");
		sql.append("INNER JOIN danh_muc_san_pham AS loai_sp ");
		sql.append("ON loai_sp.parent_id = danh_muc_san_pham.id_danh_muc_san_pham ");
		sql.append("INNER JOIN danh_muc_san_pham AS muc_sp ");
		sql.append("ON muc_sp.parent_id = loai_sp.id_danh_muc_san_pham ");
		sql.append("LEFT JOIN ( ");
		sql.append("SELECT id_danh_muc_san_pham, SUM(so_luong) AS so_luong FROM san_pham ");
		sql.append("INNER JOIN ( ");
		sql.append("SELECT id_san_pham, muc_san_pham.id_muc_san_pham, SUM(so_luong * chi_tiet_don_hang.gia_tien) AS so_luong FROM chi_tiet_don_hang ");
		sql.append("INNER JOIN muc_san_pham ON muc_san_pham.id_muc_san_pham = chi_tiet_don_hang.id_muc_san_pham ");
		sql.append("GROUP BY chi_tiet_don_hang.id_muc_san_pham ");
		sql.append(") AS so_ban ON so_ban.id_san_pham = san_pham.id_san_pham ");
		sql.append("GROUP BY id_danh_muc_san_pham ");
		sql.append(") AS so_luong ON muc_sp.id_danh_muc_san_pham = so_luong.id_danh_muc_san_pham ");
		sql.append("GROUP BY danh_muc_san_pham.ten_danh_muc_san_pham ");
		
		return query(sql.toString(), new Doanh_thu_tung_DTKH_Mapper());
	}

	@Override
	public List<Doanh_thu_tung_DTKH> findBySpacification(Specification<Doanh_thu_tung_DTKH> specification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Doanh_thu_tung_DTKH t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Doanh_thu_tung_DTKH t) {
		// TODO Auto-generated method stub
		
	}
	
}
