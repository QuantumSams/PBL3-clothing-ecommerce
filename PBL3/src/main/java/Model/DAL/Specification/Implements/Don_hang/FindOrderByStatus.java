package Model.DAL.Specification.Implements.Don_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Don_hang;

public class FindOrderByStatus implements Specification<Don_hang>{

	private String status;
	private Object[] objects;
	
	public FindOrderByStatus(String status){
		this.status = status;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM don_hang WHERE trang_thai_don_hang = ?";
		
		setParameters(status);
		
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
