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
		String query = "SELECT * FROM don_hang WHERE id_khach_hang = ?";
		
		setParameters(id_order);
		
		return query;
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
