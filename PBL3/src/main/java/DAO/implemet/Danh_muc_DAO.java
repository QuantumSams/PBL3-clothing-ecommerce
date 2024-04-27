package DAO.implemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.JDBC_Unit;
import DAO.AbstractDao;
import Entity.San_Pham.Danh_muc_san_pham;
import Mapper.RowMapper;
import Mapper.San_Pham.Danh_muc_san_pham_Mapper;
import Mapper.San_Pham.San_pham_Mapper;

public class Danh_muc_DAO extends AbstractDao{
	
	public List<Danh_muc_san_pham> LayTatCaDanhMuc(){
		
		String Query = "SELECT * FROM danh_muc_san_pham";
		List<Danh_muc_san_pham> list = query(Query, new Danh_muc_san_pham_Mapper());
		return list;
		
	}
	
	public List<String> GetItem(String query, Object... parameters){
		List<String> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBC_Unit.getConnection();
			statement = connection.prepareStatement(query);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(resultSet.getString(1));
			}
			
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}
}
