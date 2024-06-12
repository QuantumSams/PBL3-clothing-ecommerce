package Model.DAL.Specification.Implements.San_pham;

import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.San_pham;

public class FindProductByName implements Specification<San_pham>{

	private String name;
	private Object[] objects;
	
	public FindProductByName(String name) {
		this.name = name;
	}
	
	@Override
	public String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT id_san_pham, danh_muc_san_pham.ten_danh_muc_san_pham, ten_san_pham, ");
		query.append("ten_nhan_hang, ten_chat_lieu, thong_tin_chung, thong_tin_chi_tiet ");
		query.append("FROM san_pham INNER JOIN  danh_muc_san_pham ON san_pham.id_danh_muc_san_pham = danh_muc_san_pham.id_danh_muc_san_pham ");
		query.append("WHERE ten_san_pham LIKE ?");
		
		String search = "%" + name + "%";
		setParameters(search);
		
		return query.toString();
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
