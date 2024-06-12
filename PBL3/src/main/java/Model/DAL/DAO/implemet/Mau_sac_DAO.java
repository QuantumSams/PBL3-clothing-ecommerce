package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;

public class Mau_sac_DAO extends AbstractDao implements Repository<Mau_sac>{

	@Override
	public void add(Mau_sac mau_sac) {
		String query = "INSERT INTO mau_sac VALUES (?, ?, ?)";
		insert(query, mau_sac.getId_mau_sac(), mau_sac.getTen_mau(), mau_sac.getAnh_mau_sac());
	}

	@Override
	public List<Mau_sac> getALL() {
		String sql = "SELECT * FROM mau_sac";
		List<Mau_sac> list = query(sql, new Mau_sac_Mapper());
		return list;
	}

	@Override
	public List<Mau_sac> findBySpacification(Specification<Mau_sac> specification) {
		List<Mau_sac> list = query(specification.getQuery(), new Mau_sac_Mapper(), specification.getParameters());
		return list;
	}

	@Override
	public void update(Mau_sac t) {
		String sql = "UPDATE mau_sac SET ten_mau = ?, duong_dan_anh = ? WHERE id_mau_sac = ?";
		update(sql, t.getTen_mau(), t.getAnh_mau_sac(), t.getId_mau_sac());
	}

	@Override
	public void remove(Mau_sac t) {
		String sql = "DELETE FROM mau_sac WHERE id_mau_sac = ?";
		update(sql, t.getId_mau_sac());
	}

}
