package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Nguoi_Dung.Nguoi_dung_Mapper;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Anh_san_pham_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Anh_san_pham;

public class Anh_san_pham_DAO  extends AbstractDao implements Repository<Anh_san_pham>{

	@Override
	public void add(Anh_san_pham t) {
		String query = "INSERT INTO anh_san_pham VALUES (?, ?, ?)";
		
		insert(query, t.getId_anh(), t.getId_san_pham(), t.getDuong_dan_anh());
	}

	@Override
	public List<Anh_san_pham> getALL() {
		String query = "SELECT * FROM anh_san_pham ";
		List<Anh_san_pham> list = query(query, new Anh_san_pham_Mapper());
		return list;
	}

	@Override
	public List<Anh_san_pham> findBySpacification(Specification<Anh_san_pham> specification) {
		List<Anh_san_pham> list = query(specification.getQuery(), new Anh_san_pham_Mapper(), specification.getParameters());
		
		return list;
	}

	@Override
	public void update(Anh_san_pham t) {
		String query = "UPDATE anh_san_pham SET id_san_pham = ?, duong_dan_anh = ? WHERE id_anh = ?";
		update(query, t.getId_san_pham(), t.getDuong_dan_anh(), t.getId_anh());
	}

	@Override
	public void remove(Anh_san_pham t) {
		String query = "DELETE FROM anh_san_pham WHERE id_anh = ?";
		update(query, t.getId_anh());
	}

}
