package Model.DAL.Specification.Implements.Muc_san_pham;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Muc_san_pham;

public class FindProductItemByName implements Specification<Muc_san_pham>{

	private String search;
	private Object[] objects;
	
	public FindProductItemByName(String search) {
		this.search = search;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM muc_san_pham\r\n"
				+ "LEFT JOIN san_pham ON san_pham.id_san_pham = muc_san_pham.id_san_pham\r\n"
				+ "WHERE ten_san_pham LIKE ? ";
		String s = "%"+search+"%";
		setParameters(s);
		
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
