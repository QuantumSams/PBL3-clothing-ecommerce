package Model.DAL.Specification.Implements.Gio_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Gio_hang;

public class FindCartByIDUser implements Specification<Gio_hang>{

	private int id_khach_hang;
	private Object[] objects;
	
	public FindCartByIDUser(int id_khach_hang){
		this.id_khach_hang = id_khach_hang;
	}
	
	@Override
	public String getQuery() {
		String query = "SELECT * FROM gio_hang WHERE id_khach_hang = ?";
		
		setParameters(id_khach_hang);
		
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
