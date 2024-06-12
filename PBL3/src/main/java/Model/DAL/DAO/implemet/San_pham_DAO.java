package Model.DAL.DAO.implemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.San_Pham.San_pham_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;


public class San_pham_DAO extends AbstractDao implements Repository<San_pham>{
	
	@Override
	public void add(San_pham san_pham) {
		String query = "INSERT INTO san_pham VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		insert(query, 	san_pham.getId_san_pham(), 
						san_pham.getTen_san_pham(),
						san_pham.getTen_nhan_hang(),
						san_pham.getChat_lieu(),
						san_pham.getThong_tin_chung(),
						san_pham.getThong_tin_chi_tiet(),
						san_pham.getId_danh_muc_san_pham());
	}

	@Override
	public List<San_pham> getALL() {
		String query = "SELECT id_san_pham, danh_muc_san_pham.ten_danh_muc_san_pham, ten_san_pham, ten_nhan_hang, ten_chat_lieu, thong_tin_chung, thong_tin_chi_tiet "
				+ "FROM san_pham INNER JOIN  danh_muc_san_pham ON san_pham.id_danh_muc_san_pham = danh_muc_san_pham.id_danh_muc_san_pham";

		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper());
		
		return list_san_pham;
	}

	@Override
	public List<San_pham> findBySpacification(Specification<San_pham> specification) {
		List<San_pham> list = query(specification.getQuery(), new San_pham_Mapper(), specification.getParameters());
		
		return list;
	}

	@Override
	public void update(San_pham san_pham) {
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE san_pham SET ten_san_pham = ?, ten_nhan_hang = ?, ten_chat_lieu = ?,");
		query.append("thong_tin_chung = ?, thong_tin_chi_tiet = ?, id_danh_muc_san_pham = ? ");
		query.append("WHERE id_san_pham = ? ");
		
		update (query.toString(), 	san_pham.getTen_san_pham(),
									san_pham.getTen_nhan_hang(),
									san_pham.getChat_lieu(),
									san_pham.getThong_tin_chung(),
									san_pham.getThong_tin_chi_tiet(),
									san_pham.getId_danh_muc_san_pham(),
									san_pham.getId_san_pham()
									);
	}

	@Override
	public void remove(San_pham t) {
		String query = "DELETE FROM san_pham WHERE id_san_pham = ?";
		update(query, t.getId_san_pham());
	}
}
