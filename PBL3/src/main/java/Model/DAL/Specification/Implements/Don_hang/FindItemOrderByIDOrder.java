package Model.DAL.Specification.Implements.Don_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Muc_sp_don_hang;

public class FindItemOrderByIDOrder implements Specification<Muc_sp_don_hang>{

	private int id_order;
	private Object[] objects;
	
	public FindItemOrderByIDOrder(int id_order) {
		this.id_order = id_order;
	}
	
	@Override
	public String getQuery() {
		
		String Query = "SELECT chi_tiet_don_hang.id_muc_san_pham, chi_tiet.ten_san_pham, chi_tiet.ten_size, chi_tiet.ten_mau, \r\n"
				+ "so_luong, gia_tien, anh_muc_san_pham\r\n"
				+ "FROM chi_tiet_don_hang\r\n"
				+ "INNER JOIN (\r\n"
				+ "	SELECT muc_san_pham.id_muc_san_pham, ten_san_pham, \r\n"
				+ "		size.ten_size , mau_sac.ten_mau, anh_muc_san_pham\r\n"
				+ "	FROM muc_san_pham\r\n"
				+ "	INNER JOIN size ON size.id_size = muc_san_pham.id_size\r\n"
				+ "	INNER JOIN mau_sac ON mau_sac.id_mau_sac = muc_san_pham.id_mau_sac\r\n"
				+ "	INNER JOIN san_pham ON san_pham.id_san_pham = muc_san_pham.id_san_pham\r\n"
				+ ") AS chi_tiet ON chi_tiet.id_muc_san_pham = chi_tiet_don_hang.id_muc_san_pham\r\n"
				+ "WHERE chi_tiet_don_hang.id_don_hang = ? ";
		
		setParameters(id_order);
		
		return Query;
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
