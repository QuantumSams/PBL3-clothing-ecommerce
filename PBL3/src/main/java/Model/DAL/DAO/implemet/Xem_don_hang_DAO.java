package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Don_Hang.Xem_don_hang_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Xem_don_hang;
import Model.DTO.San_Pham.San_pham;

public class Xem_don_hang_DAO extends AbstractDao implements Repository<Xem_don_hang>{

	@Override
	public void add(Xem_don_hang t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Xem_don_hang> getALL() {
//		StringBuilder query = new StringBuilder();
//		query.append("SELECT id_don_hang, thong_tin_nguoi_dung.ho_ten, tong_gia_tri.gia_tri, ");
//		query.append("ngay_gio_dat, ngay_gio_nhan, trang_thai_don_hang");
//		query.append("FROM don_hang ");
//		query.append("left JOIN thong_tin_nguoi_dung ON don_hang.id_nhan_vien = thong_tin_nguoi_dung.id");
//		query.append("left JOIN (");
//		query.append("SELECT don_hang.id_don_hang AS id, SUM(gia_tien * so_luong) AS gia_tri");
//		query.append("FROM don_hang");
//		query.append("INNER JOIN chi_tiet_don_hang ON don_hang.id_don_hang = chi_tiet_don_hang.id_don_hang");
//		query.append("GROUP BY don_hang.id_don_hang");
//		query.append(")AS tong_gia_tri ON tong_gia_tri.id = don_hang.id_don_hang");
		
		String query = "SELECT id_don_hang, thong_tin_nguoi_dung.ho_ten, tong_gia_tri.gia_tri, \r\n"
				+ "ngay_gio_dat, ngay_gio_nhan, trang_thai_don_hang\r\n"
				+ "FROM don_hang \r\n"
				+ "left JOIN thong_tin_nguoi_dung ON don_hang.id_nhan_vien = thong_tin_nguoi_dung.id\r\n"
				+ "left JOIN (\r\n"
				+ "SELECT don_hang.id_don_hang AS id, SUM(gia_tien * so_luong) AS gia_tri\r\n"
				+ "FROM don_hang\r\n"
				+ "INNER JOIN chi_tiet_don_hang ON don_hang.id_don_hang = chi_tiet_don_hang.id_don_hang\r\n"
				+ "GROUP BY don_hang.id_don_hang\r\n"
				+ ")AS tong_gia_tri ON tong_gia_tri.id = don_hang.id_don_hang";
		
		return query(query, new Xem_don_hang_Mapper());
	}

	@Override
	public List<Xem_don_hang> findBySpacification(Specification<Xem_don_hang> specification) {
		return null;
	}

	@Override
	public void update(Xem_don_hang t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Xem_don_hang t) {
		// TODO Auto-generated method stub
		
	}

}
