package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Don_Hang.Danh_gia_don_hang_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Danh_gia_don_hang;

public class Danh_gia_don_hang_DAO   extends AbstractDao implements Repository<Danh_gia_don_hang>{

	@Override
	public void add(Danh_gia_don_hang t) {
		String query = "INSERT INTO danh_gia_don_hang VALUES (?, ?, ?, ?, ?)";
		insert(query, t.getId_danh_gia(), 49, t.getId_don_hang(), t.getDiem_danh_gia(), t.getBinh_luan());
	}

	@Override
	public List<Danh_gia_don_hang> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Danh_gia_don_hang> findBySpacification(Specification<Danh_gia_don_hang> specification) {
		List<Danh_gia_don_hang> list = query(specification.getQuery(), new Danh_gia_don_hang_Mapper() , specification.getParameters());
		
		return list;
	}

	@Override
	public void update(Danh_gia_don_hang t) {
		String query = "UPDATE danh_gia_don_hang SET diem_danh_gia = ?, binh_luan = ? WHERE id_don_hang = ?";
		update(query, t.getDiem_danh_gia(), t.getBinh_luan(), t.getId_don_hang());
	}

	@Override
	public void remove(Danh_gia_don_hang t) {
		// TODO Auto-generated method stub
		
	}

}
