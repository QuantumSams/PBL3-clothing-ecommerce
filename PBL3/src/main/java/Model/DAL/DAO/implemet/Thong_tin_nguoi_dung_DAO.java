package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Nguoi_Dung.Nguoi_dung_Mapper;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;

public class Thong_tin_nguoi_dung_DAO extends AbstractDao implements Repository<Nguoi_dung>{

	@Override
	public void add(Nguoi_dung t) {
		String query = "INSERT INTO thong_tin_nguoi_dung VALUES (?, ?, ?, ?, ?, ?)";
		insert(query, 	t.getId_nguoi_dung(), t.getHo_ten(), t.isGioi_tinh(), 
						t.getNgay_sinh(), t.getDia_chi(), t.getAnh_dai_dien());
	}

	@Override
	public List<Nguoi_dung> getALL() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, ");
		query.append(" thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen");
		query.append(" FROM thong_tin_nguoi_dung");
		query.append(" INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id");
		query.append(" INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung");
//		String sql = 	" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen"
//				+ " FROM thong_tin_nguoi_dung" 
//				+ " INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id"
//				+ " INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung"
//				+ " WHERE id_phan_quyen_nguoi_dung = 2 ";
		return query(query.toString(), new Nguoi_dung_Mapper());
	}

	@Override
	public List<Nguoi_dung> findBySpacification(Specification<Nguoi_dung> specification) {
		List<Nguoi_dung> list = query(specification.getQuery(), new Nguoi_dung_Mapper(), specification.getParameters());
		return list;
	}

	@Override
	public void update(Nguoi_dung t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Nguoi_dung t) {
		// TODO Auto-generated method stub
		
	}

}
