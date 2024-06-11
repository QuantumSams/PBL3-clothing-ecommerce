package Model.DAL.Specification.Implements.Size;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class FindSizeByID implements Specification<Size>{

	private int id;
	private Object[] objects;
	
	public FindSizeByID(int id) {
		this.id = id;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM size WHERE id_size = ?";
		
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
