package Model.DAL.DAO;

import java.util.List;

import Model.DAL.Mapper.RowMapper;

public interface GenericDAO {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update (String sql, Object... parameters);
	int insert (String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
