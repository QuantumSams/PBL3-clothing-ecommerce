package Model.DAL.DAO.implemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.JDBC_Unit;
import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.San_Pham.Danh_muc_san_pham_Mapper;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Danh_muc_san_pham;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;


public class Danh_muc_DAO extends AbstractDao implements Repository<Danh_muc_san_pham>{

	@Override
	public void add(Danh_muc_san_pham t) {
		String query = "INSERT INTO danh_muc_san_pham VALUES (?, ?, ?)";
		insert(query, t.getId(), t.getParent_id(), t.getCategory());
	}

	@Override
	public List<Danh_muc_san_pham> getALL() {
		String Query = "SELECT * FROM danh_muc_san_pham";
		List<Danh_muc_san_pham> list = query(Query, new Danh_muc_san_pham_Mapper());
		return list;
	}

	@Override
	public List<Danh_muc_san_pham> findBySpacification(Specification<Danh_muc_san_pham> specification) {
		List<Danh_muc_san_pham> list = query(specification.getQuery(), new Danh_muc_san_pham_Mapper(), specification.getParameters());
		return list;
	}

	@Override
	public void update(Danh_muc_san_pham t) {
		String sql = "UPDATE danh_muc_san_pham SET parent_id = ?, ten_muc_san_pham = ? WHERE id_muc_san_pham = ?";
		update(sql, t.getParent_id(), t.getCategory(), t.getId());
	}

	@Override
	public void remove(Danh_muc_san_pham t) {
		String sql = "DELETE FROM danh_muc_san_pham WHERE id_muc_san_pham = ?";
		update(sql, t.getId());
	}
}
