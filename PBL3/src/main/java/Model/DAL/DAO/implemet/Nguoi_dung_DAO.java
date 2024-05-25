package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Nguoi_Dung.Nguoi_dung_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class Nguoi_dung_DAO extends AbstractDao implements Repository<Nguoi_dung>{
	
	public void update_password(int id, String new_password) {
		String query = " UPDATE thong_tin_dang_nhap SET mat_khau = ? WHERE id = ?";
		update(query, new_password, id);
	}
	
	@Override
	public void add(Nguoi_dung t) {
		String query1 = "INSERT INTO thong_tin_dang_nhap VALUES (?, ?, ?, ?, ?);";
		String query2 = "INSERT INTO thong_tin_nguoi_dung VALUES (?, ?, ?, ?, ?, ?)";
		
		insert(query1, t.getId_nguoi_dung(), t.getSo_dien_thoai(), t.getEmail(), t.getPassword(), 1);
		insert(query2, t.getId_nguoi_dung(), t.getHo_ten(), t.isGioi_tinh(), t.getNgay_sinh(), t.getDia_chi(), t.getAnh_dai_dien());
	}

	@Override
	public List<Nguoi_dung> getALL() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, ");
		query.append(" thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen");
		query.append(" FROM thong_tin_nguoi_dung");
		query.append(" INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id");
		query.append(" INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung");

		return query(query.toString(), new Nguoi_dung_Mapper());
	}

	@Override
	public List<Nguoi_dung> findBySpacification(Specification<Nguoi_dung> specification) {
		List<Nguoi_dung> list = query(specification.getQuery(), new Nguoi_dung_Mapper(), specification.getParameters());
		
		return list;
	}

	@Override
	public void update(Nguoi_dung t) {
		String sql1 = "UPDATE thong_tin_dang_nhap SET so_dien_thoai = ?, email = ? WHERE id = ?;";
		String sql2 = "UPDATE thong_tin_nguoi_dung SET ho_ten = ?, gioi_tinh = ?, ngay_sinh = ?, dia_chi = ?, anh_dai_dien = ? WHERE id = ?;";
		
		update(sql1, t.getSo_dien_thoai(), t.getEmail(), t.getId_nguoi_dung());
		update(sql2, t.getHo_ten(), t.isGioi_tinh(), t.getNgay_sinh(), t.getDia_chi() , t.getAnh_dai_dien(), t.getId_nguoi_dung());
	}

	@Override
	public void remove(Nguoi_dung t) {
		String sql1 = "DELETE FROM thong_tin_nguoi_dung WHERE id = ?;";
		String sql2 = "DELETE FROM thong_tin_dang_nhap WHERE id = ?;";
		
		update(sql1, t.getId_nguoi_dung());
		update(sql2, t.getId_nguoi_dung());
	}
}
