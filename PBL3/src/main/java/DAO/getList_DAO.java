package DAO;

import java.util.List;

public interface getList_DAO {
	public <T> List<T> getList(String query, Object... parameters);
}
