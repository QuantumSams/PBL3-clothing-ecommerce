package Model.DAL.Specification.Implements.Don_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Don_hang;

public class FindOrderByIDUser implements Specification<Don_hang>{

	private int id_order;
	private Object[] objects;
	
	public FindOrderByIDUser(int id_order){
		this.id_order = id_order;
	}
	
	@Override
	public String getQuery() {
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
		Query.append("WHERE don_hang.id_khach_hang = ? ");
		Query.append("ORDER BY thoi_gian_dat DESC ");
		
		setParameters(id_order);
		
		return Query.toString();
	}

	@Override
	public void setParameters(Object... objects) {
		this.objects = objects;
	}

	@Override
	public Object[] getParameters() {
		return objects;
	}

}
