package Model.DAL.DAO.implemet;

import java.util.List;
import java.util.Random;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.San_Pham.Muc_san_pham_Mapper;
import Model.DAL.Mapper.San_Pham.San_pham_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Repository.UpdateRepository;
import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;

public class Muc_san_pham_DAO extends AbstractDao implements Repository<Muc_san_pham>, UpdateRepository<Muc_san_pham>{

	@Override
	public void add(Muc_san_pham muc_san_pham) {
		String query = "INSERT INTO muc_san_pham VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		insert(query, 	muc_san_pham.getId_muc_san_pham(), 
						muc_san_pham.getId_san_pham(),
						muc_san_pham.getSo_luong_trong_kho(),
						muc_san_pham.getMau_sac_san_pham().getId_mau_sac(),
						muc_san_pham.getKich_thuoc_san_pham().getId_size(),
						muc_san_pham.getGia_tien(),
						muc_san_pham.getAnh_chi_tiet()
						);
	}

	@Override
	public List<Muc_san_pham> getALL() {
		String query = "SELECT * FROM muc_san_pham";
		
		return query(query, new Muc_san_pham_Mapper());
	}

	@Override
	public List<Muc_san_pham> findBySpacification(Specification<Muc_san_pham> specification) {
		List<Muc_san_pham> list = query(specification.getQuery(), new Muc_san_pham_Mapper(), specification.getParameters());
		
		return list;
	}

	@Override
	public void update(Muc_san_pham muc_san_pham) {
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE muc_san_pham SET id_san_pham = ?, so_luong_trong_kho = ?, ");
		query.append("id_mau_sac = ?, id_size = ?, gia_tien = ?, anh_muc_san_pham = ?");
		query.append("WHERE id_muc_san_pham = ? ");
		
		insert(query.toString(), 	muc_san_pham.getId_san_pham(),
									muc_san_pham.getSo_luong_trong_kho(),
									muc_san_pham.getMau_sac_san_pham().getId_mau_sac(),
									muc_san_pham.getKich_thuoc_san_pham().getId_size(),
									muc_san_pham.getGia_tien(),
									muc_san_pham.getAnh_chi_tiet(),
									muc_san_pham.getId_muc_san_pham()
									);
	}

	@Override
	public void remove(Muc_san_pham t) {
		String query = "DELETE FROM muc_san_pham WHERE id_muc_san_pham = ?";
		update(query, t.getId_muc_san_pham());
	}

	@Override
	public void updateBySpacification(Specification<Muc_san_pham> specification) {
		query(specification.getQuery(), specification.getParameters());
	}

}
