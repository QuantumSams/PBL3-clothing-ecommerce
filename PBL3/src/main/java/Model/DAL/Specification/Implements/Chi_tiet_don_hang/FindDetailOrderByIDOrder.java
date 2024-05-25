package Model.DAL.Specification.Implements.Chi_tiet_don_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Chi_tiet_don_hang;
import Model.DTO.Don_Hang.Don_hang;

public class FindDetailOrderByIDOrder  implements Specification<Chi_tiet_don_hang>{

	private int id_order;
	private Object[] objects;
	
	public FindDetailOrderByIDOrder(int id_order){
		this.id_order = id_order;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM chi_tiet_don_hang WHERE id_don_hang = ?";
		
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
