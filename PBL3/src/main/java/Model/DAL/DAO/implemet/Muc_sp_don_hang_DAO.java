package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Don_Hang.Muc_sp_don_hang_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Muc_sp_don_hang;

public class Muc_sp_don_hang_DAO extends AbstractDao implements Repository<Muc_sp_don_hang>{

	@Override
	public void add(Muc_sp_don_hang t) {
		String query = "INSERT INTO chi_tiet_don_hang VALUES ( ?, ?, ?, ?)";
		insert(query, t.getId_don_hang(),
						t.getId_muc_san_pham(), 
						t.getSo_luong(), 
						t.getGia());
	}

	@Override
	public List<Muc_sp_don_hang> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Muc_sp_don_hang> findBySpacification(Specification<Muc_sp_don_hang> specification) {
		List<Muc_sp_don_hang> list = query(specification.getQuery(), new Muc_sp_don_hang_Mapper(), specification.getParameters());
		return list;
	}

	@Override
	public void update(Muc_sp_don_hang t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Muc_sp_don_hang t) {
		// TODO Auto-generated method stub
		
	}

}
