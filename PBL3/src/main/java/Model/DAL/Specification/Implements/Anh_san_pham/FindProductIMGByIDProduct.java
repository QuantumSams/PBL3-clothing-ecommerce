package Model.DAL.Specification.Implements.Anh_san_pham;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Anh_san_pham;

public class FindProductIMGByIDProduct implements Specification<Anh_san_pham>{

	private int id_product;
	private Object[] objects;
	
	public FindProductIMGByIDProduct(int id_product) {
		this.id_product = id_product;
	}
	
	@Override
	public String getQuery() {
		String query = " SELECT * FROM anh_san_pham WHERE id_san_pham = ?";
		
		setParameters(id_product);
		
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
