package Model.DAL.Specification.Implements.San_pham;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.San_pham;

public class FindProductByID  implements Specification<San_pham>{

	private int id;
	private Object[] objects;
	
	public FindProductByID(int id) {
		this.id = id;
	}
	
	@Override
	public String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT id_san_pham, danh_muc_san_pham.ten_danh_muc_san_pham, ten_san_pham, ");
		query.append("ten_nhan_hang, ten_chat_lieu, thong_tin_chung, thong_tin_chi_tiet ");
		query.append("FROM san_pham INNER JOIN  danh_muc_san_pham ON san_pham.id_danh_muc_san_pham = danh_muc_san_pham.id_danh_muc_san_pham ");
		query.append("WHERE id_san_pham = ? ");
		
		setParameters(id);
		
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