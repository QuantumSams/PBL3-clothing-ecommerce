package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Nguoi_Dung.Nguoi_dung_Mapper;
import Model.DAL.Mapper.San_Pham.Gio_hang_Mapper;
import Model.DAL.Repository.RemoveRepository;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Gio_hang;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.Muc_san_pham;



public class Gio_hang_DAO extends AbstractDao implements Repository<Gio_hang>, RemoveRepository<Gio_hang>{
	
	@Override
	public void add(Gio_hang gio_hang) {
		String query = "INSERT INTO gio_hang VALUES (?, ?, ?, ?)";
		insert(query, gio_hang.getId_gio_hang(), gio_hang.getId_khach_hang(), gio_hang.getId_muc_san_pham(), gio_hang.getSo_luong());
	}
	
	@Override
	public List<Gio_hang> getALL() {
		String query = "SELECT * FROM gio_hang";
		return query(query, new Gio_hang_Mapper());
	}

	@Override
	public List<Gio_hang> findBySpacification(Specification<Gio_hang> specification) {
		List<Gio_hang> list = query(specification.getQuery(), new Gio_hang_Mapper(), specification.getParameters());
		
		return list;
	}

	@Override
	public void update(Gio_hang t) {
		String query = "UPDATE gio_hang SET id_khach_hang = ?, id_muc_san_pham = ?, so_luong = ?, WHERE id_gio_hang = ?";
		update(query, t.getId_gio_hang());
	}

	@Override
	public void remove(Gio_hang t) {
		String query = "DELETE FROM gio_hang WHERE id_gio_hang = ?";
		update(query, t.getId_gio_hang());
	}

	@Override
	public void removeBySpacification(Specification<Gio_hang> specification) {
		update(specification.getQuery(), specification.getParameters());
	}

}
