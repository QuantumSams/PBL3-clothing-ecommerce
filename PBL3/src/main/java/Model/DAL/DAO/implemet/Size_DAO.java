package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.San_Pham.Muc_san_pham_Mapper;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Size_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class Size_DAO extends AbstractDao implements Repository<Size>{

	@Override
	public void add(Size size) {
		String query = "INSERT INTO size VALUES (?, ?)";
		
		insert(query, 	size.getId_size(), 
						size.getTen_size());
	}

	@Override
	public List<Size> getALL() {
		String sql = "SELECT * FROM size";
		List<Size> list_size = query(sql, new Size_Mapper()); 
		return list_size;
	}

	@Override
	public List<Size> findBySpacification(Specification<Size> specification) {
		List<Size> list = query(specification.getQuery(), new Size_Mapper(), specification.getParameters());
		
		return list;
	}

	@Override
	public void update(Size t) {
		String sql = "UPDATE size SET ten_size = ? WHERE id_size = ?";
		update(sql, t.getTen_size(), t.getId_size());
	}

	@Override
	public void remove(Size t) {
		String sql = "DELETE FROM size WHERE id_size = ?";
		update(sql, t.getId_size());
	}

}
