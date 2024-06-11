package Model.DAL.Specification.Implements.San_pham;

import Model.DAL.Specification.Specification;
import Model.DTO.San_Pham.Muc_san_pham;

public class UpdatePriceQuatityItemProduct implements Specification<Muc_san_pham>{

	private int price;
	private int quatity;
	private int id;
	
	private Object[] objects;
	
	public UpdatePriceQuatityItemProduct(int price, int quatity, int id) {
		this.price = price;
		this.quatity = quatity;
		this.id = id;
	}

	@Override
	public String getQuery() {
		
		String sql = "UPDATE muc_san_pham SET so_luong_trong_kho = ?, gia_tien = ? WHERE id_muc_san_pham = ?";
			
		setParameters(quatity, price, id);
		
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
