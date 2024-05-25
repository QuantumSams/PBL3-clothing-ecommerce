package Model.DAL.Specification.Implements.Gio_hang;

import Model.DAL.Specification.Specification;
import Model.DTO.Don_Hang.Gio_hang;

public class RemoveByID implements Specification<Gio_hang>{

	private int id;
	private Object[] objects;
	
	public RemoveByID(int id){
		this.id = id;
	}
	
	@Override
	public String getQuery() {
		String query = "DELETE FROM gio_hang WHERE id_gio_hang = ?";
		
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
