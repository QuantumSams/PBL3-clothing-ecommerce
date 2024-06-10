package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Don_Hang.Don_hang_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Don_hang;

public class Don_hang_DAO extends AbstractDao implements Repository<Don_hang>{

	@Override
	public void add(Don_hang don_hang) {
		
	}


	@Override
	public void update(Don_hang don_hang) {
		
	}


	@Override
	public void remove(Don_hang don_hang) {
		
	}


	@Override
	public List<Don_hang> getALL() {
		StringBuilder Query = new StringBuilder();
		Query.append("SELECT don_hang.id_don_hang, khach_hang.ho_ten AS ten_khach_hang, nhan_vien.ho_ten AS ten_nhan_vien, \r\n");
		Query.append("ngay_gio_dat AS thoi_gian_dat, ngay_gio_nhan AS thoi_gian_nhan, trang_thai_don_hang,\r\n");
		Query.append("chi_tiet.so_luong, chi_tiet.gia_tri, diem_danh_gia AS so_sao_danh_gia\r\n");
		Query.append("FROM don_hang \r\n");
		Query.append("LEFT JOIN thong_tin_dang_nhap AS khach_hang \r\n");
		Query.append("ON khach_hang.id = don_hang.id_khach_hang \r\n");
		Query.append("LEFT JOIN thong_tin_dang_nhap AS nhan_vien \r\n");
		Query.append("ON nhan_vien.id = don_hang.id_nhan_vien\r\n");
		Query.append("LEFT JOIN (\r\n");
		Query.append("	SELECT SUM(so_luong) AS so_luong,\r\n");
		Query.append("		SUM(so_luong * gia_tien) AS gia_tri, \r\n");
		Query.append("		chi_tiet_don_hang.id_don_hang AS id\r\n");
		Query.append("	FROM chi_tiet_don_hang\r\n");
		Query.append("	INNER JOIN don_hang ON chi_tiet_don_hang.id_don_hang = don_hang.id_don_hang\r\n");
		Query.append("	GROUP BY chi_tiet_don_hang.id_don_hang\r\n");
		Query.append(") AS chi_tiet ON chi_tiet.id = don_hang.id_don_hang\r\n");
		Query.append("LEFT JOIN danh_gia_don_hang \r\n");
		Query.append("ON danh_gia_don_hang.id_don_hang = don_hang.id_don_hang\r\n");
		
		List<Don_hang> list = query(Query.toString(), new Don_hang_Mapper());
		return list;
	}


	@Override
	public List<Don_hang> findBySpacification(Specification<Don_hang> specification) {
		List<Don_hang> list = query(specification.getQuery(), new Don_hang_Mapper(), specification.getParameters());
		return list;
	}
}