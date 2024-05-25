package Model.DAL.Specification.Implements.Muc_san_pham;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Muc_san_pham;

public class FindProductItemByIDProduct implements Specification<Muc_san_pham>{

	private int id;
	private Object[] objects;
	
	public FindProductItemByIDProduct(int id) {
		this.id = id;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM muc_san_pham WHERE id_san_pham = ?";
		
		setParameters(id);
		
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
