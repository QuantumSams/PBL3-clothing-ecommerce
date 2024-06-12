package Model.DAL.Specification.Implements.Don_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Danh_gia_don_hang;

public class FindEvaluateByIDOrder implements Specification<Danh_gia_don_hang>{

	private int id_order;
	private Object[] objects;
	
	public FindEvaluateByIDOrder(int id_order){
		this.id_order = id_order;
	}
	
	@Override
	public String getQuery() {
		String sql = "SELECT * FROM danh_gia_don_hang  WHERE id_don_hang = ?";
		
		setParameters(id_order);
		
		return sql;
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
