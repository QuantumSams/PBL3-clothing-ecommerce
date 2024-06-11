package Model.DAL.Specification.Implements.Mau_sac;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;

public class FindColorByID implements Specification<Mau_sac>{

	private int id;
	private Object[] objects;
	
	public FindColorByID(int id) {
		this.id = id;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM mau_sac WHERE id_mau_sac = ?";
		
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
